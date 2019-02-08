package com.bugreserve.manage.model.user

import spock.lang.Specification

class UserGroupTest extends Specification {
    private UserGroup                   userGroup;

    public static UserGroup getUserGroup() {
        UserGroup result = new UserGroup()

        result.setId(42)
        result.setGroupName("Heart of Gold")

        return result
    }

    public static UserGroup getUserGroup2() {
        UserGroup result = new UserGroup()

        result.setId(1776)
        result.setGroupName("Sir not appearing in this picture")

        return result
    }

    void setup() {
        userGroup = getUserGroup()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = userGroup.equals(userGroup) && userGroup.hashCode() == userGroup.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        UserGroup other = getUserGroup()

        when: "Comparing"
        boolean result = userGroup.equals(other) && userGroup.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        UserGroup other = getUserGroup2()

        when: "Comparing"
        boolean result = userGroup.equals(other)

        then: "Should not be equal"
        !result
    }
}
