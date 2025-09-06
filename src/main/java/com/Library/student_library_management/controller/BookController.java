package com.Library.student_library_management.controller;

import com.Library.student_library_management.model.Book;
import com.Library.student_library_management.requestDTO.BookRequestDTO;
import com.Library.student_library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/apis")
public class BookController {
    private BookService bookService;
    @Autowired
    private BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDTO bookRequestDTO){
        String response= bookService.addBook(bookRequestDTO);
        return response;
    }

    @GetMapping("/find/{id}")
    public Book findBookById(@PathVariable int id){
        Book book= bookService.findBookById(id);
        return book;
    }

    @GetMapping("/findAll")
    public List<Book> findAllBook(){
        List<Book> bookList=bookService.findAllBook();
        return bookList;
    }

    @PutMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @RequestBody BookRequestDTO bookRequestDTO){
        return bookService.updateBook(id,bookRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable int id){
        return bookService.deleteBookById(id);
    }
}
