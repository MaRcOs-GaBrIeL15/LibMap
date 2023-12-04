package br.ifsul.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ifsul.entity.Book;
import br.ifsul.entity.Bookshelf;
import br.ifsul.entity.Library;
import br.ifsul.repository.LibraryRepository;
import br.ifsul.services.BookService;
import br.ifsul.services.BookshelfService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class Controller {

	ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	BookService book;
	@Autowired
	BookshelfService bookshelf;
	@Autowired
	LibraryRepository library;

	@GetMapping("/Book")
	public String Books() throws JsonProcessingException {

		return objectMapper.writeValueAsString(book.list());

	}

	@GetMapping("/Book/{id}")
	@ResponseBody
	public String SearchId(@PathVariable("id") Integer id) throws JsonProcessingException {

		Book livro = book.getById(id);
		Bookshelf estante = livro.getBookshelf();
		Library biblioteca = new Library();
		if (estante != null && estante.getLibrary() != null) {
			biblioteca = estante.getLibrary();

			return objectMapper.writeValueAsString(biblioteca);
		} else {
			return objectMapper.writeValueAsString(biblioteca);
		}
	}

	@GetMapping("/Name/{name}")
	@ResponseBody
	public String SearchName(@PathVariable("name") String name) throws JsonProcessingException {

		return objectMapper.writeValueAsString(book.listByName(name));

	}

	@GetMapping("/Author/{author}")
	@ResponseBody
	public String SearchAuthor(@PathVariable("author") String author) throws JsonProcessingException {

		return objectMapper.writeValueAsString(book.listByAuthor(author));

	}

	@GetMapping("/Topic/{topic}")
	@ResponseBody
	public String SearchTopic(@PathVariable("topic") String topic) throws JsonProcessingException {

		return objectMapper.writeValueAsString(book.listByTopic(topic));

	}

	@GetMapping("/Classification/{classification}")
	@ResponseBody
	public String SearchClassification(@PathVariable("classification") String classification)
			throws JsonProcessingException {

		return objectMapper.writeValueAsString(book.listByClassification(classification));

	}

	@GetMapping("/Library/{library}")
	@ResponseBody
	public String SearchLibrary(@PathVariable("library") String name) throws JsonProcessingException {
		List<Library> libraries = library.findByNameContainingIgnoreCase(name);
		List<Bookshelf> bookshelfs = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		for (Library x : libraries) {
			bookshelfs.addAll(x.getBookShelfs());
		}

		for (Bookshelf x : bookshelfs) {
			books.addAll(x.getBooks());

		}

		return objectMapper.writeValueAsString(books);
	}

	@GetMapping("/map/{library}")
	public String SearchMap(@PathVariable("library") int id) throws JsonProcessingException {

		List<Bookshelf> bookshelfs = bookshelf.list();
		List<Bookshelf> filtratedbookshelfs = new ArrayList<>();
		for (Bookshelf x : bookshelfs) {
			if (x.getLibrary() != null && x.getLibrary().getId() == id) {
				filtratedbookshelfs.add(x);
			}
		}

		return objectMapper.writeValueAsString(filtratedbookshelfs);
	}
}
