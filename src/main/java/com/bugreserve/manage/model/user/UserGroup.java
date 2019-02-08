package com.bugreserve.manage.model.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table
@Entity(name="user_group")
public class UserGroup implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof UserGroup)) {
            return false;
        }

        UserGroup userGroup = (UserGroup) o;
        return Objects.equals(id, userGroup.id) &&
                Objects.equals(groupName, userGroup.groupName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, groupName);
    }
}
