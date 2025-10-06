package org.example.kinoxp.services;

import org.example.kinoxp.dtos.SnackDto;
import org.example.kinoxp.mappers.SnackMapper;
import org.example.kinoxp.models.Snack;
import org.example.kinoxp.repositories.SnackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SnackServiceTest {

    @Mock
    private SnackRepository snackRepository;

    @Mock
    private SnackMapper snackMapper;

    @InjectMocks
    private SnackService snackService;

    List<Snack> snacks = new ArrayList<>();
    List<SnackDto> snackDtos = new ArrayList<>();
    Snack snack1 = new Snack();
    Snack snack2 = new Snack();
    SnackDto snackDto1 = new SnackDto();
    SnackDto snackDto2 = new SnackDto();

    // Arrange
    @BeforeEach
    void setUp() {
        snack1.setId(1);
        snack1.setName("Snack 1");
        snack1.setSize("medium");
        snack1.setPrice(10.0);
        snack1.setSnackImg("snack1.jpg");
        snack1.setDescription("Snack 1 description");
        snacks.add(snack1);

        snackDto1.setId(1);
        snackDto1.setName("Snack 1");
        snackDto1.setSize("medium");
        snackDto1.setPrice(10.0);
        snackDto1.setSnackImg("snack1.jpg");
        snackDto1.setDescription("Snack 1 description");
        snackDtos.add(snackDto1);

        snack2.setId(2);
        snack2.setName("Snack 2");
        snack2.setSize("large");
        snack2.setPrice(20.0);
        snack2.setSnackImg("snack2.jpg");
        snack2.setDescription("Snack 2 description");
        snacks.add(snack2);

        snackDto2.setId(2);
        snackDto2.setName("Snack 2");
        snackDto2.setSize("large");
        snackDto2.setPrice(20.0);
        snackDto2.setSnackImg("snack2.jpg");
        snackDto2.setDescription("Snack 2 description");
        snackDtos.add(snackDto2);
    }

    @Test
    void getAllSnacks() {
        // Arrange
        when(snackRepository.findAll()).thenReturn(snacks);
        when(snackMapper.toDto(snack1)).thenReturn(snackDto1);
        when(snackMapper.toDto(snack2)).thenReturn(snackDto2);
        // Act
        var snacksDto = snackService.getAllSnacks();

        // Assert
        assertEquals(snackDtos, snacksDto);
    }

    @Test
    void createSnacks() {
        // Arrange
        when(snackRepository.save(snack1)).thenReturn(snack1);
        when(snackMapper.toModel(snackDto1)).thenReturn(snack1);

        // Act
        var snackDto = snackService.createSnacks(snackDto1);

        // Assert
        assertEquals(snackDto1, snackDto);
    }

    @Test
    void updateSnack() {
        // Arrange
        when(snackRepository.findById(1)).thenReturn(Optional.of(snack1));
        // when a method i void, we can use doNothing()
        //doNothing().when(snackMapper).update(any(SnackDto.class), any(Snack.class));
        // I want it to change the object therefor i can use doAnswer.
        // We simulate how the MapStruct update method works.
        doAnswer(invocation -> {
            SnackDto dto = invocation.getArgument(0);
            Snack model = invocation.getArgument(1);
            model.setName(dto.getName());
            model.setSize(dto.getSize());
            model.setPrice(dto.getPrice());
            model.setSnackImg(dto.getSnackImg());
            model.setDescription(dto.getDescription());
            return null;
        }).when(snackMapper).update(any(SnackDto.class), any(Snack.class));
        when(snackRepository.save(snack1)).thenReturn(snack1);

        // Act
        var snack = snackRepository.findById(1).orElse(null);
        snackMapper.update(snackDto1, snack);
        snackRepository.save(snack);

        // Assert
        assertEquals(snackDto1, snack);

    }

    @Test
    void deleteSnack() {
    }
}