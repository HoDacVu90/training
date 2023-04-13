package my.po.services;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.ivyteam.ivy.environment.Ivy;
import my.po.entities.Employee;
import my.po.entities.Promote;
import my.po.PromoteData;
import my.po.dao.PromoteDAO;
import my.po.enums.Gender;
import my.po.enums.Priority;

public class PromoteService {
	public static List<String> getGenders() {
		return Gender.getListGender();	
	}
	
	public static int generatePrimarikey() {
		Random random = new Random();
		return random.nextInt(4);
	}
	
	public static List<String> getTeams() {
		return Stream.of("Atomic","Bolt","Zeus").collect(Collectors.toList());
	}

	public static List<String> getPriorities() {
		return Priority.getListPriority();
	}
	
	public static List<Employee> updateEmployee(Promote promoteData, Employee employee) {
		Ivy.log().info("inside updateEmployee: " + employee.getId());
		if (!promoteData.getEmployees().stream().anyMatch(e -> e.getId() == employee.getId())) {
			employee.setId(UUID.randomUUID().toString());
			employee.setPromote(promoteData);
			promoteData.getEmployees().add(employee);
		} else {
			Employee emp = promoteData.getEmployees().stream().filter(e -> e.getId() == employee.getId()).findFirst()
					.orElse(null);
			emp.setActive(employee.getActive());
			emp.setAge(employee.getAge());
			emp.setGender(employee.getGender());
			emp.setName(employee.getName());
			emp.setStartingDate(employee.getStartingDate());
			emp.setTeam(employee.getTeam());
		}
		return promoteData.getEmployees();
	}
	
	public static List<Employee> deleteEmployee(Promote promoteData, Employee employee) {
		Ivy.log().info("inside deleteEmployee: " + employee.getId());
		if (promoteData.getEmployees().contains(employee)) {
			promoteData.getEmployees().remove(employee);
		}
		return promoteData.getEmployees();
	}
	
	
	public static Promote save(Promote promote) {		
		return PromoteDAO.getInstance().save(promote);
	}
	
	public static Promote findById(String id) {
		Promote promote = PromoteDAO.getInstance().findById(id);
		return promote;
	}
	
	public static Promote updateReject(Promote promote, Boolean value) {
		promote.setReject(value);
		return PromoteDAO.getInstance().save(promote);
	}
	 
}
