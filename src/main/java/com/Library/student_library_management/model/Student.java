package com.Library.student_library_management.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private  String name;

    @Column(name = "mobile_number",nullable = false)
    private  String mobileNumber;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "dept",nullable = false)
    private String dept;

    @Column(name = "sem",nullable = false)
    private String sem;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "dob",nullable = false)
    private String dob;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "section",nullable = false)
    private String section;

    @JsonManagedReference
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
