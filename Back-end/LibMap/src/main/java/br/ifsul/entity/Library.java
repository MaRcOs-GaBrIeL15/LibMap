package br.ifsul.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "LIBRARY")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LIBRARY")
	private int id;

	@Column(name = "LIBRARY_NAME", length = 255, nullable = false)
	private String name;
	
	@OneToOne(cascade =  CascadeType.REMOVE)
	@JoinColumn(name="id_address")
	private Address address;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_librarian")
    private Librarian librarian;
	
	@JsonIgnore
	@OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
	private List<Bookshelf> BookShelfs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + "]";
	}

	
}
