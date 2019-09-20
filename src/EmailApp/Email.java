package EmailApp;

import java.util.Scanner;

public class Email {
	private String forename;
	private String surname;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "trialerLTD.com";
	
	public Email(String forename, String surname) {
		this.forename = forename;
		this.surname = surname;
		
		this.department = setDepartment();
		
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		email = forename.toLowerCase() + "." + surname.toLowerCase() + "@" + department + "." + companySuffix;

	}
	
	
	private String setDepartment() {
		System.out.print("New Employee: " + forename + ". Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code");
		Scanner in = new Scanner(System.in);
		in.hasNextInt();
		int deptChoice = in.nextInt();
		if (deptChoice == 1) {return "sales"; }
		else if (deptChoice == 2) { return "develop"; }
		else if (deptChoice == 3) { return "account"; }
		else { return ""; }
	}
	
	//This method creates a random password by iterating through the array to randomly select ten characters. 
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?@$%#";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "Display Name: " + forename + "" + surname +
				"\nCompany Email: " + email + 
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}
}