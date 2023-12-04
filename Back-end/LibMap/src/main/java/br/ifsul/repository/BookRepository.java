package br.ifsul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByAuthorContainingIgnoreCase(String author);

	public List<Book> findByNameContainingIgnoreCase(String name);

	public List<Book> findByTopicContainingIgnoreCase(String topic);
	
	public List<Book> findByClassificationStartingWith(String Classification);
}
