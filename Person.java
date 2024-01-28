public class Person
   private String firstName;
   private String lastName;
   private String mmName; //Mothers maiden name
   private String birthCity;

   public Person(String firstName, String lastName, String mmName, String birthCity) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.mmName = mmName;
       this.birthCity = birthCity;
 } 
//Getters and Setters
   public String getFirstName() {
       return firstName;
 }
   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }

