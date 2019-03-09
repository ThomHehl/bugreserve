package com.bugreserve.manage.controller;

import com.bugreserve.manage.model.issue.IssueType;
import com.bugreserve.manage.service.NotificationService;
import com.bugreserve.manage.to.NotificationTo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/restapi")
public class ManageController {
    public static final String          SETUP_ISSUE_TYPE = "issueType";

    private static final Logger         LOGGER = LogManager.getLogger(NotificationService.class);

    @Autowired
    private NotificationService         notificationService;

    @GetMapping(value = "/currentNotifications")
    public @ResponseBody
    List<NotificationTo> getCurrentNotifications(@RequestParam String authId) {
        LOGGER.debug("getCurrentNotifications(" + authId + ')');
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

    @GetMapping(value = "/setup")
    public @ResponseBody
    Map<String, List<String>> getSetup() {
        LOGGER.debug("getSetup()");
        Map<String, List<String >> result = new HashMap<>();

        result.put(SETUP_ISSUE_TYPE, toList(IssueType.values()));

        return result;
    }

    private List<String> toList(Object[] values) {
        List<String> result = new ArrayList<>();

        for (Object obj : values) {
            result.add(obj.toString());
        }

        return result;
    }
}
