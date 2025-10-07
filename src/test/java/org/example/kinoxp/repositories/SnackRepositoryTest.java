package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Snack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

//@AllArgsConstructor
@DataJpaTest
@ActiveProfiles("test")
class SnackRepositoryTest {
    @Autowired
    private SnackRepository snackRepository;

    Snack snack1 = new Snack();
    Snack snack2 = new Snack();

    // Arrange
    @BeforeEach
    void setUp() {
        snack1.setName("Snack 1");
        snack1.setSize("medium");
        snack1.setPrice(10.0);
        snack1.setSnackImg("snack1.jpg");
        snack1.setDescription("Snack 1 description");
        snackRepository.save(snack1);

        snack2.setName("Snack 2");
        snack2.setSize("large");
        snack2.setPrice(20.0);
        snack2.setSnackImg("snack2.jpg");
        snack2.setDescription("Snack 2 description");
        snackRepository.save(snack2);
    }

    @Test
    void shouldFindSnackById() {
        // Act
        var snack = snackRepository.findById(1).orElse(null);

        // Arrange
        assertNotNull(snack);
        assertEquals(snack1, snack);
    }

    @Test
    void shouldDeleteASnack() {
        // Act
        snackRepository.delete(snack1);
        var snackDeleted = snackRepository.findById(1).orElse(null);

        // Assert
        assertNull(snackDeleted);
    }

//    @Test
//    void shouldUpdateASnack() {
//        // Act
//        snack1.setName("Snack 1 updated");
//        snackRepository.save(snack1);
//        var snackUpdated = snackRepository.findById(1).orElse(null);
//
//        // Assert
//        assertNotNull(snackUpdated);
//        assertEquals(snack1, snackUpdated);
//    }


}