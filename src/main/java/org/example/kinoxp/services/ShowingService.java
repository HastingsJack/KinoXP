package org.example.kinoxp.services;

import org.example.kinoxp.dto.ShowingDto;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.repositories.ShowingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowingService {

    private final ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    public List<ShowingDto> getAllShowings() {
        List<Showing> rawShowings = showingRepository.findAll();
        List<ShowingDto> showingDtos = new ArrayList<>();
        for (Showing showing : rawShowings) {
            showingDtos.add(toDto(showing));
        }

        return showingDtos;
    }


    public static ShowingDto toDto(Showing showing) {
        ShowingDto dto = new ShowingDto();
        dto.setId(showing.getId());
        dto.setPrice(showing.getPrice());
        dto.setStartTime(showing.getStartTime());
        dto.setEndTime(showing.getEndTime());

        // Movie
        dto.setMovieId(showing.getMovie().getId());
        dto.setMovieTitle(showing.getMovie().getTitle());
        dto.setMovieDescription(showing.getMovie().getDescription());
        dto.setMovieLength(showing.getMovie().getMovieLength());
        dto.setMovieImg(showing.getMovie().getMovieImg());
        dto.setMovieAgeLimit(showing.getMovie().getAgeLimit());

        // Screen
        dto.setScreenId(showing.getScreen().getId());
        dto.setScreenName(showing.getScreen().getName());
        dto.setSeatRows(showing.getScreen().getSeatRows());
        dto.setSeatColumns(showing.getScreen().getSeatColumns());

        // Period
        dto.setPeriodId(showing.getPeriod().getId());
        dto.setPeriodStartDate(showing.getPeriod().getStartDate());
        dto.setPeriodOngoing(showing.getPeriod().getOngoing());

        return dto;
    }
}
