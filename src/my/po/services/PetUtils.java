package my.po.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ivyteam.ivy.environment.Ivy;
import rest.Pet;

public class PetUtils {
	public static List<Pet> convertStringToList(String jonStr) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<Pet> pets = mapper.readValue(jonStr, new TypeReference<List<Pet>>(){});
		Ivy.log().info("-----------------convert ne: " + pets.size());
		
		return pets;		
	}

}
