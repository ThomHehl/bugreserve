package com.bugreserve.manage.model.issue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Calendar;

@Table
@Entity(name="issue_comment")
public class IssueComment {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "issue_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Issue issue;

    @Column(nullable = false)
    @Lob
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable = false)
    @CreatedDate
    private Calendar startDate;
}
