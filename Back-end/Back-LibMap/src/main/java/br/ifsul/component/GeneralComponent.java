package br.ifsul.component;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.entity.Book;
import br.ifsul.services.BookService;
import jakarta.annotation.PostConstruct;

@Component
public class GeneralComponent {

	@Autowired
	private BookService bookService;
//	@Autowired
//	private AddressRepository addressRepo;
//	@Autowired
//	private BookRepository bookRepo;
//	@Autowired
//	private BookshelfRepository bookshelfRepo;
//	@Autowired
//	private LibrarianRepository librarianRepo;
//	@Autowired
//	private LibraryRepository libraryRepo;

	// @PostConstruct
	public void exec() {

		Book book = new Book();
		String filePath = "C:/Users/gabi1/Downloads/CadastraLivro.xlsx";

		try (FileInputStream fileExcel = new FileInputStream(filePath)) {

			XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);

			Sheet sheet = workbook.getSheetAt(0);

			for (Row line : sheet) {

				if (line.getRowNum() != 0) {

					boolean available = false;

					String stringLine = line.getCell(11).getStringCellValue();
					if (stringLine.equalsIgnoreCase("t") || stringLine.equalsIgnoreCase("true")) {
						available = true;
					}

					book.setName(line.getCell(0).getStringCellValue());
					book.setAuthor(line.getCell(1).getStringCellValue());
					book.setAttribute(line.getCell(2).getStringCellValue());
					book.setPageNumber((int) line.getCell(3).getNumericCellValue());
					book.setYear((int) line.getCell(4).getNumericCellValue());
					book.setEdition((int) line.getCell(5).getNumericCellValue());
					book.setPublication(line.getCell(6).getStringCellValue());
					book.setImage(line.getCell(7).getStringCellValue());
					book.setTopic(line.getCell(8).getStringCellValue());
					book.setClassification(line.getCell(9).getStringCellValue());
					book.setEvent(line.getCell(10).getStringCellValue());
					book.setAvailable(available);
					book.setFloor((int) line.getCell(12).getNumericCellValue());
					book.setPosition((int) line.getCell(13).getNumericCellValue());

					book = bookService.create(book);
					int idLivro = book.getId();
					int idEstante = (int) line.getCell(14).getNumericCellValue();

					bookService.conectBookBookshelf(idLivro, idEstante);

					line.getCell(0).getNumericCellValue();
				}
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// @PostConstruct
	public void exec1() {
		Book seila = bookService.getById(8);
		seila.setEvent("");
		bookService.update(8, seila);

	}
}
