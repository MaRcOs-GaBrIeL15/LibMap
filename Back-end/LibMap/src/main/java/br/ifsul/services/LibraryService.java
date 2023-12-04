package br.ifsul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.entity.Library;
import br.ifsul.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepo;
	
	public Library create(Library library) {
		return libraryRepo.save(library);
	}

	public void deletarPorId(int id) {
		libraryRepo.deleteById(id);
	}

	public void deletar(Library library) {
		libraryRepo.delete(library);
	}

	public Library editar(int id, Library library) {
		Library oldLibrary = libraryRepo.findById(id).get();
		library.setId(oldLibrary.getId());
		return libraryRepo.save(library);
	}

	public List<Library> listar() {
		return libraryRepo.findAll();
	}
	
	public Library buscaPorID(int id) {
		return libraryRepo.findById(id).get();
	}
	
}
