package com.mendoz.workshop.domain.filter;

import com.mendoz.workshop.domain.enums.WorkshopStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @Builder
public class WorkshopFilter {

    private static final String PREFERRED_FIELD_VALUE = "name";

    private String name;
    private WorkshopStatus status;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String preferredField = PREFERRED_FIELD_VALUE ;
}

