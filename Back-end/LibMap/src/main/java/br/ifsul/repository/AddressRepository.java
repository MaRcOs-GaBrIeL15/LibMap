package br.ifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	
	
}
