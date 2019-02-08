package com.bugreserve.manage.model.issue;

import com.heavyweightsoftware.util.DateHelper;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

@Table
@Entity(name="related_issue")
public class RelatedIssue {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name="from_issue", nullable = false)
    private Issue fromIssue;

    @Column(name="to_issue", nullable = false)
    private Issue toIssue;

    @Column(name="issue_relation_type")
    @Enumerated(EnumType.STRING)
    private IssueRelationType issueRelationType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable = false)
    @CreatedDate
    private Calendar startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date")
    private Calendar endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Issue getFromIssue() {
        return fromIssue;
    }

    public void setFromIssue(Issue fromIssue) {
        this.fromIssue = fromIssue;
    }

    public Issue getToIssue() {
        return toIssue;
    }

    public void setToIssue(Issue toIssue) {
        this.toIssue = toIssue;
    }

    public IssueRelationType getIssueRelationType() {
        return issueRelationType;
    }

    public void setIssueRelationType(IssueRelationType issueRelationType) {
        this.issueRelationType = issueRelationType;
    }

    public LocalDateTime getStartDate() {
        return DateHelper.toLocalDateTime(startDate);
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = DateHelper.toCalendar(startDate);
    }

    public LocalDateTime getEndDate() {
        return DateHelper.toLocalDateTime(endDate);
    }

    public void setEndDate() {
        this.endDate = new GregorianCalendar();
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = DateHelper.toCalendar(endDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof RelatedIssue)) {
            return false;
        }

        RelatedIssue that = (RelatedIssue) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fromIssue, that.fromIssue) &&
                Objects.equals(toIssue, that.toIssue) &&
                issueRelationType == that.issueRelationType &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fromIssue, toIssue, issueRelationType, startDate, endDate);
    }
}
