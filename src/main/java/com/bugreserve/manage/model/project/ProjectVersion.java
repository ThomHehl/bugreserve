package com.bugreserve.manage.model.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Table
@Entity(name="project_version")
public class ProjectVersion implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "project_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Project project;

    @Column()
    private String name;

    @Column(nullable = false)
    private String versionNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @CreatedDate
    private Calendar createDate;

    @Column()
    private Calendar dueDate;

}
