public class PersonTest {
    public static void main(String[] args){
        //MY attempt to create a person instance and test methods
        Person person1 = new Person("John", "Sam", "Smith", "Biloxi");
        int vowels = person1.getNumVowels();
        String starWarsName = person1.getStarWarsName();
        String sithLordName = person1.getSithLordName();

        //Hopefully Print
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Star Wars Name: " + starWarsName);
        System.out.println("Sith Lord Name: " + sithLordName);
    }
}
