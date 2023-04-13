package my.po.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import rest.Pet;

public class PetRepository {
	private static PetRepository INSTANCE;

	public synchronized static PetRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PetRepository();
		}
		return INSTANCE;
	}

	private final List<Pet> pets = new ArrayList<>();

	public PetRepository() {
		pets.add(addNewPet("Lion", "available"));
		pets.add(addNewPet("Chicken", "available"));
		pets.add(addNewPet("Tiger", "available"));
		pets.add(addNewPet("Snake", "available"));
	}

	private Pet addNewPet(String name, String status) {
		Pet pet = new Pet();
		pet.setName(name);
		pet.setStatus(status);
		pet.setId(UUID.randomUUID().toString());
		return pet;
	}

	public List<Pet> findAll() {
		return new ArrayList<>(pets);
	}

}
