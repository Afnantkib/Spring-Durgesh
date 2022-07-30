package com.example.devtools.services;

import entities.bookrepo.Book;
import entities.bookrepo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookService {
  @Autowired
  private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        Book b=null;
        try{
            b=bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return b;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book deleteBook(int id) {
        Book b=bookRepository.findById(id);
        bookRepository.deleteById(id);
        return b;
    }

    public void updateBook(int id, String title) {
        Book b=bookRepository.findById(id);
        b.setTitle(title);
    }

    public void updateBook(int id, Book b) {
        Book book = getBookById(id);
        book = new Book(b);
    }

}
