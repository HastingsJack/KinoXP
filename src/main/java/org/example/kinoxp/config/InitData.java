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
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.kinoxp.models.enums.Role.ADMIN;

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

    @Override
    public void run(String... args) throws Exception {
        var snack = new Snack();
        snack.setName("Snack 1");
        snack.setSize("medium");
        snack.setPrice(10.0);
        snack.setSnackImg("snack1.jpg");
        snack.setDescription("Snack 1 description");
        snackRepository.save(snack);

        var snack2 = new Snack();
        snack2.setName("Snack 2");
        snack2.setSize("large");
        snack2.setPrice(20.0);
        snack2.setSnackImg("snack2.jpg");
        snack2.setDescription("Snack 2 description");
        snackRepository.save(snack2);

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

        long[] movieIds = {617126, 1054867, 1387190, 1038392};
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
        user.setPassword("password123");
        user.setAge(99);
        user.setEmail("adminEmail@email.com");
        user.setRole(ADMIN);
        userRepository.save(user);
    }
}
