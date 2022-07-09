/**
 * Name: <INSERT NAME>
 * Date: <INSERT DATE> 
 * Description:  <INSERT PROGRAM DESCRIPTION>
 */
// Create People class here



// Put Person class from last assignment here (Student class is not needed)



/** Main class - contains entry point */
// DO NOT MODIFY ANY CODE BELOW
public class Main2Template {
  public static void main(String[] args) {
    // instantiate a new People object
    People people = new People();

    // add some Person objects
    boolean addedAllPeople = true;
    addedAllPeople &= people.addPerson(new Person("Eleanor",    38));
    addedAllPeople &= people.addPerson(new Person("Tahani",     33));
    addedAllPeople &= people.addPerson(new Person("Chidi",      39));
    addedAllPeople &= people.addPerson(new Person("Jason",      31));
    addedAllPeople &= people.addPerson(new Person("Michael", 20000));
    addedAllPeople &= people.addPerson(new Person("Janet",   10000));
    
    // create pointers to two Persons
    Person p1;
    Person p2;
    
    // initialize them with the results of our searches
    p1 = people.findPersonByName("Chidi");
    p2 = people.findPersonByAge(10000);
    
    // check if our results are correct
    //Mysterious.checkAnswer(addedAllPeople, p1, p2);
  }
}
