package org.example.kinoxp.services;


import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.showingDtos.RegisterShowingDto;
import org.example.kinoxp.dtos.showingDtos.ShowingDto;
import org.example.kinoxp.dtos.ticketDtos.RegisterTicketDto;
import org.example.kinoxp.dtos.ticketDtos.TicketDto;
import org.example.kinoxp.exceptions.*;
import org.example.kinoxp.mappers.TicketMapper;
import org.example.kinoxp.repositories.TicketRepository;
import org.springframework.stereotype.Service;
@Service
public class TicketService {

    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    public TicketService(TicketMapper ticketMapper, TicketRepository ticketRepository) {
        this.ticketMapper = ticketMapper;
        this.ticketRepository = ticketRepository;
    }

    public TicketDto createTicket(RegisterTicketDto request){
        var ticket = ticketMapper.toModel(request);
        ticketRepository.save(ticket);

        request.setId(ticket.getId());
        return ticketMapper.toDto(ticket);

    }

    public TicketDto updateTicket(Long id, RegisterTicketDto request) {
        var ticket = ticketRepository.findById(id).orElse(null);
        if(ticket == null) throw new TicketNotFoundException();

        return ticketMapper.toDto(ticket);
    }

    public boolean deleteTicket(Long id) {
        var ticketToDelete = ticketRepository.findById(id).orElse(null);
        if(ticketToDelete == null){
            throw new TicketNotFoundException();
        }else{
            ticketRepository.delete(ticketToDelete);
            return true;
        }
    }
}
