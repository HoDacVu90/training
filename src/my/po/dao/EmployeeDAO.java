package my.po.dao;

import com.axonivy.utils.persistence.dao.AuditableDAO;

import my.po.entities.Employee;
import my.po.entities.Employee_;

public class EmployeeDAO extends AuditableDAO<Employee_, Employee> implements BaseDAO{
	private static final EmployeeDAO instance = new EmployeeDAO(); 

	private EmployeeDAO() {
	}

	public static EmployeeDAO getInstance() {
		return instance;
	}

	@Override
	protected Class<Employee> getType() {
		// TODO Auto-generated method stub
		return Employee.class;
	}

}
