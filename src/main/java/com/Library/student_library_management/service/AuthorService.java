package com.Library.student_library_management.service;

import com.Library.student_library_management.Converter.AuthorConverter;
import com.Library.student_library_management.model.Author;
import com.Library.student_library_management.repository.AuthorRepository;
import com.Library.student_library_management.requestDTO.AuthorRequestDTO;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorService(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }
    public String addAuthor(AuthorRequestDTO authorRequestDTO){
        Author author=AuthorConverter.convertAuthorRequestDtoIntoAuthor(authorRequestDTO);
        authorRepository.save(author);
        return ("Author Saved Successfully");
    }

    public Author findAuthorById(int id){
        Optional<Author> optionalAuthor=authorRepository.findById(id);
        if(optionalAuthor.isPresent()){
            return optionalAuthor.get();
        }
        else {
            return null;
        }
    }

    public List<Author> findAllAuthor(){
        List<Author> authorList=authorRepository.findAll();
        return authorList;
    }

    public String updateAuthor(int id, AuthorRequestDTO authorRequestDTO){
        Author author=findAuthorById(id);
        if(author!=null){
            author.setName(authorRequestDTO.getName());
            author.setEmail(authorRequestDTO.getEmail());
            author.setAge(authorRequestDTO.getAge());
            author.setCountry(authorRequestDTO.getCountry());
            author.setGender(authorRequestDTO.getGender());
            author.setRating(authorRequestDTO.getRating());
            authorRepository.save(author);
            return "Author Saved Successfully..!!";
        }
        else {
            return "Author Not Found..!!";
        }
    }

    public String deleteAuthor(int id){
        authorRepository.deleteById(id);
        return "Author deleted Successfully";
    }
}
