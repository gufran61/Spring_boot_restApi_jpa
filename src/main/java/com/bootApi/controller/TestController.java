package com.bootApi.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootApi.bean.Book;
import com.bootApi.services.ServicesBook;

@RestController
public class TestController {
	@Autowired
	private ServicesBook sb;
@GetMapping("/books")
	public Book getBooks() {
		Book book= new Book();
		book.setAuthor("gufran");
		book.setId(1);
		book.setTitle("goodBook");
		return book;
		
	}
@GetMapping("/getAllBook")
public ResponseEntity<List<Book>>getAllBook(){
	List<Book> list = sb.getAllBook();
	if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}return ResponseEntity.status(HttpStatus.CREATED).body(list);
}
/*
 * public List<Book> getAllBook() { List<Book> allBook = sb.getAllBook(); return
 * allBook;
 * 
 * }
 */
@GetMapping("/getById/{id}")
public ResponseEntity<Book>getBook(@PathVariable("id")int id){
	Book book = sb.getById(id);
	if(book ==null) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}return ResponseEntity.of(Optional.of(book));
}
/*
 * public Book getById(@PathVariable("id")int id) { return sb.getById(id);
 * 
 * }
 */
@PostMapping("/books")
public Book addBook(@RequestBody Book book) {
	Book addBook = sb.addBook(book);
	return addBook;
}
@DeleteMapping("/books/{bookId}")
public void deleteBook(@PathVariable("bookId") int bookId) {
	sb.deleteBook(bookId);
}
@PutMapping("/books/{bookId}")
public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId) {
	sb.updateBook(book,bookId);
	return book;
}
}
