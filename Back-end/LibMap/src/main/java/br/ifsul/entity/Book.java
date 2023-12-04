package br.ifsul.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BOOK", unique = true)
	private int id;

	@Column(name = "BOOK_NAME", length = 255, nullable = false)
	private String name;

	@Column(name = "BOOK_AUTHOR", length = 255, nullable = false)
	private String author;
	
	@Column(name = "BOOK_ATTRIBUTE", length = 255, nullable = true)
	private String attribute;

	@Column(name = "BOOK_PAGENUMBER", nullable = true)
	private int pageNumber;

	@Column(name = "BOOK_YEAR", nullable = true)
	private int year;

	@Column(name = "BOOK_EDITION", nullable = true)
	private int edition;

	@Column(name = "BOOK_PUBLICATION", nullable = true)
	private String Publication;
	
	@Column(name = "BOOK_IMAGELINK", nullable = true)
	private String image;
	
	@Column(name = "BOOK_TOPIC", nullable = true)
	private String topic;

	@Column(name = "BOOK_CLASSIFICATION", nullable = true)
	private String classification;
	
	@Column(name = "BOOK_EVENT", nullable = true)
	private String event;
	
	@Column(name = "BOOK_AVAILABLE", nullable = false)
	private Boolean available;
	
	@Column(name = "BOOK_FlOOR", nullable = false)
	private int floor;

	@Column(name = "BOOK_POSITION", nullable = false)
	private int position;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_bookshelf")
    private Bookshelf bookshelf;

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", attribute=" + attribute + ", pageNumber="
				+ pageNumber + ", year=" + year + ", edition=" + edition + ", Publication=" + Publication + ", image="
				+ image + ", topic=" + topic + ", classification=" + classification + ", event=" + event
				+ ", available=" + available + ", floor=" + floor + ", position=" + position + "]";
	}
		

}