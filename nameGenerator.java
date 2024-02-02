import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class nameGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> individuals = new ArrayList<>();
        Person sithLord = null;
        int maxVowels = -1;
        int personCount = 0; // Keep track of the number of individuals

        while (true) {
            personCount++;
            // Prompt for user's first name
            System.out.print("Enter first name #" + personCount + " (or 'done' to exit): ");
            String firstName = scanner.nextLine().trim();
            if (firstName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter last name #" + personCount + ": ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Enter mother's maiden name #" + personCount + ": ");
            String mmName = scanner.nextLine().trim();

            System.out.print("Enter city of birth #" + personCount + ": ");
            String birthCity = scanner.nextLine().trim();

            Person person = new Person(firstName, lastName, mmName, birthCity);
            individuals.add(person);

            // Check for name with most vowels
            int vowelsCount = person.countVowelsInName();
            if (vowelsCount > maxVowels) {
                sithLord = person;
                maxVowels = vowelsCount;
            }
        }

        // Generate and print Star Wars names
        System.out.println("Your Star Wars names are:");
        for (int i = 0; i < individuals.size(); i++) {
            Person person = individuals.get(i);
            String starWarsFirstName = generateStarWarsFirstName(person.getFirstName(), person.getLastName());
            String starWarsLastName = generateStarWarsLastName(person.getMmName(), person.getBirthCity());
            String starWarsName = starWarsFirstName + " " + starWarsLastName;
            System.out.println((i + 1) + ". " + starWarsName);
        }

        // Print Sith Lord name if applicable
        if (sithLord != null) {
            String sithLordFirstName = "Darth " + generateStarWarsFirstName(sithLord.getFirstName(), sithLord.getLastName());
            String sithLordLastName = generateStarWarsLastName(sithLord.getMmName(), sithLord.getBirthCity());
            System.out.println("Your Sith Lord Name is:");
            System.out.println(sithLordFirstName + " " + sithLordLastName);
        }
    }

    public static String generateStarWarsFirstName(String firstName, String lastName) {
        // Combine the first 3 letters of the first name with the first 2 letters of the last name
        return firstName.substring(0, 3) + lastName.substring(0, 2);
    }

    public static String generateStarWarsLastName(String mmName, String birthCity) {
        // Combine the first 2 letters of the mother's maiden name with the first 3 letters of the birth city
        return mmName.substring(0, 2) + birthCity.substring(0, 3);
    }
}

