package com.bugreserve.manage.model.project;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity(name="project")
public class Project implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

}
