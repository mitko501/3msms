package org.sms.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mhajas
 */

@Entity
@Table(name = "SUBJECT")
public class Subject implements AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "SUBJECT_ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DIFFICULTY_RATING")
    private double difficultyRating;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "SUB_TEA")
    private List<Teacher> teachers;

    public Subject() {
        this("", "", 0);
    }

    public Subject(String code, String name) {
        this(code, name, 0);
    }

    public Subject(String code, String name, double difficultyRating) {
        this.id = null;
        this.code = code;
        this.name = name;
        this.difficultyRating = difficultyRating;
        this.teachers = new ArrayList<Teacher>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", difficultyRating=" + difficultyRating +
                ", teachers=" + teachers.size() +
                '}';
    }

    public String toStringWithTeachers() {
        return "Subject{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", difficultyRating=" + difficultyRating +
                ", teachers=" + teachers +
                '}';
    }
}
