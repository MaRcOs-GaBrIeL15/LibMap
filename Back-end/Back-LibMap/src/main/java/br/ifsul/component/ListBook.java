package br.ifsul.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.entity.Book;
import br.ifsul.repository.BookRepository;

@Component
public class ListBook {

	@Autowired
	private BookRepository book;

	// @PostConstruct
	public void exec() {

		List<Book> books = book.findAll();

		System.out.println("Lista todos os livros");
		for (Book x : books) {

			System.out.println(x.toString());

		}

	}

}
