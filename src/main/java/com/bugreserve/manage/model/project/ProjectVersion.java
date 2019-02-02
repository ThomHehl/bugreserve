package com.bugreserve.manage.model.project;

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

    @Column()
    private String name;

    @Column(nullable = false)
    private String versionNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Calendar createDate;

    @Column()
    private Calendar dueDate;

}
