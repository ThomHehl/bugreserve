package com.bugreserve.manage.model.issue;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Calendar;

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
}