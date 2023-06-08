package com.mendoz.workshop.mapper;

import com.mendoz.workshop.domain.entity.Participant;
import com.mendoz.workshop.domain.entity.Workshop;
import com.mendoz.workshop.domain.enums.ParticipantRole;
import com.mendoz.workshop.domain.enums.WorkshopStatus;
import com.mendoz.workshop.payload.ParticipantRequest;
import com.mendoz.workshop.payload.ParticipantResponse;
import com.mendoz.workshop.payload.WorkshopRequest;
import com.mendoz.workshop.payload.WorkshopResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class CustomMapper {


    /**
     * @param request :
     * @return Workshop
     */
    public Workshop toEntity(WorkshopRequest request) {
        return Workshop.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(WorkshopStatus.valueOf(request.getStatus().getValue()))
                .startDateTime(request.getStartDateTime())
                .endDateTime(request.getEndDateTime())
                .build();
    }

    public WorkshopResponse toResponse(Workshop entity) {
        var response = new WorkshopResponse();
        response.setName(entity.getName());
        response.setStatus(WorkshopResponse.StatusEnum.valueOf(entity.getStatus().name()));
        response.setDescription(entity.getDescription());
        response.setStartDateTime(entity.getStartDateTime());
        response.setEndDateTime(entity.getEndDateTime());
        response.setParticipants(participantResponses.apply(entity.getParticipants()));
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getModifiedAt());
        response.setCreatedByUser(entity.getCreatedByUser());
        response.setModifiedByUser(entity.getModifiedByUser());
        return response;
    }


    /**
     * @param request :
     * @return Workshop
     */
    public Participant toParticipantEntity(ParticipantRequest request) {
        return Participant.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .role(ParticipantRole.valueOf(request.getRole().getValue()))
                .build();
    }

    public ParticipantResponse toParticipantResponse(Participant entity) {
        var response = new ParticipantResponse();
        response.setFirstname(entity.getFirstname());
        response.setFirstname(entity.getFirstname());
        response.setLastname(entity.getLastname());
        response.setRole(ParticipantResponse.RoleEnum.valueOf(entity.getRole().name()));
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getModifiedAt());
        response.setCreatedByUser(entity.getCreatedByUser());
        response.setModifiedByUser(entity.getModifiedByUser());
        return response;
    }

    Function<List<Participant>, List<ParticipantResponse>> participantResponses = entities ->
            entities.stream()
                    .map(this::toParticipantResponse)
                    .toList();

}
