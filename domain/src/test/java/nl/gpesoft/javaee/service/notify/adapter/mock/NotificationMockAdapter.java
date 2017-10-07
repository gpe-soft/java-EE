package nl.gpesoft.javaee.service.notify.adapter.mock;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.notify.NotificationRepository;

public class NotificationMockAdapter implements NotificationRepository {

    @Override
    public void sendNotification(Developer developer) {
        System.out.println("message sent to " + developer.getEmailAddress());
    }
}