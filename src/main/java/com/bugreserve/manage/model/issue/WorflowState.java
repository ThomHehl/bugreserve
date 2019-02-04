package com.bugreserve.manage.model.issue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Calendar;

@Table
@Entity(name="workflow_state")
public class WorflowState {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Issue issue;

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
}
