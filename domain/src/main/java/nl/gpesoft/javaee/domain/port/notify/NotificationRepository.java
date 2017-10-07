package nl.gpesoft.javaee.domain.port.notify;

import nl.gpesoft.javaee.domain.entity.Developer;

public interface NotificationRepository {

    void sendNotification(Developer developer);
}