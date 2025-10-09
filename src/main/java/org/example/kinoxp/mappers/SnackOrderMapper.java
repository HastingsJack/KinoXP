package org.example.kinoxp.mappers;

import org.example.kinoxp.dtos.snackOrderDtos.RegisterSnackOrderDto;
import org.example.kinoxp.dtos.snackOrderDtos.SnackOrderDto;
import org.example.kinoxp.dtos.ticketDtos.RegisterTicketDto;
import org.example.kinoxp.models.SnackOrder;
import org.example.kinoxp.models.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SnackOrderMapper {
    SnackOrderDto toDto(SnackOrder snackOrder);

    SnackOrder toModel(RegisterSnackOrderDto request);
}
