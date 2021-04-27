package com.bootApi.dao;

import org.springframework.data.repository.CrudRepository;

import com.bootApi.bean.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
public Book findById(int id);
}
