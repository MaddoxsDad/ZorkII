   public class Person{
    private String firstName;
    private String lastName;
    private String mmName; //Mothers maiden name
    private String birthCity;

    public Person(String firstName, String lastName, String mmName, String     birthCity) {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getMmName() {
        return mmName;
    }

    public String getBirthCity() {
        return birthCity;
    }
 
    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }
  
