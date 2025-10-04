package org.example.kinoxp.services;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.ScreenDto;
import org.example.kinoxp.mappers.ScreenMapper;
import org.example.kinoxp.repositories.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final ScreenMapper screenMapper;

    public List<ScreenDto> getAll() {
        var screens = screenRepository.findAll();

        return screens.stream().map(screenMapper::toDto).toList();
    }
}
