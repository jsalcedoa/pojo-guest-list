import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // String[] guests = new String[10];
    private static ArrayList<String> guests = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        insertTestNames();

        do {
            displayMenu();
            int option = getOption();

            if (option == 1) {
                displayGuests(guests);
            } else if (option == 2) {
                addGuest();
            } else if (option == 3) {
                removeGuestByName();
            } else if (option == 4) {
                removeGuestByNum();
            } else if (option == 5) {
                renameGuest();
            } else if (option == 6) {
                System.out.println("Exiting the Application.");
                break;
            } else {
                System.out.println("Invalid Input.");
            }
        } while(true);

    }

    private static void displayMenu() {
        System.out.println("____________________________________________");
        System.out.println("- Menu -");
        System.out.println();
        System.out.println("1 - Display All Guests.");
        System.out.println("2 - Add Guest.");
        System.out.println("3 - Remove Guest by Name.");
        System.out.println("4 - Remove Guest by Number.");
        System.out.println("5 - Edit Guest by Name.");
        System.out.println("6 - Exit.");
        System.out.print("Enter number: ");
    }

    private static int getOption() {
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }

    private static void insertTestNames() {
        guests.add("John Doe");
        guests.add("Jane Doe");
        guests.add("Juan Doe");
    }
    private static void displayGuests(ArrayList<String> guests) {
        System.out.println("____________________________________________");
        if (guests.size() == 0) {
            System.out.println("The list of guests is empty.");
        } else {
            System.out.println("Printing All Guests:");
            /* for (String guest : guests) {
                System.out.println(guest);
            } */
            for (int i = 0; i < guests.size(); i++) {
                System.out.println(i+1 + ". " + guests.get(i));
            }
        }
    }

    private static void addGuest() {
        System.out.println("____________________________________________");
        System.out.print("Enter Name: ");
        guests.add(scanner.nextLine());
        System.out.println("Name added successfully.");
    }

    private static void removeGuestByName() {
        boolean nameFound = false;
        System.out.println("____________________________________________");
        System.out.print("Enter NAME to DELETE: ");
        String name = scanner.nextLine();

        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i) != null && guests.get(i).equals(name)) {
                nameFound = true;
                guests.remove(i);
                break;
            }
        }

        if (!nameFound) {
            System.out.println("The name entered is NOT in the list.");
        }
    }

    private static void removeGuestByNum() {
        System.out.println("____________________________________________");
        System.out.print("Enter the NUMBER to DELETE: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num < guests.size() + 1) {
            guests.remove(num - 1);
        } else {
            System.out.println("There is no guest with that number.");
        }
    }

    private static void renameGuest() {
        System.out.println("____________________________________________");
        System.out.print("Enter the NUMBER of name to be renamed: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num < guests.size() + 1) {
            System.out.print("Enter the new name: ");
            String newName = scanner.nextLine();
            guests.set(num - 1, newName);
            System.out.println("Name successfully renamed.");
        } else {
            System.out.println("There is no guest with that number.");
        }
    }
}