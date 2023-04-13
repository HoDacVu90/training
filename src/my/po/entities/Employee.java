package my.po.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.axonivy.utils.persistence.beans.AuditableEntity;



@Entity
@Table(name = "Employee")
public class Employee extends AuditableEntity{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@Column
	private Integer age;
	
	@Column
	private String team;
	
	@Column
	private String gender;
	
	@Column
	private String other;
	
	@Column
	private Boolean active;
	
	@Column
	private Date startingDate;
	
	@ManyToOne
	private Promote promote;
	
	public Promote getPromote() {
		return promote;
	}
	public void setPromote(Promote promote) {
		this.promote = promote;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

}
