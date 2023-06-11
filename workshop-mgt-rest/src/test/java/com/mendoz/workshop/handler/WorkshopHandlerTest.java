package com.mendoz.workshop.handler;

import com.mendoz.workshop.paramResolver.*;
import com.mendoz.workshop.payload.UpdatedWorkshopRequest;
import com.mendoz.workshop.payload.WorkshopRequest;
import com.mendoz.workshop.payload.WorkshopResponse;
import com.mendoz.workshop.service.WorkshopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.mendoz.workshop.utils.Constants.UPDATED_WORKSHOP_NAME;
import static com.mendoz.workshop.utils.Constants.UUID_VALUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith({
        MockitoExtension.class,
        WorkshopRequestParameterResolver.class,
        UpdatedWorkshopRequestParameterResolver.class,
        WorkshopResponseParameterResolver.class,
        WorkshopEntityParameterResolver.class,
        ParticipantRequestParameterResolver.class,
        ParticipantResponseParameterResolver.class,
        ParticipantEntityParameterResolver.class
})
@Execution(ExecutionMode.CONCURRENT)
class WorkshopHandlerTest {

    @Mock
    private WorkshopService mockWorkshopService;

    @InjectMocks
    private WorkshopHandler workshopHandler;

    @BeforeEach
    public void setUp() {

    }

    @Test
    @DisplayName("Create new workshop succeeded -> Status: 201")
    void post_new_workshop_succeeded_201(WorkshopRequest request, WorkshopResponse response) {

        when(mockWorkshopService.add(request)).thenReturn(response);
        var underTest = workshopHandler.workshopPost(request);
        verify(mockWorkshopService, times(1)).add(request);

        assertThat(underTest.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(underTest.getBody())
                .usingRecursiveComparison()
                .isEqualTo(response);

    }

    @Test
    @DisplayName("Update existing workshop succeeded -> Status: 200")
    void put_exited_workshop_succeed_200(UpdatedWorkshopRequest request, WorkshopResponse response) {

        request.setName(UPDATED_WORKSHOP_NAME);
        response.setName(UPDATED_WORKSHOP_NAME);
        response.setVersion(1);
        response.setUpdatedAt(LocalDateTime.now());

        when(mockWorkshopService.edit(request, UUID_VALUE)).thenReturn(response);
        var underTest = workshopHandler.workshopEdit(request, UUID_VALUE);
        verify(mockWorkshopService, times(1)).edit(request, UUID_VALUE);

        assertThat(underTest.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(underTest.getBody())
                .usingRecursiveComparison()
                .isEqualTo(response);
        assertThat(Objects.requireNonNull(underTest.getBody()).getUpdatedAt()).isAfter(request.getUpdatedAt());
    }

    @Test @Disabled
    void addParticipants() {
    }

    @Test @Disabled
    void workshopRetrieve() {
    }

    @Test @Disabled
    void workshopRetrieveAll() {
    }

    @Test @Disabled
    void remove() {
    }
}