package br.ifsul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

	public List<Library> findByNameContainingIgnoreCase(String name);

}
