package br.ifsul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.entity.Book;
import br.ifsul.repository.BookRepository;
import br.ifsul.repository.BookshelfRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	@Autowired
	BookshelfRepository shelfRepo;

	public Book create(Book book) {
		return bookRepo.save(book);
	}

	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}

	public void delete(Book book) {
		bookRepo.delete(book);
	}

	public Book update(int id, Book book) {
		Book oldBook = bookRepo.findById(id).get();
		book.setId(oldBook.getId());
		return bookRepo.save(book);
	}

	public List<Book> list() {
		return bookRepo.findAll();
	}

	public List<Book> listByAuthor(String author) {
		return bookRepo.findByAuthorContainingIgnoreCase(author);
	}

	public List<Book> listByClassification(String classification) {
		return bookRepo.findByClassificationStartingWith(classification);
	}

	public List<Book> listByName(String name) {
		return bookRepo.findByNameContainingIgnoreCase(name);
	}

	public List<Book> listByTopic(String topic) {
		return bookRepo.findByTopicContainingIgnoreCase(topic);
	}

	public Book getById(int id) {
		return bookRepo.findById(id).get();
	}

	public void conectBookBookshelf(int idBook, int idBookshelf) {
		Book x = bookRepo.findById(idBook).get();
		x.setBookshelf(shelfRepo.findById(idBookshelf).get());
		bookRepo.save(x);
	}

}
