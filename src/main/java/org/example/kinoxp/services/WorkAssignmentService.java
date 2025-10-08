package org.example.kinoxp.services;

import jakarta.validation.Valid;
import org.example.kinoxp.dtos.workAssignmentDtos.WorkAssignmentDto;
import org.example.kinoxp.exceptions.WorkAssignmentNotFoundException;
import org.example.kinoxp.mappers.WorkAssignmentMapper;
import org.example.kinoxp.models.WorkAssignment;
import org.example.kinoxp.repositories.WorkAssignmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkAssignmentService {

    private WorkAssignmentMapper workAssignmentMapper;
    private WorkAssignmentRepository workAssignmentRepository;

    public WorkAssignmentService(WorkAssignmentMapper workAssignmentMapper, WorkAssignmentRepository workAssignmentRepository) {
        this.workAssignmentMapper = workAssignmentMapper;
        this.workAssignmentRepository = workAssignmentRepository;
    }


    public List<WorkAssignmentDto> getShifts(LocalDate start, LocalDate end) {
        List<WorkAssignment> shifts = new ArrayList<>();
        var shiftsDTO = new ArrayList<WorkAssignmentDto>();

        //here we figure out what the format of the URL was used, and use appropiate methods:
        if (start != null && end != null) {
            shifts = workAssignmentRepository.findByDateBetween(start, end);

        } else if (start != null) {
            shifts = workAssignmentRepository.findByDateGreaterThanEqual(start);
        } else if (end != null) {
            shifts = workAssignmentRepository.findByDateLessThanEqual(end);
        } else {
            shifts = workAssignmentRepository.findAll();
        }


        for (WorkAssignment workAssignment : shifts) {
            WorkAssignmentDto toDto = workAssignmentMapper.toDto(workAssignment);
            shiftsDTO.add(toDto);
        }
        if (shiftsDTO.isEmpty()) {
            throw new WorkAssignmentNotFoundException("Work assignments not found");
        }
        return shiftsDTO;


    }


    public WorkAssignmentDto updateShift(Long id, @Valid WorkAssignmentDto request) {
       var workAssignment = workAssignmentRepository.findById(id).orElse(null);
       if (workAssignment == null) {
           throw new WorkAssignmentNotFoundException("Work assignment not found");
       }
       request.setId(workAssignment.getId().intValue());
       workAssignmentMapper.update(request,workAssignment);
       workAssignmentRepository.save(workAssignment);

        return request;
    }

    public WorkAssignmentDto getShiftByID(Long id) {
        var workAssignment = workAssignmentRepository.findById(id).orElse(null);
        if (workAssignment == null) {
            throw new WorkAssignmentNotFoundException("Work assignment not found");
        }
        return workAssignmentMapper.toDto(workAssignment);
    }
}
