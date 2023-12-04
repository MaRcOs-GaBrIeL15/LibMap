package br.ifsul.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.entity.Library;
import br.ifsul.repository.LibraryRepository;

@Component
public class ListLibrary {

	@Autowired
	private LibraryRepository library;

	// @PostConstruct
	public void exec() {

		List<Library> libraries = library.findAll();

		System.out.println("Lista todas as bibliotecas");
		for (Library x : libraries) {

			System.out.println(x.toString());

		}
	}
}
