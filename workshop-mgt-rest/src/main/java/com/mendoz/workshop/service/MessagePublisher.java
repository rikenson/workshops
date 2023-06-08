package com.mendoz.workshop.service;


import com.mendoz.workshop.payload.WorkshopResponse;

public interface MessagePublisher {

    void sendNotification(WorkshopResponse message);
}
