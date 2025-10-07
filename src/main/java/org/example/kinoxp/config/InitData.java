package org.example.kinoxp.config;


import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.MoviePeriodDto;
import org.example.kinoxp.models.Screen;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.models.Snack;
import org.example.kinoxp.models.User;
import org.example.kinoxp.repositories.ScreenRepository;
import org.example.kinoxp.repositories.ShowingRepository;
import org.example.kinoxp.repositories.SnackRepository;
import org.example.kinoxp.services.MovieService;
import org.example.kinoxp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.kinoxp.models.enums.Role.ADMIN;
import static org.example.kinoxp.models.enums.Role.EMPLOYEE;

// Let's create a class that will be executed when the application starts
// With the data we want to have in the database

@AllArgsConstructor
@Component
public class InitData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final SnackRepository snackRepository;
    private final MovieService movieService;
    private final ShowingRepository showingRepository;
    private final ScreenRepository screenRepository;
    // We need this to encode the password
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        var snack = new Snack();
        snack.setName("Popcorn");
        snack.setSize("Medium");
        snack.setPrice(10.0);
        snack.setSnackImg("https://images.unsplash.com/photo-1691480213129-106b2c7d1ee8?q=80&w=580&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        snack.setDescription("");
        snackRepository.save(snack);

        var snack2 = new Snack();
        snack2.setName("Popcorn");
        snack2.setSize("Large");
        snack2.setPrice(20.0);
        snack2.setSnackImg("https://images.unsplash.com/photo-1691480213129-106b2c7d1ee8?q=80&w=580&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        snack2.setDescription("");
        snackRepository.save(snack2);

        var snack3 = new Snack();
        snack3.setName("Popcorn");
        snack3.setSize("Small");
        snack3.setPrice(5.0);
        snack3.setSnackImg("https://images.unsplash.com/photo-1691480213129-106b2c7d1ee8?q=80&w=580&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        snack3.setDescription("");
        snackRepository.save(snack3);

        var snack4 = new Snack();
        snack4.setName("Flaskevand");
        snack4.setSize("");
        snack4.setPrice(5.0);
        snack4.setSnackImg("https://plus.unsplash.com/premium_photo-1681284939219-acfc2faa7eb8?q=80&w=387&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        snack4.setDescription("");
        snackRepository.save(snack4);

        var snack5 = new Snack();
        snack5.setName("Haribo Guldbamser");
        snack5.setSize("");
        snack5.setPrice(7.5);
        snack5.setSnackImg("https://img.imageboss.me/mdkp/height/350/format:auto/PIM/IMG/DK/50039708.jpg");
        snack5.setDescription("");
        snackRepository.save(snack5);

        var snack6 = new Snack();
        snack6.setName("Haribo Matador");
        snack6.setSize("");
        snack6.setPrice(7.5);
        snack6.setSnackImg("https://cdn.lomax.dk/images/t_item_large/f_auto/v1589523719/produkter/3739900/haribo-matador-mix-120-g.jpg");
        snack6.setDescription("");
        snackRepository.save(snack6);

        List<Screen> screens = new ArrayList<>();
        Screen big = new Screen();
        big.setName("Big");
        big.setSeatRows(25);
        big.setSeatColumns(16);
        screens.add(big);

        Screen small = new Screen();
        small.setName("Small");
        small.setSeatRows(20);
        small.setSeatColumns(12);
        screens.add(small);
        screenRepository.saveAll(screens);
        long[] movieIds = {617126, 1054867, 1311031,1202152, 1038392};
        MoviePeriodDto dto = new MoviePeriodDto();
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusDays(20);
        dto.setStartDate(today);
        dto.setEndDate(future);

        List<Showing> showings = new ArrayList<>();

        var random = new Random();
        for (long movieId : movieIds) {
            var movie = movieService.fetchAndSaveMovie(movieId, dto);

            var showing = new Showing();
            showing.setMovie(movie);
            showing.setPrice(10.0);
            showing.setDate(LocalDate.now());
            showing.setStartTime(LocalTime.now());
            showing.setEndTime(LocalTime.now().plusHours(2));

            showing.setScreen(screens.get(random.nextInt(screens.size())));
            showings.add(showing);
        }


        showingRepository.saveAll(showings);

        var user = new User();
        user.setName("Admin1");
        user.setPassword(passwordEncoder.encode("password123"));
        user.setAge(99);
        user.setEmail("adminEmail@email.com");
        user.setRole(ADMIN);
        userRepository.save(user);

        var user2 = new User();
        user2.setName("Employee1");
        user2.setPassword(passwordEncoder.encode("password123"));
        user2.setAge(23);
        user2.setEmail("Employee1Email@email.com");
        user2.setRole(EMPLOYEE);
        userRepository.save(user2);

        var user3 = new User();
        user3.setName("Employee2");
        user3.setPassword(passwordEncoder.encode("password123"));
        user3.setAge(34);
        user3.setEmail("hello@email.com");
        user3.setRole(EMPLOYEE);
        userRepository.save(user3);

        var user4 = new User();
        user4.setName("Employee3");
        user4.setPassword(passwordEncoder.encode("ilikecats321"));
        user4.setAge(43);
        user4.setEmail("meow@email.com");
        user4.setRole(EMPLOYEE);
        userRepository.save(user4);

    }
}
