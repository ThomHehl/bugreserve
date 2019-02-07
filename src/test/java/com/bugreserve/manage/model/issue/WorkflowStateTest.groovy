package com.bugreserve.manage.model.issue

import spock.lang.Specification

import java.time.LocalDateTime

class WorkflowStateTest extends Specification {
    private WorkflowState               state

    public static WorkflowState getState() {
        WorkflowState result = new WorkflowState()

        result.setId(42)
        result.setIssue(IssueTest.getIssue())
        result.setStartDate(LocalDateTime.now())
        result.setWorkflowStep(WorkflowStep.open)

        return result
    }

    public static WorkflowState getState2() {
        WorkflowState result = new WorkflowState()

        result.setId(1776)
        result.setIssue(IssueTest.getIssue2())
        result.setStartDate(LocalDateTime.now().plusDays(-5))
        result.setWorkflowStep(WorkflowStep.inProgress)
        result.setEndDate(LocalDateTime.now().plusDays(-3))

        return result
    }

    void setup() {
        state = getState()
    }

    def "IsActive true"() {
        when: "Checking"
        boolean result = state.isActive();

        then: "Should be active"
        result
    }

    def "IsActive false"() {
        given: "another state"
        WorkflowState state2 = getState2()

        when: "Checking"
        boolean result = state2.isActive();

        then: "Should be inactive"
        !result
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = state.equals(state) && state.hashCode() == state.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        WorkflowState other = getState();

        when: "Comparing"
        boolean result = state.equals(other) && state.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        WorkflowState other = getState2();

        when: "Comparing"
        boolean result = state.equals(other)

        then: "Should not be equal"
        !result
    }
}
