package com.Library.student_library_management.model;

import com.Library.student_library_management.enums.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "publisher_name",nullable = false)
    private String publisherName;

    @Column(name = "publish_date",nullable = false)
    private String publishDate;

    @Column(name = "category",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name = "page_number",nullable = false)
    private int pageNumber;

    @Column(name = "rack_number",nullable = false)
    private String rackNumber;

    @Column(name = "availability",nullable = false)
    private boolean availability;

    @Column(name = "edition",nullable = false)
    private String edition;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Author author;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
