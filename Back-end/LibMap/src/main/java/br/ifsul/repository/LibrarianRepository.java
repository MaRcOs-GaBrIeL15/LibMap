package br.ifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

}
