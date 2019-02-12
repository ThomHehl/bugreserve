package com.bugreserve.manage.model.project;

import com.heavyweightsoftware.util.StringHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table
@Entity(name="project")
public class Project implements Serializable {
    public static final int             KEY_LENGTH = 64;

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false)
    @Lob
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey() {
        this.key = StringHelper.generateRandomUrlSafe(KEY_LENGTH);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Project)) {
            return false;
        }

        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(name, project.name) &&
                Objects.equals(description, project.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description);
    }
}
