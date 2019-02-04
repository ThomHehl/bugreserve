package com.bugreserve.manage.model.issue;

import javax.persistence.*;

@Table
@Entity(name="issue_comment")
public class IssueComment {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Issue issue;

    @Column(nullable = false)
    private String text;
}
