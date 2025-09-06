package com.Library.student_library_management.controller;

import com.Library.student_library_management.model.Author;
import com.Library.student_library_management.requestDTO.AuthorRequestDTO;
import com.Library.student_library_management.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author/apis")
public class AuthorController {
    private AuthorService authorService;
    @Autowired
    private AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }
    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDTO authorRequestDTO){
        String response=authorService.addAuthor(authorRequestDTO);
        return response;
    }

    @GetMapping("/find/{id}")
    public Author findAuthorById(@PathVariable int id){
        return authorService.findAuthorById(id);
    }

    @GetMapping("/findAll")
    public List<Author> findAllAuthor(){
        return authorService.findAllAuthor();
    }

    @PutMapping("/update/{id}")
    public String updateAuthor(@PathVariable int id, @RequestBody AuthorRequestDTO authorRequestDTO){
        return authorService.updateAuthor(id, authorRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable int id){
        return authorService.deleteAuthor(id);
    }
}
