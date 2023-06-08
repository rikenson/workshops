package com.mendoz.workshop.service;

import com.mendoz.workshop.domain.entity.Participant;
import com.mendoz.workshop.domain.entity.Workshop;
import com.mendoz.workshop.domain.filter.WorkshopFilter;
import com.mendoz.workshop.mapper.CustomMapper;
import com.mendoz.workshop.payload.ParticipantRequest;
import com.mendoz.workshop.payload.WorkshopRequest;
import com.mendoz.workshop.payload.WorkshopResponse;
import com.mendoz.workshop.repository.WorkshopRepository;
import java.util.Collections;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkshopServiceImpl implements WorkshopService {

    @Override
    public WorkshopResponse add(WorkshopRequest request) {
        return null;
    }

    @Override
    public WorkshopResponse edit(WorkshopRequest request, UUID uuid) {
        return null;
    }

    @Override
    public WorkshopResponse addParticipants(List<ParticipantRequest> participants, UUID uuid) {
        return null;
    }

    @Override
    public WorkshopResponse retrieve(UUID uuid) {
        return null;
    }

    @Override
    public List<WorkshopResponse> retrieveAll() {
        return Collections.emptyList();
    }

    @Override
    public List<WorkshopResponse> retrieveByCriteria(WorkshopFilter filter) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {
        // TODO document why this method is empty
    }


}
