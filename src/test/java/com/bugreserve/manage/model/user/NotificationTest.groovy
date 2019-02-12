package com.bugreserve.manage.model.user

import com.bugreserve.manage.model.issue.IssueTest
import org.aspectj.weaver.ast.Not
import spock.lang.Specification

import java.time.LocalDateTime

class NotificationTest extends Specification {
    private Notification notification;

    public static Notification getNotification() {
        Notification result = new Notification()

        result.setId(42)
        result.setIssue(IssueTest.getIssue())
        result.setText("Four score and seven years ago.")
        result.setUser(UserTest.getUser())
        result.setCreationDate(LocalDateTime.now())
        result.setKey()

        return result
    }

    public static Notification getNotification2() {
        Notification result = new Notification()

        result.setId(1776)
        result.setIssue(IssueTest.getIssue())
        result.setText("Long, long ago in a galaxy far, far away.")
        result.setUser(UserTest.getUser2())
        result.setCreationDate(LocalDateTime.now().minusDays(5))
        result.setNotifiedDate(LocalDateTime.now().minusDays(3))
        result.setKey()

        return result
    }

    public static List<Notification> getNotifications() {
        List<Notification> result = new ArrayList<>()

        result.add(getNotification())
        result.add(getNotification2())

        return result
    }

    void setup() {
        notification = getNotification()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = notification.equals(notification) && notification.hashCode() == notification.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        Notification other = getNotification()

        when: "Comparing"
        boolean result = notification.equals(other) && notification.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        Notification other = getNotification2()

        when: "Comparing"
        boolean result = notification.equals(other)

        then: "Should not be equal"
        !result
    }
}
