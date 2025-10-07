package org.example.kinoxp.services;

import org.example.kinoxp.dtos.workAssignmentDtos.WorkAssignmentDto;
import org.example.kinoxp.exceptions.WorkAssignmentNotFoundException;
import org.example.kinoxp.mappers.WorkAssignmentMapper;
import org.example.kinoxp.models.WorkAssignment;
import org.example.kinoxp.repositories.WorkAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkAssignmentService {

    private WorkAssignmentMapper workAssignmentMapper;
    private WorkAssignmentRepository workAssignmentRepository;

    public WorkAssignmentService(WorkAssignmentMapper workAssignmentMapper, WorkAssignmentRepository workAssignmentRepository) {
        this.workAssignmentMapper = workAssignmentMapper;
        this.workAssignmentRepository = workAssignmentRepository;
    }


    public List<WorkAssignmentDto> getShifts() {
        var shifts = workAssignmentRepository.findAll();
        var shiftsDTO = new ArrayList<WorkAssignmentDto>();

        for (WorkAssignment workAssignment : shifts) {
            WorkAssignmentDto toDto = workAssignmentMapper.toDto(workAssignment);
            shiftsDTO.add(toDto);
        }
        if(shiftsDTO.isEmpty()) {
            throw new WorkAssignmentNotFoundException("Work assignments not found");
        }
        return shiftsDTO;


    }



}
