package com.bugreserve.manage.model.project

import com.bugreserve.manage.model.user.UserGroupTest
import spock.lang.Specification

class ProjectGroupTest extends Specification {
    private ProjectGroup                projectGroup

    public static ProjectGroup getProjectGroup() {
        ProjectGroup result = new ProjectGroup()

        result.setId(42)
        result.setProject(ProjectTest.getProject())
        result.setUserGroup(UserGroupTest.getUserGroup())
        result.setName("Zaphod Beeblebrox")

        return result;
    }

    public static ProjectGroup getProjectGroup2() {
        ProjectGroup result = new ProjectGroup()

        result.setId(1776)
        result.setProject(ProjectTest.getProject2())
        result.setUserGroup(UserGroupTest.getUserGroup2())
        result.setName("Magrathea")

        return result;
    }

    void setup() {
        projectGroup = getProjectGroup()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = projectGroup.equals(projectGroup) && projectGroup.hashCode() == projectGroup.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        ProjectGroup other = getProjectGroup();

        when: "Comparing"
        boolean result = projectGroup.equals(other) && projectGroup.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        ProjectGroup other = getProjectGroup2();

        when: "Comparing"
        boolean result = projectGroup.equals(other)

        then: "Should not be equal"
        !result
    }
}
