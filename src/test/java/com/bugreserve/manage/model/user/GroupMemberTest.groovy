package com.bugreserve.manage.model.user

import spock.lang.Specification

import java.time.LocalDateTime

class GroupMemberTest extends Specification {
    private GroupMember                 groupMember

    public static GroupMember getGroupMember() {
        GroupMember result = new GroupMember()

        result.setId(42)
        result.setUser(UserTest.getUser())
        result.setUserGroup(UserGroupTest.getUserGroup())
        result.setStartDate(LocalDateTime.now())

        return result
    }

    public static GroupMember getGroupMember2() {
        GroupMember result = new GroupMember()

        result.setId(1776)
        result.setUser(UserTest.getUser2())
        result.setUserGroup(UserGroupTest.getUserGroup2())
        result.setStartDate(LocalDateTime.now().minusDays(5))
        result.setEndDate(LocalDateTime.now().minusDays(3))

        return result
    }

    void setup() {
        groupMember = getGroupMember()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = groupMember.equals(groupMember) && groupMember.hashCode() == groupMember.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        GroupMember other = getGroupMember();
        other.setStartDate(groupMember.getStartDate())

        when: "Comparing"
        boolean result = groupMember.equals(other) && groupMember.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        GroupMember other = getGroupMember2();

        when: "Comparing"
        boolean result = groupMember.equals(other)

        then: "Should not be equal"
        !result
    }
}
