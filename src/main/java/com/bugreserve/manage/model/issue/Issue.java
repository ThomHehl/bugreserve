package com.bugreserve.manage.model.issue;

import com.bugreserve.manage.model.project.ProjectVersion;
import com.bugreserve.manage.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;
import java.util.Set;

import com.heavyweightsoftware.util.DateHelper;

@Table
@Entity(name="issue")
public class Issue implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "created_by_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User createdBy;

    @JoinColumn(name = "assigned_to_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User assignedTo;

    @Column(name="issue_type")
    @Enumerated(EnumType.STRING)
    private IssueType issueType;

    @JoinColumn(name = "reported_version_id")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProjectVersion reportedVersion;

    @JoinColumn(name = "fixed_version_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProjectVersion fixedVersion;

    @Column(name="title")
    @Size(max = 250)
    private String title;

    @Column(name="description")
    @Lob
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable = false)
    @CreatedDate
    private Calendar created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_date")
    private Calendar modified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="due_date")
    private Calendar due;

    @Column(name="priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name="environment")
    private String environment;

    @Column(name="completion")
    private String completion;

    @Column(name="workflow_state")
    @OneToMany(fetch = FetchType.EAGER)
    private Set<WorkflowState> workflowStates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public ProjectVersion getReportedVersion() {
        return reportedVersion;
    }

    public void setReportedVersion(ProjectVersion reportedVersion) {
        this.reportedVersion = reportedVersion;
    }

    public ProjectVersion getFixedVersion() {
        return fixedVersion;
    }

    public void setFixedVersion(ProjectVersion fixedVersion) {
        this.fixedVersion = fixedVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return DateHelper.toLocalDateTime(created);
    }

    public void setCreated(LocalDateTime created) {
        this.created = DateHelper.toCalendar(created);
    }

    public Calendar getModified() {
        return modified;
    }

    public void setModified(Calendar modified) {
        this.modified = modified;
    }

    public Calendar getDue() {
        return due;
    }

    public void setDue(Calendar due) {
        this.due = due;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    public WorkflowState getCurrentWorkflowState() {
        WorkflowState result = null;

        for (WorkflowState workflow : getWorkflowStates()) {
            if (workflow.isActive()) {
                result = workflow;
                break;
            }
        }

        if (result == null) {
            result = new WorkflowState();
            result.setStartDate(LocalDateTime.now());
            result.setWorkflowStep(WorkflowStep.open);
        }
        return result;
    }

    public Set<WorkflowState> getWorkflowStates() {
        return workflowStates;
    }

    public synchronized void setWorkflowState(User user, WorkflowStep workflowStep) {
        workflowStates.forEach(workflowState -> {
            if (workflowState.isActive()) {
                workflowState.setEndDate();
            }
        });

        workflowStates.add(new WorkflowState(this, user, workflowStep));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Issue)) {
            return false;
        }

        Issue issue = (Issue) other;
        return Objects.equals(id, issue.id) &&
                Objects.equals(createdBy, issue.createdBy) &&
                Objects.equals(assignedTo, issue.assignedTo) &&
                issueType == issue.issueType &&
                Objects.equals(reportedVersion, issue.reportedVersion) &&
                Objects.equals(fixedVersion, issue.fixedVersion) &&
                Objects.equals(title, issue.title) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(created, issue.created) &&
                Objects.equals(modified, issue.modified) &&
                Objects.equals(due, issue.due) &&
                priority == issue.priority &&
                Objects.equals(environment, issue.environment) &&
                Objects.equals(completion, issue.completion) &&
                Objects.equals(workflowStates, issue.workflowStates);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createdBy, assignedTo, issueType, reportedVersion, fixedVersion, title, description, created, modified, due, priority, environment, completion, workflowStates);
    }
}

