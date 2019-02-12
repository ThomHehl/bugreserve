package com.bugreserve.manage.controller;

import com.bugreserve.manage.service.NotificationService;
import com.bugreserve.manage.to.NotificationTo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/restapi")
public class ManageController {
    private static final Logger LOGGER = LogManager.getLogger(ManageController.class.getName());

    @Autowired
    private NotificationService         notificationService;

    @GetMapping(value = "/currentNotifications")
    public @ResponseBody
    List<NotificationTo> getCurrentNotifications(String authId) {
        List<NotificationTo> result;

        try {
            result = notificationService.getCurrentNotifications(authId);
        } catch (Throwable tw) {
            String msg = "Error retrieving notifications for:" + authId;
            LOGGER.error(msg, tw);
            throw new RuntimeException(msg, tw);
        }

        return result;
    }
}
