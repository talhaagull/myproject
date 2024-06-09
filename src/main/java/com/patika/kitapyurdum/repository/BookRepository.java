package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}