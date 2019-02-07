package com.bugreserve.manage.model.issue;

import com.bugreserve.manage.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heavyweightsoftware.util.DateHelper;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.jdbc.Work;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

@Table
@Entity(name="workflow_state")
public class WorkflowState {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "issue_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Issue issue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "changed_by", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User changedBy;

    @Column(name="workflow_step", nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkflowStep workflowStep;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable = false)
    @CreatedDate
    private Calendar startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date")
    private Calendar endDate;

    public WorkflowState() {}

    public WorkflowState(Issue issue, User user, WorkflowStep workflowStep) {
        setIssue(issue);
        setChangedBy(user);
        setWorkflowStep(workflowStep);
    }

    public boolean isActive() {
        return endDate == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(User changedBy) {
        this.changedBy = changedBy;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public WorkflowStep getWorkflowStep() {
        return workflowStep;
    }

    public void setWorkflowStep(WorkflowStep workflowStep) {
        this.workflowStep = workflowStep;
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

        if (!(o instanceof WorkflowState)) {
            return false;
        }

        WorkflowState that = (WorkflowState) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(changedBy, that.changedBy) &&
                Objects.equals(issue, that.issue) &&
                workflowStep == that.workflowStep &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, changedBy, issue.getId(), workflowStep, startDate, endDate);
    }
}
