package org.example.kinoxp.mappers;


import org.example.kinoxp.dtos.showingDtos.RegisterShowingDto;
import org.example.kinoxp.dtos.showingDtos.ShowingDto;
import org.example.kinoxp.dtos.ticketDtos.RegisterTicketDto;
import org.example.kinoxp.dtos.ticketDtos.TicketDto;
import org.example.kinoxp.dtos.ticketDtos.TicketSnackOrderDto;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.models.SnackOrder;
import org.example.kinoxp.models.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDto toDto(Ticket ticket);

    TicketSnackOrderDto toSnackOrderDto(SnackOrder snackOrder);

    Ticket toModel(RegisterTicketDto request);
}
