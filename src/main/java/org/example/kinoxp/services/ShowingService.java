package org.example.kinoxp.services;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.showingDtos.RegisterShowingDto;
import org.example.kinoxp.dtos.showingDtos.ShowingDto;
import org.example.kinoxp.mappers.ShowingMapper;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.repositories.ShowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ShowingService {
    private final ShowingRepository showingRepository;
    private final ShowingMapper showingMapper;

    public List<ShowingDto> getAll(Long movieId) {
        List<Showing> showings;
        if(movieId != null)
            showings = showingRepository.findByMovieId(movieId);
        else
            showings = showingRepository.findAll();

        // Maps all Showing objects to ShowingDto objects
        return  showings.stream().map(showingMapper::toDto).toList();
    }

    public ShowingDto createShowing(RegisterShowingDto request) {
        var showing = showingMapper.toModel(request);
        showingRepository.save(showing);

        return showingMapper.toDto(showing);
    }
}
