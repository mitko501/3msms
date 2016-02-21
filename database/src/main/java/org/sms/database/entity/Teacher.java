package org.sms.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mhajas
 */

@Entity
@Table
public class Teacher extends AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "TEACHER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "teachers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Subject> subjects;

    public Teacher(String name) {
        this.name = name;
        subjects = new ArrayList<Subject>();
    }

    public Teacher() {
        this("");
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects.size() +
                '}';
    }

    public String toStringWithSubjects() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
