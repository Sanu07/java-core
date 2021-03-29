package com.java.solution;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {

	private static List<Employee> employees = Arrays.asList(
			new Employee(1, "Cristiano", "Ronaldo", 100, new Address("IN", 101010), 
					Arrays.asList(new Organization("CTS", LocalDate.of(2011, 1, 10)), new Organization("TCS", LocalDate.of(2013, 2, 10)))),
			
			new Employee(2, "Lionel", "Messi", 300, new Address("USA", 12345),
					Arrays.asList(new Organization("IBM", LocalDate.of(2011, 1, 10)), new Organization("TCS", LocalDate.of(2004, 1, 10)))),
			
			new Employee(3, "Neymar", "Da Silva", 200, new Address("CAN", 54321),
					Arrays.asList(new Organization("Infosys", LocalDate.of(2016, 1, 10)), new Organization("Dell", LocalDate.of(2015, 2, 10)))),
			
			new Employee(4, "Ronaldinho", "Gaucho", 400, new Address("USA", 202121),
					Arrays.asList(new Organization("CTS", LocalDate.of(2011, 1, 10)), new Organization("HCL", LocalDate.of(2019, 2, 10)))),
			
			new Employee(5, "Zinedine", "Zidane", 100, new Address("IN", 478596),
					Arrays.asList(new Organization("Google", LocalDate.of(2011, 1, 10)), new Organization("Yahoo", LocalDate.of(2003, 2, 10)))),
			
			new Employee(6, "Lionel", "Messi", 200, new Address("USA", 362589),
					Arrays.asList(new Organization("CTS", LocalDate.of(2011, 1, 10)), new Organization("Yahoo", LocalDate.of(2005, 2, 10)))),
			
			new Employee(7, "Neymar", "Da Silva", 300, new Address("IN", 167597),
					Arrays.asList(new Organization("CTS", LocalDate.of(2011, 1, 10)), new Organization("IBM", LocalDate.of(2018, 2, 10)))),
			
			new Employee(8, "Harry", "Kane", 400, new Address("CAN", 268759),
					Arrays.asList(new Organization("TCS", LocalDate.of(2011, 1, 10)), new Organization("CTS", LocalDate.of(2000, 2, 10)))),
			
			new Employee(9, "Philip", "Lahm", 300, new Address("CAN", 555555),
					Arrays.asList(new Organization("IBM", LocalDate.of(2011, 1, 10)), new Organization("CTS", LocalDate.of(2020, 2, 10)))),
			
			new Employee(1, "Cristiano", "Ronaldo", 100, new Address("IN", 101010),
					Arrays.asList(new Organization("CTS", LocalDate.of(2011, 1, 10)), new Organization("TCS", LocalDate.of(2013, 2, 10)))));

	public static List<Employee> getEmployees() {
		return employees;
	}
}

class Organization {
	private String name;
	private LocalDate joiningDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Organization(String name, LocalDate joiningDate) {
		super();
		this.name = name;
		this.joiningDate = joiningDate;
	}
	
	public Organization() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		if (joiningDate == null) {
			if (other.joiningDate != null)
				return false;
		} else if (!joiningDate.equals(other.joiningDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Organization [name=" + name + ", joiningDate=" + joiningDate + "]";
	}
	
}

class Employee {
	private long id;
	private String firstName;
	private String lastName;
	private long salary;
	private Address address;
	private List<Organization> orgs;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Organization> getOrgs() {
		return orgs;
	}
	public void setOrgs(List<Organization> orgs) {
		this.orgs = orgs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((orgs == null) ? 0 : orgs.hashCode());
		result = prime * result + (int) (salary ^ (salary >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (orgs == null) {
			if (other.orgs != null)
				return false;
		} else if (!orgs.equals(other.orgs))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", address=" + address + ", orgs=" + orgs + "]";
	}
	public Employee(long id, String firstName, String lastName, long salary, Address address, List<Organization> orgs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.address = address;
		this.orgs = orgs;
	}

}

class Address {
	private String country;
	private long zip;

	@Override
	public String toString() {
		return "Address [country=" + country + ", zip=" + zip + "]";
	}

	public Address(String country, long zip) {
		super();
		this.country = country;
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + (int) (zip ^ (zip >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (zip != other.zip)
			return false;
		return true;
	}

}