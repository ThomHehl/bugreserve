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
import java.util.Calendar;
import java.util.Set;

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
    @OneToMany()
    private Set<WorflowState> workflowStates;
}

