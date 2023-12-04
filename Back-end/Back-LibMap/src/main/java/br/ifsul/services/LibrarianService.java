package br.ifsul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.ifsul.entity.Librarian;
import br.ifsul.repository.LibrarianRepository;

public class LibrarianService {

	@Autowired
	LibrarianRepository librarianRepo;

	public Librarian create(Librarian librarian) {
		return librarianRepo.save(librarian);
	}

	public void deleteById(int id) {
		librarianRepo.deleteById(id);
	}

	public Librarian update(int id, Librarian librarian) {
		Librarian oldLibrarian = librarianRepo.findById(id).get();
		librarian.setId(oldLibrarian.getId());
		return librarianRepo.save(librarian);
	}

	public List<Librarian> list() {
		return librarianRepo.findAll();
	}
	
}
