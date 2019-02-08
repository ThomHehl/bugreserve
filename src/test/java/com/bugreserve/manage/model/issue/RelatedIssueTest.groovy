package com.bugreserve.manage.model.issue

import spock.lang.Specification

import java.time.LocalDateTime

class RelatedIssueTest extends Specification {
    private RelatedIssue relatedIssue

    public static RelatedIssue getRelatedIssue() {
        RelatedIssue result = new RelatedIssue()

        result.setId(42)
        result.setStartDate(LocalDateTime.now())
        result.setFromIssue(IssueTest.getIssue())
        result.setToIssue(IssueTest.getIssue2())
        result.setIssueRelationType(IssueRelationType.linked)

        return result
    }

    public static RelatedIssue getRelatedIssue2() {
        RelatedIssue result = new RelatedIssue()

        result.setId(1776)
        result.setStartDate(LocalDateTime.now().minusDays(5))
        result.setEndDate(LocalDateTime.now().minusDays(3))
        result.setFromIssue(IssueTest.getIssue2())
        result.setToIssue(IssueTest.getIssue())
        result.setIssueRelationType(IssueRelationType.duplicates)

        return result
    }

    void setup() {
        relatedIssue = getRelatedIssue()
    }

    def "Equals same object"() {
        when: "Comparing to the same object"
        boolean result = relatedIssue.equals(relatedIssue) && relatedIssue.hashCode() == relatedIssue.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals similar object"() {
        given: "A similar object"
        RelatedIssue other = getRelatedIssue();

        when: "Comparing"
        boolean result = relatedIssue.equals(other) && relatedIssue.hashCode() == other.hashCode()

        then: "Should be equal"
        result
    }

    def "Equals different object"() {
        given: "A different object"
        RelatedIssue other = getRelatedIssue2();

        when: "Comparing"
        boolean result = relatedIssue.equals(other)

        then: "Should not be equal"
        !result
    }
}
