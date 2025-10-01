package org.example.kinoxp.config;


import lombok.AllArgsConstructor;
import org.example.kinoxp.models.Movie;
import org.example.kinoxp.models.Snack;
import org.example.kinoxp.repositories.SnackRepository;
import org.example.kinoxp.services.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Let's create a class that will be executed when the application starts
// With the data we want to have in the database

@AllArgsConstructor
@Component
public class InitData implements CommandLineRunner {
    SnackRepository snackRepository;
    MovieService movieService;

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

        long[] movieIds = {617126, 1054867, 1387190, 1038392};

        for (long movieId : movieIds) {
            movieService.fetchAndSaveMovie(movieId);
        }
    }
}
