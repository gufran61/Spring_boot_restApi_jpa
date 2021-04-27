package com.bootApi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootApi.bean.Book;
import com.bootApi.dao.BookRepository;

@Component
public class ServicesBook {
	@Autowired
	private BookRepository br;
	/*
	 * Book b = new Book();
	 * 
	 * private static List<Book> list = new ArrayList<>();
	 * 
	 * static { list.add(new Book(1, "notitle", "imran")); list.add(new Book(2,
	 * "notitle", "gufran")); list.add(new Book(3, "notitle", "asif")); }
	 */

	// get all book
	public List<Book> getAllBook() {
		List<Book> list = (List<Book>) br.findAll();
		return list;

	}

	// get book by id
	public Book getById(int id) {
		 Book book=null;
		/*
		 * Iterator<Book> itr = list.iterator(); while(itr.hasNext()) { Book next =
		 * itr.next(); int id2 = next.getId(); if(id==id2) { Book book = list.get(id);
		 * 
		 * System.out.println("in if"); return book; } }
		 */
		try {
		 //book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			 book = br.findById(id);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public Book addBook(Book book) {
		Book result = br.save(book);
		//list.add(book);
		return result;
	}

	public void deleteBook(int bookId) {
		br.deleteById(bookId);
		//list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
	}

	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		br.save(book);
		/*
		 * list.stream().map(b -> { if (b.getId() == bookId) {
		 * b.setAuthor(book.getAuthor()); b.setTitle(book.getTitle()); } return b;
		 * }).collect(Collectors.toList());
		 */
	}
}
