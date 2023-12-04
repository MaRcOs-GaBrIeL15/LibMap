package br.ifsul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.ifsul.entity.Address;
import br.ifsul.repository.AddressRepository;

public class AddressService {

	@Autowired
	AddressRepository addressRepo;

	public Address create(Address address) {
		return addressRepo.save(address);
	}

	public void deleteById(int id) {
		addressRepo.deleteById(id);
	}

	public Address update(int id, Address address) {
		Address oldAddress = addressRepo.findById(id).get();
		address.setId(oldAddress.getId());
		return addressRepo.save(address);
	}

	public List<Address> list() {
		return addressRepo.findAll();
	}
	
}
