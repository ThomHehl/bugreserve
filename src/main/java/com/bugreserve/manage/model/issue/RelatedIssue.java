package com.bugreserve.manage.model.issue;

import javax.persistence.*;

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
}
