package com.Library.student_library_management.Converter;

import com.Library.student_library_management.model.Author;
import com.Library.student_library_management.requestDTO.AuthorRequestDTO;

public class AuthorConverter {
    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDTO authorRequestDTO){
        Author author=new Author();
        author.setName(authorRequestDTO.getName());
        author.setEmail(authorRequestDTO.getEmail());
        author.setAge(authorRequestDTO.getAge());
        author.setCountry(authorRequestDTO.getCountry());
        author.setGender(authorRequestDTO.getGender());
        author.setRating(authorRequestDTO.getRating());
        return author;
    }
}
