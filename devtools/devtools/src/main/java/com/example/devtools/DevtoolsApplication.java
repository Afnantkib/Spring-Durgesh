package com.example.devtools;

import entities.bookrepo.Book;
import entities.bookrepo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication

public class DevtoolsApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(DevtoolsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Book> books=bookRepository.findAll();
		System.out.println("shdfsdfsdfsdf");
		books.forEach(book -> System.out.println(book));

	}
}
