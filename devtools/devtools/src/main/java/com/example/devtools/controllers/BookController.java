package com.example.devtools.controllers;

import com.example.devtools.services.BookService;
import entities.bookrepo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public ResponseEntity<List<Book>> name(){
        List<Book> list=bookService.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book b=bookService.getBookById(id);
        if(b==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }
    @PostMapping("/addbook")
    public ResponseEntity<Book> addBook(@RequestBody  Book book){
        Book b=null;
        try{
            bookService.addBook(book);
            return ResponseEntity.ok().body(book);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }

    @PatchMapping("/update/{id}/{title}")
    public String update(@PathVariable("id") int id,@PathVariable("title") String title){
    bookService.updateBook(id,title);
    return "Book name has been updated";
    }
    @PutMapping("/update/{id}")
    public String put(@RequestBody Book b,@PathVariable("id") int id){
        bookService.updateBook(id,b);
        return "Put mapping done successfully";
    }

}
