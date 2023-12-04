package br.ifsul.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.entity.Bookshelf;
import br.ifsul.repository.BookshelfRepository;

@Component
public class ListBookshelf {

	@Autowired
	private BookshelfRepository bookshelf;

	// @PostConstruct
	public void exec() {

		List<Bookshelf> bookshelfs = bookshelf.findAll();

		System.out.println("Lista todas as estantes");
		for (Bookshelf x : bookshelfs) {

			System.out.println(x.toString());

		}
	}
}
