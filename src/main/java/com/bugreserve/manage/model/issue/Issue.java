package com.bugreserve.manage.model.issue;

import com.bugreserve.manage.model.project.ProjectVersion;
import com.bugreserve.manage.model.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Table
@Entity(name="issue")
public class Issue implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name="created_by")
    private User createdBy;

    @Column(name="issue_type")
    @Enumerated(EnumType.STRING)
    private IssueType issueType;

    @Column(name="project_version")
    private ProjectVersion projectVersion;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="created_date", nullable = false)
    private Calendar created;

    @Column(name="modified_date")
    private Calendar modified;

    @Column(name="due_date")
    private Calendar due;

    @Column(name="priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name="environment")
    private String environment;

    @Column(name="completion")
    private String completion;
}

