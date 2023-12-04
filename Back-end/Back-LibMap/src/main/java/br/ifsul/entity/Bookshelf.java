package br.ifsul.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "BOOKSHELF")
public class Bookshelf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BOOKSHELF")
	private int id;

	@Column(name = "BOOKSHELF_IDENTIFIER")
	private String identifier;

	@Column(name = "BOOKSHELF_FLOOR", nullable = false)
	private int floor;

	@Column(name = "BOOKSHELF_HEIGHT", nullable = false)
	private int height;

	@Column(name = "BOOKSHELF_WIDTH", nullable = false)
	private int width;

	@Column(name = "BOOKSHELF_ROTATE", nullable = false)
	private int rotate;

	@Column(name = "BOOKSHELF_X", nullable = false)
	private int X;

	@Column(name = "BOOKSHELF_Y", nullable = false)
	private int Y;
	
	@Column(name = "BOOKSHELF_BORDER", nullable = false, columnDefinition = "INT DEFAULT 5")
	private int border = 5;

	@ManyToOne
	@JoinColumn(name = "id_library")
	private Library library;

	@OneToMany(mappedBy = "bookshelf", fetch = FetchType.EAGER)
	private List<Book> Books;

	@Override
	public String toString() {
		return "Bookshelf [id=" + id + ", identifier=" + identifier + ", floor=" + floor + ", height=" + height
				+ ", width=" + width + ", rotate=" + rotate + ", X=" + X + ", Y=" + Y + ", border=" + border
				+ ", library=" + library + ", Books=" + Books + "]";
	}

	

}
