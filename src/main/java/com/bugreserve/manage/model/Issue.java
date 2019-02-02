package com.bugreserve.manage.model;

import com.bugreserve.manage.model.user.User;

import javax.persistence.*;
import java.io.Serializable;

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
}

