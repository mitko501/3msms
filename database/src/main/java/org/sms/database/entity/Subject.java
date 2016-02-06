package org.sms.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mhajas
 */

@Entity
@Table
public class Subject {

    @Id
    @GeneratedValue
    private long id;

    private String code;

    private String name;

    private double difficultyRating;

    @OneToMany
    private List<Teacher> teachers;

    public Subject() {
        this("", "", 0);
    }

    public Subject(String code, String name) {
        this(code, name, 0);
    }

    public Subject(String code, String name, double difficultyRating) {
        this.code = code;
        this.name = name;
        this.difficultyRating = difficultyRating;
        this.teachers = new ArrayList<Teacher>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(double difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return getId() == subject.getId() && !(getCode() != null ? !getCode().equals(subject.getCode()) : subject.getCode() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        return result;
    }
}
