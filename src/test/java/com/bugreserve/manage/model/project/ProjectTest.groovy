package com.bugreserve.manage.model.project

import spock.lang.Specification

class ProjectTest extends Specification {
    private Project                     project;

    public static Project getProject() {
        Project result = new Project()

        result.setId(42)
        result.setName("Star Trek")
        result.setDescription("To boldy go where no man has gone before.")

        return result
    }

    public static Project getProject2() {
        Project result = new Project()

        result.setId(1776)
        result.setName("Star Trek: The Next Generation")
        result.setDescription("To boldy go where no one has gone before.")

        return result
    }

    void setup() {
        project = getProject()
    }


    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = project.equals(project) && project.hashCode() == project.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        Project other = getProject();

        when: "Comparing"
        boolean result = project.equals(other) && project.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        Project other = getProject2();

        when: "Comparing"
        boolean result = project.equals(other)

        then: "Should not be equal"
        !result
    }
}
