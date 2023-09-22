package com.example.demo1.Service;

import com.example.demo1.model.BookAuthor;

import java.util.ArrayList;
import java.util.List;

public class BookAuthorService {
    private static List<BookAuthor> bookAuthors;
    private static int idCurrent;

    static {
        bookAuthors = new ArrayList<>();
    }

    public BookAuthor create(BookAuthor bookAuthor){
        bookAuthor.setId(++idCurrent);
        bookAuthors.add(bookAuthor);
        return bookAuthor;
    }
    public BookAuthor findBy(int idBook){
        return bookAuthors.stream().filter(bookAuthor -> bookAuthor.getBook().getId() == idBook).findFirst().orElseThrow();
    }

    public void delete(int id){
        bookAuthors = bookAuthors.stream().filter(e -> e.getId() == id).toList();
    }
}