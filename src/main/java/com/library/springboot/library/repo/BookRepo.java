package com.library.springboot.library.repo;

import com.library.springboot.library.entity.Book;
import com.library.springboot.library.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByReader(Reader reader);
}
