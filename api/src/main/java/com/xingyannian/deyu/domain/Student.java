package com.xingyannian.deyu.domain;



import javax.persistence.*;

/**
 * Created by XINGYANNIAN on 2018/9/12.
 */
@Entity
@Table(name = "dy_student")
public class Student {
    @Id
    private Long stId;
    private String stName;
    private String stGrade;
    private String stClass;

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStGrade() {
        return stGrade;
    }

    public void setStGrade(String stGrade) {
        this.stGrade = stGrade;
    }

    public String getStClass() {
        return stClass;
    }

    public void setStClass(String stClass) {
        this.stClass = stClass;
    }

}
