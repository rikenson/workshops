package com.mendoz.workshop.paramResolver;

import com.mendoz.workshop.payload.WorkshopRequest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import static com.mendoz.workshop.utils.Constants.*;


public class WorkshopRequestParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == WorkshopRequest.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        var model = new WorkshopRequest();
        model.setName(WORKSHOP_NAME);
        model.setDescription(WORKSHOP_DESCRIPTION);
        model.setStatus(WORKSHOP_STATUS);
        model.setStartDateTime(WORKSHOP_START_DATE_TIME);
        model.setEndDateTime(WORKSHOP_END_DATE_TIME);
        return model;
    }
}
