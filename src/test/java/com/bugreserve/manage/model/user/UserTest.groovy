package com.bugreserve.manage.model.user

import spock.lang.Specification

class UserTest extends Specification {
    private User                    user;

    public static User getUser() {
        User result = new User()

        result.setId(42)
        result.setFirstName("Zaphod")
        result.setLastName("Beeblebrox")
        result.setUserName("zbeeblebrox")

        return result
    }

    public static User getUser2() {
        User result = new User()

        result.setId(1776)
        result.setFirstName("Arthur")
        result.setLastName("Dent")
        result.setUserName("dentarthurdent")

        return result
    }

    void setup() {
        user = getUser();
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = user.equals(user) && user.hashCode() == user.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        User other = getUser()

        when: "Comparing"
        boolean result = user.equals(other) && user.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        User other = getUser2()

        when: "Comparing"
        boolean result = user.equals(other)

        then: "Should not be equal"
        !result
    }
}
