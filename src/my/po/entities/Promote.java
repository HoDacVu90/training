package my.po.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.axonivy.utils.persistence.beans.AuditableEntity;


@Entity
@Table(name = "Promote")
public class Promote extends AuditableEntity {
	
	private static final long serialVersionUID = 1L;


	@Column
	private String creatorName;
	
	@Column
	private Date createDate;
	
	@Column
	private Date targetDate;
	
	@Column
	private String commentVal;
	
	@Column
	private String feedBack;
	
	@Column
	private String priority;
	
	@Column
	private Boolean reject;
	
	@Column
	private Long caseId;
	
	@OneToMany(mappedBy = "promote", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> employees;

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Boolean getReject() {
		return reject;
	}

	public void setReject(Boolean reject) {
		this.reject = reject;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getCommentVal() {
		return commentVal;
	}

	public void setCommentVal(String commentVal) {
		this.commentVal = commentVal;
	}

}
