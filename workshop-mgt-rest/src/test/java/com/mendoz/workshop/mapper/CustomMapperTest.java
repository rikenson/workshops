package com.mendoz.workshop.mapper;

import com.mendoz.workshop.domain.entity.Participant;
import com.mendoz.workshop.domain.entity.Workshop;
import com.mendoz.workshop.paramResolver.*;
import com.mendoz.workshop.payload.ParticipantRequest;
import com.mendoz.workshop.payload.ParticipantResponse;
import com.mendoz.workshop.payload.WorkshopRequest;
import com.mendoz.workshop.payload.WorkshopResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import static org.assertj.core.api.AssertionsForClassTypes.*;

@ExtendWith({
        WorkshopRequestParameterResolver.class,
        WorkshopResponseParameterResolver.class,
        WorkshopEntityParameterResolver.class,
        ParticipantRequestParameterResolver.class,
        ParticipantResponseParameterResolver.class,
        ParticipantEntityParameterResolver.class
})
class CustomMapperTest {

    private CustomMapper mapperMock;

    @BeforeEach
    public void setUp() {
        mapperMock = new CustomMapper();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mapWorkshopRequest_To_Entity_Succeeded(WorkshopRequest request, WorkshopResponse response) {

        var ignoreFields = new String[]{"uuid", "createdAt", "modifiedAt", "createdByUser", "modifiedByUser", "version"};
        var underTest = mapperMock.toEntity(request);
        assertThat(underTest)
                .usingRecursiveComparison()
                .ignoringFields(ignoreFields)
                .isEqualTo(response);
    }

    @Test
    void mapWorkshopEntity_To_Response_Succeeded(Workshop workshop, WorkshopResponse response) {

        var underTest = mapperMock.toResponse(workshop);
        assertThat(underTest)
                .usingRecursiveComparison()
                .isEqualTo(response)
                .isNotNull();
    }

    @Test
    void mapParticipantRequest_To_Entity_Succeeded(ParticipantRequest request, ParticipantResponse response) {
        var ignoreFields = new String[]{"uuid", "createdAt", "modifiedAt", "createdByUser", "modifiedByUser", "version"};
        var underTest = mapperMock.toParticipantEntity(request);
        assertThat(underTest)
                .usingRecursiveComparison()
                .ignoringFields(ignoreFields)
                .isEqualTo(response);
    }

    @Test
    void mapEntity_To_ParticipantResponse_Succeeded(Participant request, ParticipantResponse response) {
        var underTest = mapperMock.toParticipantResponse(request);
        assertThat(underTest)
                .usingRecursiveComparison()
                .isEqualTo(response)
                .isNotNull();
    }
}