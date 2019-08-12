package ui;

import java.util.Scanner;
import logic.PhoneBook;

public class TextUserInterface {

    private PhoneBook phoneBook;
    private Scanner scanner;

    public TextUserInterface(Scanner scanner) {
        this.scanner = scanner;
        phoneBook = new PhoneBook();
    }

    public void start() {
        userInstructions();

        while (true) {
            if (!readInput()) {
                break;
            }
        }
    }

    private void userInstructions() {
        System.out.println("phone search");
        System.out.println("available operations");
        System.out.println("  1 add a number");
        System.out.println("  2 search for a number");
        System.out.println("  3 search for a person by phone number");
        System.out.println("  4 add an address");
        System.out.println("  5 search for personal information");
        System.out.println("  6 delete personal information");
        System.out.println("  7 filtered listing");
        System.out.println("  x quit");
    }

    private boolean readInput() {
        System.out.print("\ncommand: ");
        String command = scanner.nextLine();

        if (command.equals("x")) {
            return false;
        }

        handleInput(command);
        return true;
    }

    private void handleInput(String command) {
        if (command.equals("1")) {
            addNumber();
        } else if (command.equals("2")) {
            searchPhoneNumber();
        } else if (command.equals("3")) {
            searchPersonByPhoneNumber();
        } else if (command.equals("4")) {
            addAddress();
        } else if (command.equals("5")) {
            searchForPersonalInfo();
        } else if (command.equals("6")) {
            deletePersonalInformation();
        } else if (command.equals("7")) {
            filteredListing();
        }
    }

    private String readName() {
        System.out.print("whose number: ");
        return scanner.nextLine();
    }

    private String readNumber() {
        System.out.print("number: ");
        return scanner.nextLine();
    }

    private void addNumber() {
        phoneBook.addNumber(readName(), readNumber());
    }

    private void searchPhoneNumber() {
        phoneBook.searchNumber(readName());
    }

    private void searchPersonByPhoneNumber() {
        phoneBook.searchPersonByPhoneNumber(readNumber());
    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = scanner.nextLine();
        System.out.print("street: ");
        String street = scanner.nextLine();
        System.out.print("city: ");
        String city = scanner.nextLine();

        phoneBook.addAddress(name, street, city);
    }

    private void searchForPersonalInfo() {
        System.out.print("whose information: ");
        String name = scanner.nextLine();

        phoneBook.searchForPersonalInfo(name);
    }

    private void deletePersonalInformation() {
        System.out.print("whose information: ");
        String name = scanner.nextLine();

        phoneBook.getPhoneBook().remove(name);
    }

    private void filteredListing() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = scanner.nextLine();

        phoneBook.filteredListing(keyword);
    }
}
