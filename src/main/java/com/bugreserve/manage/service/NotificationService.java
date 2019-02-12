package com.bugreserve.manage.service;

import com.bugreserve.manage.to.NotificationTo;

import java.util.List;

public interface NotificationService {
    List<NotificationTo> getCurrentNotifications(String userName);

}
