package com.example.demo1.Service;

import com.example.demo1.model.*;


import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private static List<Book> books;

    private AuthorService authorService;
    private CategoryService categoryService;

    private BookAuthorService bookAuthorService;

    public BookService() {
        authorService = new AuthorService();
        categoryService = new CategoryService();
        bookAuthorService = new BookAuthorService();
    }

    private static int idCurrent;

    static {
        books = new ArrayList<>();
    }

    public void create(HttpServletRequest req){
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String publishDate = req.getParameter("publishDate");
        String categoryId = req.getParameter("category");
        List<Author> authors = Arrays.stream(req.getParameterValues("author"))
                                    .map(Integer::parseInt)
                .map(authorId -> authorService.findById(authorId))
                .toList();
        Category category = categoryService.getCategory(Integer.parseInt(categoryId));
        Book book = new Book();
        book.setId(++idCurrent);
        book.setTitle(title);
        book.setDescription(description);
        book.setCategory(category);
        book.setPrice(new BigDecimal(price));
        book.setPublishDate(Date.valueOf(publishDate));
        List<BookAuthor> bookAuthors = new ArrayList<>();
        for(var author : authors){
            var bookAuthor = bookAuthorService.create(new BookAuthor(book, author));
            bookAuthors.add(bookAuthor);
        }
        book.setBookAuthors(bookAuthors);
        books.add(book);


//        String[] authorIds = req.getParameter("author").split(",");
//        List<Author> authors1 = new ArrayList<>();
//        for (var authorId :authorIds) {
//            Author author = authorService.findById(Integer.parseInt(authorId));
//            authors1.add(author);
//        }



    }
    public void editBooks(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        BigDecimal price =new BigDecimal(req.getParameter("price")) ;
        Date publishDate = Date.valueOf(req.getParameter("publishDate"));
        String categoryId = req.getParameter("category");
        Category category = categoryService.getCategory(Integer.parseInt(categoryId));

        Book book = getBookById(id);
        book.setTitle(title);
        book.setDescription(description);
        book.setPrice(price);
        book.setPublishDate(publishDate);
        book.setCategory(category);
        List<Author> authors = Arrays.stream(req.getParameterValues("author"))
                .map(Integer::parseInt)
                .map(authorId -> authorService.findById(authorId))
                .toList();


        List<BookAuthor> bookAuthors = new ArrayList<>();
        for (Author a : authors) {
            bookAuthors.add(new BookAuthor(book, a));
        }
        book.setBookAuthors(bookAuthors);


    }
    public void remove(int id) {
        Book deleteBook = getBookById(id);
        if (deleteBook != null) {
            deleteBook.setDeleted(true);
        }
    }
    public void restore(String[] ids){
        for(int i=0;i<ids.length;i++){
            for(Book b:books){
                if(String.valueOf(b.getId()).equals(ids[i])){
                    b.setDeleted(false);
                }
            }
        }
    }
    public boolean searchBooks(Book book,String keyword) {
        return  book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                ||  book.getDescription().toLowerCase().contains(keyword.toLowerCase())
                ||  book.getCategory().getName().toLowerCase().contains(keyword.toLowerCase());


    }
    public List<Book> searchProducts(String keyword) {
        return books.stream().filter(book -> searchBooks(book,keyword)&&!book.isDeleted()).collect(Collectors.toList());
    }



    public List<Book> getBooks(boolean deleted){
        return books.stream().filter(book -> book.isDeleted()==deleted).collect(Collectors.toList());
    }


    public Book getBookById(int id) {
        return books.stream().filter(book -> book.getId()==id).findFirst().orElse(null);
    }
}