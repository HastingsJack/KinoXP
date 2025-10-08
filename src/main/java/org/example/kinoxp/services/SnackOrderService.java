package org.example.kinoxp.services;

import org.example.kinoxp.dtos.snackOrderDtos.RegisterSnackOrderDto;
import org.example.kinoxp.dtos.snackOrderDtos.SnackOrderDto;
import org.example.kinoxp.dtos.ticketDtos.RegisterTicketDto;
import org.example.kinoxp.dtos.ticketDtos.TicketDto;
import org.example.kinoxp.mappers.SnackOrderMapper;
import org.example.kinoxp.repositories.SnackOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class SnackOrderService {

    private final SnackOrderRepository snackOrderRepository;
    private final SnackOrderMapper snackOrderMapper;

    public SnackOrderService(SnackOrderRepository snackOrderRepository, SnackOrderMapper snackOrderMapper) {
        this.snackOrderRepository = snackOrderRepository;
        this.snackOrderMapper = snackOrderMapper;
    }

    public SnackOrderDto createSnackOrder(RegisterSnackOrderDto request){
        var snackOrder = snackOrderMapper.toModel(request);
        snackOrderRepository.save(snackOrder);

        request.setId(snackOrder.getId());
        return snackOrderMapper.toDto(snackOrder);

    }
}
