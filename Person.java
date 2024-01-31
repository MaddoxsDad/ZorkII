   public class Person{
    private String firstName;
    private String lastName;
    private String mmName; //Mothers maiden name
    private String birthCity;

    public Person(String firstName, String lastName, String mmName, String     birthCity) {
        this.firstName = capitalizeFirstLetter(firstName);
        this.lastName = capitalizeFirstLetter(lastName);
        this.mmName = capitalizeFirstLetter(mmName);
        this.birthCity = capitalizeFirstLetter(birthCity);
    }

  //Attempt at a Helper method to ensure proper capitalization
    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
  //Get and Set

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = capitalizeFirstLetter(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = capitalizeFirstLetter(lastName);
    }
 
    public String getMmName() {
        return mmName;
    }

    public void setMmName(String mmName) {
        this.mmName = capitalizeFirstLetter(mmName);
    }
 
    public String getBirthCity() {
        return birthCity;
    }
    
    public void setBirthCity(String birthCity) {
        this.birthCity =capitalizeFirstLetter(birthCity);
    }

    //Method for vowel calculation
  
    public int getNumVowels() {
        String fullName = firstName + lastName;
        int numVowels = 0;
        for (char ch : fullName.toLowerCase().toCharArray()) {
            if(ch == 'a'|| ch == 'e'|| ch == 'i'||ch == 'o'|| ch == 'u'){
                numVowels++;
            }
         }
         return numVowels;
   }

   //Method to gen Star Wars name as well as ensuring correct capitalization

    public String getStarWarsName() {
        String swFirstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1).toLowerCase();
        String swLastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1).toLowerCase();
        return swFirstName + " " + swLastName;
   }

   //Method to generate Sith Lord name

   public String getSithLordName(){
       String sithFirstName = "Darth";
       String sithLastName = Character.toUpperCase(firstName.charAt(0)) + lastName.substring(1,3).toLowerCase();
       return sithFirstName + " " + sithLastName;
   }
}
