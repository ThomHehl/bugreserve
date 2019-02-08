package com.bugreserve.manage.model.project

import spock.lang.Specification

import java.time.LocalDateTime

class ProjectVersionTest extends Specification {
    private ProjectVersion              version;

    public static ProjectVersion getVersion() {
        ProjectVersion result = new ProjectVersion()

        result.setId(42)
        result.setCreateDate(LocalDateTime.now())
        result.setDescription("Long, long ago in a galaxy far, far away.")
        result.setName("Star Wars")
        result.setProject(ProjectTest.getProject())

        return result
    }

    void setup() {
        version = getProjectVersion();
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = state.equals(state) && state.hashCode() == state.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        ProjectVersion other = getState();

        when: "Comparing"
        boolean result = state.equals(other) && state.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        ProjectVersion other = getState2();

        when: "Comparing"
        boolean result = state.equals(other)

        then: "Should not be equal"
        !result
    }
}
