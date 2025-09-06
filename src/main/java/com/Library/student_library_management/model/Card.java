package com.Library.student_library_management.model;

import com.Library.student_library_management.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "card_status",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    @Column(name = "created_date",nullable = false)
    @CreationTimestamp //when new card is creating automatically date and time is added
    private Date createdDate;
    @Column(name = "blood_group",nullable = false)
    private String bloodGroup;
    @Column(name = "update_date",nullable = false)
    @UpdateTimestamp // when new card is updating automatically date and time is added
    private  Date updatedDate;

    @JsonBackReference
    @JoinColumn
    @OneToOne
    private Student student;

    @JsonManagedReference
    @OneToMany(mappedBy = "card")
    private List<Book> bookList;

    @JsonManagedReference
    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
