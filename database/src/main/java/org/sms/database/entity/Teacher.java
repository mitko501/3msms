package org.sms.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mhajas
 */

@Entity
@Table
public class Teacher implements AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "TEACHER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surName;

    @ManyToMany(mappedBy = "teachers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Subject> subjects;


    public Teacher() {
        this("", "");
    }

    public Teacher(String name, String surName) {
        this.name = name;
        this.surName = surName;
        subjects = new ArrayList<Subject>();
    }

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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", subjects=" + subjects.size() +
                '}';
    }

    public String toStringWithSubjects() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
