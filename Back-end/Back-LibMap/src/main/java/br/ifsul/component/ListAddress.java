package br.ifsul.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.entity.Address;
import br.ifsul.repository.AddressRepository;

@Component
public class ListAddress {

	@Autowired
	private AddressRepository address;

	// @PostConstruct
	public void exec() {

		List<Address> Addresses = address.findAll();

		System.out.println("Lista todos os enderecos");
		for (Address x : Addresses) {

			System.out.println(x.toString());

		}
	}
}
