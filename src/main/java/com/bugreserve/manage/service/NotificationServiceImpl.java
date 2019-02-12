package com.bugreserve.manage.service;

import com.bugreserve.manage.model.project.Project;
import com.bugreserve.manage.model.user.Notification;
import com.bugreserve.manage.repository.NotificationRepository;
import com.bugreserve.manage.repository.UserRepository;
import com.bugreserve.manage.to.NotificationTo;
import com.heavyweightsoftware.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private NotificationRepository      notificationRepository;

    @Override
    public List<NotificationTo> getCurrentNotifications(String userName) {
        List<NotificationTo> result = new ArrayList<>();

        List<Notification> notifications = notificationRepository.findByUser_UserNameAndNotifiedDateIsNull(userName);
        notifications.forEach(notification -> {
            NotificationTo to = toNotificationTo(notification);
            result.add(to);
        });

        return result;
    }

    private static NotificationTo toNotificationTo(Notification notification) {
        NotificationTo result = new NotificationTo();

        result.notificationKey = notification.getKey();
        result.notificationCreated = DateHelper.toIso8601(notification.getCreationDate());
        result.notificationText = notification.getText();

        Project project = notification.getIssue().getFixedVersion().getProject();
        result.projectKey = project.getKey();
        result.projectName = project.getName();

        return result;
    }
}
