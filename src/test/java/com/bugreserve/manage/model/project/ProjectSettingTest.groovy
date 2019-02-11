package com.bugreserve.manage.model.project

import spock.lang.Specification

class ProjectSettingTest extends Specification {
    private ProjectSetting projectSetting

    public static ProjectSetting getProjectSetting() {
        ProjectSetting result = new ProjectSetting()

        result.setId(42)
        result.setProject(ProjectTest.getProject())
        result.setGroup("Galaxy")
        result.setKey("Earth")
        result.setValue("Mostly Harmless")

        return result
    }

    public static ProjectSetting getProjectSetting2() {
        ProjectSetting result = new ProjectSetting()

        result.setId(1776)
        result.setProject(ProjectTest.getProject2())
        result.setGroup("Creature")
        result.setKey("Dolphin")
        result.setValue("So long and thanks for all the fish!")

        return result
    }

    void setup() {
        projectSetting = getProjectSetting()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = projectSetting.equals(projectSetting) && projectSetting.hashCode() == projectSetting.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        ProjectSetting other = getProjectSetting()

        when: "Comparing"
        boolean result = projectSetting.equals(other) && projectSetting.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        ProjectSetting other = getProjectSetting2()

        when: "Comparing"
        boolean result = projectSetting.equals(other)

        then: "Should not be equal"
        !result
    }
}
