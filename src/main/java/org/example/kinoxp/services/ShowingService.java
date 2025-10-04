package org.example.kinoxp.services;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.showingDtos.RegisterShowingDto;
import org.example.kinoxp.dtos.showingDtos.ShowingDto;
import org.example.kinoxp.exceptions.MovieNotFoundException;
import org.example.kinoxp.exceptions.ScreenNotFoundException;
import org.example.kinoxp.exceptions.ShowingNotFoundException;
import org.example.kinoxp.mappers.ShowingMapper;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.repositories.MovieRepository;
import org.example.kinoxp.repositories.ScreenRepository;
import org.example.kinoxp.repositories.ShowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ShowingService {
    private final ShowingRepository showingRepository;
    private final ShowingMapper showingMapper;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

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

        request.setId(showing.getId());
        return showingMapper.toDto(showing);
    }

    public ShowingDto updateShowing(Long id, RegisterShowingDto request) {
        var showing = showingRepository.findById(id).orElse(null);
        if(showing == null) throw new ShowingNotFoundException();

        var movie = movieRepository.findById(request.getMovie().getId()).orElse(null);
        if(movie == null) throw new MovieNotFoundException();
        showing.setMovie(movie);

        var screen = screenRepository.findById(request.getScreen().getId()).orElse(null);
        if(screen == null) throw new ScreenNotFoundException();
        showing.setScreen(screen);

        request.setId(showing.getId());
        showingMapper.update(request, showing);
        showingRepository.save(showing);

        return showingMapper.toDto(showing);
    }
}
