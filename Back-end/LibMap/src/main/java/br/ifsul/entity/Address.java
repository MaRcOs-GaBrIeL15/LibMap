package br.ifsul.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ADDRESS")
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADDRESS")
	private int id;

	@Column(name = "NUMBER", nullable = false)
	private int number;
	
	@Column(name = "ROAD", length = 255, nullable = false)
	private String road;

	@Column(name = "CITY",length = 255, nullable = false)
	private String city;

	@Column(name = "STATE", length = 255, nullable = false)
	private String state;

	@Column(name = "COUNTRY", length = 20, nullable = false)
	private String country;
	
	@OneToOne(mappedBy = "address")
	private Library library;
	
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", road=" + road + ", city=" + city + ", state=" + state
				+ ", country=" + country + "]";
	}

	
}