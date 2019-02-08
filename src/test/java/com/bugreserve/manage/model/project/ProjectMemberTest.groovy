package com.bugreserve.manage.model.project

import com.bugreserve.manage.model.user.UserTest
import spock.lang.Specification

import java.time.LocalDateTime

class ProjectMemberTest extends Specification {
    private ProjectMember               projectMember;

    public static ProjectMember getProjectMember() {
        ProjectMember result = new ProjectMember()

        result.setId(42)
        result.setProject(ProjectTest.getProject())
        result.setUser(UserTest.getUser())
        result.setStart(LocalDateTime.now())

        return result
    }

    public static ProjectMember getProjectMember2() {
        ProjectMember result = new ProjectMember()

        result.setId(1776)
        result.setProject(ProjectTest.getProject2())
        result.setUser(UserTest.getUser2())
        result.setStart(LocalDateTime.now().minusDays(5))
        result.setEnd(LocalDateTime.now().minusDays(3))

        return result
    }

    void setup() {
        projectMember = getProjectMember()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = projectMember.equals(projectMember) && projectMember.hashCode() == projectMember.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        ProjectMember other = getProjectMember()

        when: "Comparing"
        boolean result = projectMember.equals(other) && projectMember.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        ProjectMember other = getProjectMember2()

        when: "Comparing"
        boolean result = projectMember.equals(other)

        then: "Should not be equal"
        !result
    }
}
