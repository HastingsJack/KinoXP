package org.example.kinoxp.mappers;

import org.example.kinoxp.dtos.showingDtos.RegisterShowingDto;
import org.example.kinoxp.dtos.showingDtos.ShowingDto;
import org.example.kinoxp.dtos.showingDtos.ShowingTicketDto;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.models.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShowingMapper {

    ShowingDto toDto(Showing showing);
    // When you got a List in your DTO. You need to map it to the list in you're DTO model
    ShowingTicketDto toTicketDto(Ticket ticket);

    Showing toModel(RegisterShowingDto request);
}
