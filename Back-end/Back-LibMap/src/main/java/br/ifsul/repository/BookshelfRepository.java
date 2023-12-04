package br.ifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Bookshelf;

public interface BookshelfRepository extends JpaRepository<Bookshelf, Integer> {

}
