package com.bugreserve.manage.service

import com.bugreserve.manage.model.user.Notification
import com.bugreserve.manage.model.user.NotificationTest
import com.bugreserve.manage.model.user.User
import com.bugreserve.manage.model.user.UserTest
import com.bugreserve.manage.repository.NotificationRepository
import com.bugreserve.manage.to.NotificationTo
import spock.lang.Specification

class NotificationServiceImplTest extends Specification {
    private NotificationServiceImpl     service

    public static NotificationServiceImpl getService() {
        NotificationServiceImpl result = new NotificationServiceImpl()

        return result
    }

    void setup() {
        service = getService()

        service.notificationRepository = Mock(NotificationRepository)
    }

    def "GetCurrentNotifications"() {
        given: "A user and some notifications"
        User user = UserTest.getUser()
        List<Notification> notifications = NotificationTest.getNotifications()

        when: "Should be"
        List<NotificationTo> result = service.getCurrentNotifications(user.getUserName())

        then: "Should be"
        1 * service.notificationRepository.findByUser_UserNameAndNotifiedDateIsNull(user) >> notifications
        notifications.size() == result.size()
    }
}
