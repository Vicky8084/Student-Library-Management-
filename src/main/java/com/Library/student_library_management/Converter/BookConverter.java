package com.Library.student_library_management.Converter;

import com.Library.student_library_management.model.Book;
import com.Library.student_library_management.requestDTO.BookRequestDTO;

public class BookConverter {
    public static Book convertBookRequestDtoIntoBook(BookRequestDTO bookRequestDTO){
        Book book=new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setPublisherName(bookRequestDTO.getPublisherName());
        book.setPublishDate(bookRequestDTO.getPublishDate());
        book.setCategory(bookRequestDTO.getCategory());
        book.setPrice(bookRequestDTO.getPrice());
        book.setPageNumber(bookRequestDTO.getPageNumber());
        book.setRackNumber(bookRequestDTO.getRackNumber());
        book.setAvailability(bookRequestDTO.isAvailability());
        book.setEdition(bookRequestDTO.getEdition());
        return book;
    }
}
