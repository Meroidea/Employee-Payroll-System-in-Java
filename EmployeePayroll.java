package JavaProjects;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private String department;
	private String jobTitle;
	private double salary;
	private LocalDate dateOfJoining;
	private LocalDate dateOfBirth;
	private String gender;
	private boolean isActive;
	private List<String> benefits;

	// Default constructor
	public Employee() {
		this.benefits = new ArrayList<>();
	}

	// Parameterized constructor
	public Employee(int employeeId, String firstName, String lastName, String address, String phoneNumber, String email,
			String department, String jobTitle, double salary, LocalDate dateOfJoining, LocalDate dateOfBirth,
			String gender, boolean isActive, List<String> benefits) 
	{
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.department = department;
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.isActive = isActive;
		this.benefits = benefits != null ? benefits : new ArrayList<>(); // Handle null benefits
	}

	// Getters
	public int getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getDepartment() {
		return department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public boolean isActive() {
		return isActive;
	}

	public List<String> getBenefits() {
		return benefits;
	}

	// Setters
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setBenefits(List<String> benefits) {
		this.benefits = benefits;
	}

	// Business logic methods
	public void calculatePay() {
		// applying pay calculation logic here
	}

	public void applyBenefit(String benefit) {
		if (!benefits.contains(benefit)) {
			benefits.add(benefit);
		}
	}

	//updating new informations
	public void updateContactInfo(String newAddress, String newPhoneNumber, String newEmail) {
		this.address = newAddress;
		this.phoneNumber = newPhoneNumber;
		this.email = newEmail;
	}

	// Override toString method
	@Override
	public String toString() {
		return "\nEMPLOYEE'S INFORMATION" + "\n\nEmployee Id: " + employeeId +"\nFirst Name: " + firstName+ "\nLast Name: "
				+ lastName + "\nAddress: "+ address + "\nPhone Number: "+phoneNumber+"\nEmail Address: "+ email + "\nDepartment= " + department + "\nJob Title= " + jobTitle
				+ "\nSalary= $" + salary +"\nDate of Employment: "+LocalDate.now()+"\nDate of Birth: "+ LocalDate.of(2002,9, 22)+"\nGender: "+gender;
	}

	// Override equals method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Employee employee = (Employee) obj;
		return employeeId == employee.employeeId;
	}

	// Override hashCode method
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	// Main method for testing
	public static void main(String[] args) {
		List<String> benefits = new ArrayList<>();
		benefits.add("Health Insurance");
		benefits.add("Gym Membership");
		benefits.add("Superannuation Funds");
		benefits.add("Retirement Plan");

		Employee employee = new Employee(1234, "SUJAN", "DARJI", "123 Street, Burwood, NSW Australia", "(+61) 448 170 702", "sujan@employee.kent.edu.au",
				"Engineering", "Cyber Security Expert", 1000000.00, LocalDate.now(), LocalDate.of(1990, 1, 1), "Male", true,
				benefits);

		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter Your Employee PIN: ");
		int inputPin = sc.nextInt();
	 
		if(inputPin == employee.getEmployeeId()) {
		System.out.println(employee);
		
		// Apply a new benefit
		employee.applyBenefit("Employee Benefits");
		System.out.println("\nThis employee is entitled to following benefits: " + employee.getBenefits());
		
		System.out.print("Do you want to update any information? (Y/N)");
		String choice = sc.next();
		
		 if (choice.equalsIgnoreCase("Y")) {
             sc.nextLine(); // Consume newline left-over
             System.out.println("Please update the respective details you want to update and leave other fields blank");
             System.out.print("New Address: ");
             String newAddress = sc.nextLine();
             System.out.print("New Phone Number: ");
             String newPhoneNumber = sc.nextLine();
             System.out.print("New Email: ");
             String newEmail = sc.nextLine();

             employee.updateContactInfo(newAddress, newPhoneNumber, newEmail);
             System.out.println("\nUpdated Contact Info: " + employee);
         }
     } else {
         System.out.println("Sorry! You are not our employee.");
     }

     sc.close();
		
	}
}
