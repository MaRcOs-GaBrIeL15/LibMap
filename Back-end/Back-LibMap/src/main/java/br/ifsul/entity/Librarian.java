package br.ifsul.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "LIBRARIAN")
public class Librarian {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LIBRARIAN")
	private int id;

	@Column(name = "LIBRARIAN_NAME", length = 255, nullable = false)
	private String name;

	@Column(name = "EMAIL", length = 255, nullable = false, unique = true)
	private String email;

	@Column(name = "CPF", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "PASSWORD", length = 11, nullable = false)
	private String password;

	@OneToMany(mappedBy = "librarian")
	private List<Library> Libraries;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", email=" + email + ", cpf=" + cpf + ", password=" + password
				+ "]";
	}
	
	

	
}
