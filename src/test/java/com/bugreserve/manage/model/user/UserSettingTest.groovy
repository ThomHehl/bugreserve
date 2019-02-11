package com.bugreserve.manage.model.user

import spock.lang.Specification

class UserSettingTest extends Specification {
    private UserSetting userSetting

    public static UserSetting getUserSetting() {
        UserSetting result = new UserSetting()

        result.setId(42)
        result.setUser(UserTest.getUser())
        result.setGroup("Galaxy")
        result.setKey("Earth")
        result.setValue("Mostly Harmless")

        return result
    }

    public static UserSetting getUserSetting2() {
        UserSetting result = new UserSetting()

        result.setId(1776)
        result.setUser(UserTest.getUser2())
        result.setGroup("Creature")
        result.setKey("Dolphin")
        result.setValue("So long and thanks for all the fish!")

        return result
    }

    void setup() {
        userSetting = getUserSetting()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = userSetting.equals(userSetting) && userSetting.hashCode() == userSetting.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        UserSetting other = getUserSetting()

        when: "Comparing"
        boolean result = userSetting.equals(other) && userSetting.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        UserSetting other = getUserSetting2()

        when: "Comparing"
        boolean result = userSetting.equals(other)

        then: "Should not be equal"
        !result
    }
}
