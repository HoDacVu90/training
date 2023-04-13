package my.po.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import rest.Pet;

@Singleton
@Path("pets")
public class PetApiService {
	private Map<String, Pet> pets = new HashMap<String, Pet>();

	  public PetApiService()
	  {
	    addNewPet("Lion", "available");
	    addNewPet("Chicken", "available");
	    addNewPet("Tiger", "available");
	    addNewPet("Snake", "available");
	  }

	private void addNewPet(String name, String status) {
		Pet pet = new Pet();
		pet.setName(name);
		pet.setStatus(status);
		pet.setId(UUID.randomUUID().toString());	
		pets.put(pet.getId(), pet);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "lists all pets with status")
	public List<Pet> getPets(
			@QueryParam("status") @Parameter(description = "filters pets which contain the given status") String name) {
		if (StringUtils.isBlank(name)) {
			return new ArrayList<>(pets.values());
		}
		return findPets(name);
	}
	
	private List<Pet> findPets(String status)
	  {
	    List<Pet> matches = new ArrayList<>();
	    for (Pet pet : pets.values())
	    {
	      if (pet.getStatus().equals(status))
	      {
	        matches.add(pet);
	      }
	    }
	    return matches;
	  }

}
