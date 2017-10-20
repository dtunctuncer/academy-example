package com.dtunctuncer.todoist.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Project {
    @Id(autoincrement = true)
    private Long id;
    private String name;

    @Generated(hash = 356982498)
    public Project(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1767516619)
    public Project() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}