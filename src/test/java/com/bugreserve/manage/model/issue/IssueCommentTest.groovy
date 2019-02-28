package com.bugreserve.manage.model.issue

import spock.lang.Specification

import java.time.LocalDateTime

class IssueCommentTest extends Specification {
    private IssueComment                issueComment

    public static IssueComment getIssueComment() {
        IssueComment result = new IssueComment()

        result.setId(42)
        result.setIssue(IssueTest.getIssue())
        result.setText("Four score and seven years ago")
        result.setStartDate(LocalDateTime.now())

        return result
    }

    public static IssueComment getIssueComment2() {
        IssueComment result = new IssueComment()

        result.setId(1776)
        result.setIssue(IssueTest.getIssue2())
        result.setText("Long, long ago in a galaxy far, far away")
        result.setStartDate(LocalDateTime.now().minusDays(5))

        return result
    }

    void setup() {
        issueComment = getIssueComment()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = issueComment.equals(issueComment) && issueComment.hashCode() == issueComment.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        IssueComment other = getIssueComment();
        other.startDate = issueComment.startDate

        when: "Comparing"
        boolean result = issueComment.equals(other) && issueComment.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        IssueComment other = getIssueComment2();

        when: "Comparing"
        boolean result = issueComment.equals(other)

        then: "Should not be equal"
        !result
    }
}
