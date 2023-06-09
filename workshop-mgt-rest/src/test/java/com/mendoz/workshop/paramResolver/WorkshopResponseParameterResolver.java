package com.mendoz.workshop.paramResolver;

import com.mendoz.workshop.payload.WorkshopResponse;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.time.LocalDateTime;

import static com.mendoz.workshop.utils.Constants.*;

public class WorkshopResponseParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == WorkshopResponse.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        var response = new WorkshopResponse();

        response.setUuid(UUID_VALUE.toString());
        response.setVersion(VERSION);
        response.setName(WORKSHOP_NAME);
        response.setDescription(WORKSHOP_DESCRIPTION);
        response.setStatus(WorkshopResponse.StatusEnum.valueOf(WORKSHOP_STATUS.getValue()));
        response.setStartDateTime(WORKSHOP_START_DATE_TIME);
        response.setEndDateTime(WORKSHOP_END_DATE_TIME);
        response.setCreatedByUser(CREATE_BY_USER);
        response.setModifiedByUser(MODIFIED_BY_USER);
        response.setCreatedAt(CREATED_DATE_TIME);
        response.setUpdatedAt(UPDATED_DATE_TIME);
        return response;
    }
}
