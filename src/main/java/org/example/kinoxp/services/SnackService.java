package org.example.kinoxp.services;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dto.SnackDto;
import org.example.kinoxp.exceptions.SnackNotFoundException;
import org.example.kinoxp.mappers.SnackMapper;
import org.example.kinoxp.repositories.SnackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SnackService {
    SnackRepository snackRepository;
    SnackMapper snackMapper;

    public List<SnackDto> getAllSnacks(){
        var snacks = snackRepository.findAll();

        // Convert List to DTO
        return snacks.stream().map(snackMapper::toDto).toList();
    }

    public SnackDto createSnacks(SnackDto snackDto) {
        var snack = snackMapper.toModel(snackDto);
        snackRepository.save(snack);
        snackDto.setId(snack.getId());

        return snackDto;
    }

    public SnackDto updateSnack(Integer id, SnackDto request) {
        var snack = snackRepository.findById(id).orElse(null);
        if(snack == null) throw new SnackNotFoundException();

        request.setId(id);
        snackMapper.update(request, snack);
        snackRepository.save(snack);

        return request;
    }
}
