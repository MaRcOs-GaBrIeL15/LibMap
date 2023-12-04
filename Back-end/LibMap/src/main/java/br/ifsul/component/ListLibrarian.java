package br.ifsul.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.entity.Librarian;
import br.ifsul.repository.LibrarianRepository;

@Component
public class ListLibrarian {

	@Autowired
	private LibrarianRepository librarian;

	// @PostConstruct
	public void exec() {

		List<Librarian> librarians = librarian.findAll();

		System.out.println("Lista todas os bibliotecarios");
		for (Librarian x : librarians) {

			System.out.println(x.toString());

		}
		
	}
}
