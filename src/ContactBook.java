import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ContactBook {
    private List<Contact> contacts;

    public ContactBook() {
        contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Contact searchContactByEmail(String email) {
        for (Contact contact : contacts) {
            if (contact.getEmail().equals(email)) {
                return contact;
            }
        }
        return null;
    }

    public void printList() {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email: " + contact.getEmail());
        }
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContact(String name) {
        Contact contact = searchContact(name);
        if (contact != null) {
            contacts.remove(contact);
        } else {
            System.out.println("Error, Contact is not available.");
        }
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Contact Book Menu:");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");

            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice.toUpperCase()) {
                case "A":
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();
                    contactBook.addContact(new Contact(name, phoneNumber, email));
                    break;
                case "D":
                    System.out.println("Enter name of contact you want to delete: ");
                    String contactNameForDeletion = scanner.nextLine();
                    contactBook.deleteContact(contactNameForDeletion);
                    break;
                case "E":
                    System.out.println("Enter email of contact you want to search: ");
                    String emailForSearch = scanner.nextLine();
                    Contact contactByEmail = contactBook.searchContactByEmail(emailForSearch);
                    if (contactByEmail != null) {
                        System.out.println("Name: " + contactByEmail.getName());
                        System.out.println("Phone Number: " + contactByEmail.getPhoneNumber());
                        System.out.println("Email: " + contactByEmail.getEmail());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case "P":
                    contactBook.printList();
                    break;
                case "S":
                    System.out.println("Enter name of contact you want to search: ");
                    String nameForSearch = scanner.nextLine();
                    Contact contactByName = contactBook.searchContact(nameForSearch);
                    if (contactByName != null) {
                        System.out.println("Name: " + contactByName.getName());
                        System.out.println("Phone Number: " + contactByName.getPhoneNumber());
                        System.out.println("Email: " + contactByName.getEmail());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case "Q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error! Input Unavailable!");
            }
        }
    }
}