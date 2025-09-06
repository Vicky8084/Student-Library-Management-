package com.Library.student_library_management.model;

import com.Library.student_library_management.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    //5. transaction :- id, transactionDate, fine, dueDate, transactionType(Borrow/Return)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transaction_date", nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(nullable = false)
    private double fine;

    @Column(name = "due_date", nullable = false)
    private String dueDate;

    @Column(name = "transaction_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
