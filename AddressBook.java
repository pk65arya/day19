package bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String zip;
    private String mobileNumber;

    public Person(String firstname, String lastname, String address, String city, String zip, String mobileNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}

public class AddressBook {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book System program");
        boolean isExit = false;
        do {
            System.out.println("\n\t\tAddress Book System");
            System.out.println("\n\t\tEnter A to Add Person");
            System.out.println("\t\tEnter E to Edit Person");
            System.out.println("\t\tEnter D to Delete Person");
            System.out.println("\t\tEnter S to Show Person Detail");
            System.out.println("\t\tEnter Q to Quit");
            System.out.print("\t\tPlease Select One Option: ");
            char userInput = scanner.nextLine().toUpperCase().charAt(0);
            switch (userInput) {
                case 'A':
                    addContact();
                    break;
                case 'E':
                    editContact();
                    break;
                case 'D':
                    deletePerson();
                    break;
                case 'S':
                    showPersonDetails();
                    break;
                case 'Q':
                    isExit = true;
                    break;
                default:
                    System.out.println("Please select a correct option");
            }
        } while (!isExit);
    }

    private static  showPersonDetails() {
    }

    private static void addContact() {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter Zip: ");
        String zip = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String mobileNumber = scanner.nextLine();

        Person newPerson = new Person(firstName, lastName, address, city, zip, mobileNumber);
        personList.add(newPerson);
        System.out.println(personList.toString());
    }

    private static void editContact() {
        System.out.print("Enter the first name of the person to edit: ");
        String firstName = scanner.nextLine();
        Person person = findPersonByFirstName(firstName);
        if (person != null) {
            System.out.print("Enter new First Name: ");
            person.setFirstname(scanner.nextLine());
            System.out.print("Enter new Last Name: ");
            person.setLastname(scanner.nextLine());
            System.out.print("Enter new Address: ");
            person.setAddress(scanner.nextLine());
            System.out.print("Enter new City: ");
            person.setCity(scanner.nextLine());
            System.out.print("Enter new Zip: ");
            person.setZip(scanner.nextLine());
            System.out.print("Enter new Phone Number: ");
            person.setMobileNumber(scanner.nextLine());
            System.out.println("Contact edited successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }

    private static void deletePerson() {
        System.out.print("Enter the first name of the person to delete: ");
        String firstName = scanner.nextLine();
        Person person = findPersonByFirstName(firstName);
        if (person != null) {
            personList.remove(person);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }

    private static Person findPersonByFirstName(String firstName) {
        for (Person person : personList) {
            if (person.getFirstname().equalsIgnoreCase(firstName)) {
                return person;
            }
        }
        return null;
    }
}