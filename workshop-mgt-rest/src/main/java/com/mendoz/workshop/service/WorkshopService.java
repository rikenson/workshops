package com.mendoz.workshop.service;


import com.mendoz.workshop.domain.filter.WorkshopFilter;
import com.mendoz.workshop.payload.ParticipantRequest;
import com.mendoz.workshop.payload.UpdatedWorkshopRequest;
import com.mendoz.workshop.payload.WorkshopRequest;
import com.mendoz.workshop.payload.WorkshopResponse;

import java.util.List;
import java.util.UUID;

public interface WorkshopService {

    WorkshopResponse add(WorkshopRequest request);

    WorkshopResponse edit(UpdatedWorkshopRequest request, UUID uuid);

    WorkshopResponse addParticipants(List<ParticipantRequest> participants, UUID uuid);

    WorkshopResponse retrieve(UUID uuid);

    List<WorkshopResponse> retrieveAll();
    List<WorkshopResponse> retrieveByCriteria(WorkshopFilter filter);

    void remove(UUID uuid);
}
