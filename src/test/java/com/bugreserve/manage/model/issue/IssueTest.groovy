package com.bugreserve.manage.model.issue

import com.bugreserve.manage.model.user.User
import com.bugreserve.manage.model.user.UserTest
import spock.lang.Specification

class IssueTest extends Specification {

    private Issue                       issue;

    public static Issue getIssue() {
        Issue result = new Issue();

        result.description = "Who dey?"
        result.title = "Magrathea"
        result.workflowStates = [];

        return result;
    }

    public static Issue getIssue2() {
        Issue result = new Issue();

        result.description = "Don't Panic!"
        result.title = "Heart of Gold"
        result.workflowStates = [];

        return result;
    }

    void setup() {
        issue = getIssue();
    }

    def "setWorkflowState"() {
        expect:
        issue.getCurrentWorkflowState().getWorkflowStep() == WorkflowStep.open

        User user = UserTest.getUser();
        issue.setWorkflowState(user, WorkflowStep.inProgress)
        issue.getCurrentWorkflowState().getWorkflowStep() == WorkflowStep.inProgress

        issue.setWorkflowState(user, WorkflowStep.pendingCodeReview)
        issue.getCurrentWorkflowState().getWorkflowStep() == WorkflowStep.pendingCodeReview

        issue.setWorkflowState(user, WorkflowStep.failedCodeReview)
        issue.getCurrentWorkflowState().getWorkflowStep() == WorkflowStep.failedCodeReview

        issue.setWorkflowState(user, WorkflowStep.resolved)
        issue.getCurrentWorkflowState().getWorkflowStep() == WorkflowStep.resolved

        issue.setWorkflowState(user, WorkflowStep.inValidation)
        issue.getCurrentWorkflowState().getWorkflowStep() == WorkflowStep.inValidation

        issue.setWorkflowState(user, WorkflowStep.closed)
        issue.getCurrentWorkflowState().getWorkflowStep() == WorkflowStep.closed
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = issue.equals(issue) && issue.hashCode() == issue.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        Issue other = getIssue();

        when: "Comparing"
        boolean result = issue.equals(other) && issue.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        Issue other = getIssue2();

        when: "Comparing"
        boolean result = issue.equals(other)

        then: "Should not be equal"
        !result
    }
}
