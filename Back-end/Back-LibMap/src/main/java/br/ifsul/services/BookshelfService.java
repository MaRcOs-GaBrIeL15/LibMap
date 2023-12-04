package br.ifsul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.entity.Bookshelf;
import br.ifsul.repository.BookshelfRepository;
import br.ifsul.repository.LibraryRepository;

@Service
public class BookshelfService {

	@Autowired
	BookshelfRepository shelfRepo;
	@Autowired
	LibraryRepository libRepo;

	public Bookshelf create(Bookshelf bookshelf) {
		return shelfRepo.save(bookshelf);
	}

	public void deleteById(int id) {
		shelfRepo.deleteById(id);
	}

	public void delete(Bookshelf bookshelf) {
		shelfRepo.delete(bookshelf);
	}

	public Bookshelf update(int id, Bookshelf bookshelf) {
		Bookshelf oldBookshelf = shelfRepo.findById(id).get();
		bookshelf.setId(oldBookshelf.getId());
		return shelfRepo.save(bookshelf);
	}

	public List<Bookshelf> list() {
		return shelfRepo.findAll();
	}
	public List<Bookshelf> listByLibraryId(int id) {
		return libRepo.findById(id).get().getBookShelfs();
	}
	
	public Bookshelf getById(int id) {
		return shelfRepo.findById(id).get();
	}
	
	public void conectBookshelfLibrary(int idBookshelf, int idLibrary) {
		Bookshelf x = shelfRepo.findById(idBookshelf).get();
		x.setLibrary(libRepo.findById(idLibrary).get());
		shelfRepo.save(x);
	}

}
