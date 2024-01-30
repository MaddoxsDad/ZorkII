   public class Person{
    private String firstName;
    private String lastName;
    private String mmName; //Mothers maiden name
    private String birthCity;

    public Person(String firstName, String lastName, String mmName, String     birthCity) {
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.mmName = mmName.toLowerCase();
        this.birthCity = birthCity.toLowerCase();
    }

  //Get and Set

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
 
    public String getMmName() {
        return mmName;
    }

    public void setMmName(String mmName) {
        this.mmName = mmName;
    }
 
    public String getBirthCity() {
        return  birthCity;
    }
    
    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
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

   //Method to gen Star Wars name

    public String getStarWarsName() {
        String swFirstName = firstName.substring(0, 3)+ lastName.substring(0,1).toUpperCase();
        String swLastName = mmName.substring(0, 2) + birthCity.substring(0, 3);
        return swFirstName + " " + swLastName;
   }

   //Method to generate Sith Lord name

   public String getSithLordName(){
       String sithFirstName = "Darth";
       String sithLastName = firstName.substring(0,3) + lastName.substring(0,1).toUpperCase();
       return sithFirstName + " " + sithLastName;
   }
}
