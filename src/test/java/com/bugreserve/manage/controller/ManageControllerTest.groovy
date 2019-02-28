package com.bugreserve.manage.controller

import com.bugreserve.manage.model.issue.IssueType
import com.bugreserve.manage.service.NotificationService
import com.bugreserve.manage.to.NotificationTo
import spock.lang.Specification

class ManageControllerTest extends Specification {
    private ManageController            manageController

    void setup() {
        manageController = new ManageController()

        manageController.notificationService = Mock(NotificationService.class)
    }

    def "GetCurrentNotifications exception"() {
        given: "Some notifications"
        final String authId = "Don't Panic!"

        when: "Retrieving notifications"
        manageController.getCurrentNotifications(authId)

        then: "Should be the same"
        1 * manageController.notificationService.getCurrentNotifications(authId) >> new IOException()
        thrown RuntimeException
    }

    def "GetCurrentNotifications normal"() {
        given: "Some notifications"
        List<NotificationTo> notifications = new ArrayList<>()
        notifications.add(new NotificationTo());
        final String authId = "Don't Panic!"

        when: "Retrieving notifications"
        List<NotificationTo> result = manageController.getCurrentNotifications(authId)

        then: "Should be the same"
        1 * manageController.notificationService.getCurrentNotifications(authId) >> notifications
        notifications.size() == result.size()
    }

    def "GetSetup"() {
        when: "getting setup"
        Map<String, List<String>> result = manageController.getSetup()

        then: "Should have proper values"
        List<String> issueTypes = result.get(ManageController.SETUP_ISSUE_TYPE)
        issueTypes.size() == IssueType.values().size()
    }
}
