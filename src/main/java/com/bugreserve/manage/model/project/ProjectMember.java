package com.bugreserve.manage.model.project;

import com.bugreserve.manage.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Calendar;

@Table
@Entity(name="project_member")
public class ProjectMember {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @JoinColumn(name = "project_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Project project;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable = false)
    @CreatedDate
    private Calendar start;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date", nullable = false)
    private Calendar end;
}
