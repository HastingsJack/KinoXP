package org.example.kinoxp.mappers;

import org.example.kinoxp.dtos.showingDtos.*;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.models.Ticket;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ShowingMapper {

    ShowingDto toDto(Showing showing);
    // When you got a List in your DTO. You need to map it to the list from your DTO to model
    ShowingTicketDto toTicketDto(Ticket ticket);

    Showing toModel(RegisterShowingDto request);

    void update(RegisterShowingDto request, @MappingTarget Showing showing);
}
