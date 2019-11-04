package com.cognizant.springlearn.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="em_id")
	private int id;
	@Column(name="em_name")
	private String name;
	@Column(name="em_salary")
	private double salary;
	@Column(name="em_permanent")
	private boolean permanent;
	@Column(name="em_date_of_birth")
	private Date dateOfBirth;
	
	 @ManyToOne
	 @JoinColumn(name = "em_dp_id")
	 private Department department;
	 
	 
//	 @JsonManagedReference
	 @ManyToMany
	    @JoinTable(name = "employee_skill",
	        joinColumns = @JoinColumn(name = "es_em_id"), 
	        inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
	    private Set<Skill> skillList;
	 
	 public Employee(int id, String name, double salary, boolean permanent, Date dateOfBirth, Department department,
			Set<Skill> skillList) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.skillList = skillList;
	}

	public Employee() {
			super();
		}

	public Set<Skill> getSkillList() {
		return skillList;
	}
	public void setSkillList(Set<Skill> skillList) {
		this.skillList = skillList;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + "]";
	}
	
	
}




/*
public class Employee {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	
	private int id;
	private String name;
	private double salary;
	private boolean permanent;
	private Date dateOfBirth;
	private Department department;
	private Skill[] skills;
	
	
	public Skill[] getSkills() {
		return skills;
	}


	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Employee() {
		LOGGER.debug("Inside Employee Constructor");
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skills=" + Arrays.toString(skills)
				+ "]";
	}
	

}
*/