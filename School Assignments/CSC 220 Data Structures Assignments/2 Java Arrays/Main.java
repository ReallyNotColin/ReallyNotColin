/*
************************************************************************
 * Name: Colin Bumpass, CSC 220 - 003
 * Date: September 27, 2021
 * Description: Program 2: Creates and uses the People Class, which uses 
 * the Person Class from the previous program to create an array of 5 
 * Person objects and goes through each object at indecies 0-4 to find 
 * the desired name and age in the Main Class, and returns nothing if 
 * the array's index is >= 5.
 * The Good Place is the best show ever
 * *********************************************************************
*/

/* The People Class creates an array of Person objects and houses
   functions that find a specific Person using their name and age */
class People {
  /* Creates the "group" array with 5 spaces for Person objects */
  private Person[] group;
  
  /* Create the index/walker field to "walk" the array */
  private int index;

  /* The People constructor:
     Allocates space for 5 person objects in array "group" 
     Sets the field "index" to 0 */
  public People(){
    /* Create 5 "spaces" in the group array for the "Person" data type */
    group = new Person [5];
    /* Sets the index field equal to 0 */
    index = 0;
  }

  /* The addPerson method:
     Returns true if there's space left in the "group" array for "Person" objects 
     Returns false if there are 5 Person objects in the array */
  public boolean addPerson (Person p) {
    
    /* returns false if 5 Person objects have already been added to the group */
    if (index >= 5){
      return false;
    }

    /* returns true if otherwise */
    else {
      /* Sets the "Person" object equal to the current index value */
      // POST SUBMISSION NOTE: Get positionOf???
      group[index] = p;
      /* Increases the index by one, moving further down the array */
      ++ index;
      return true;
    }
  }

  /* The findPersonByName Method:
     Uses for-loops to identify the "name" attributes of the Person objects at 
     certain indices of the "group" array.
     Returns the name of the Person object if found.
     Returns "null" if the name cannot be found.*/
  public Person findPersonByName(String name){
    for (int n = 0; n <= group.length - 1; n++){
    /* If the "name" attribute matches a the name of one of the Person objects,
     returns the Person object's name. */ 
      if (name == group[n].name){
        return group[n];
      }
    }
    /* If the name attribute cannot be found, returns null */
    return null;
  }

  /* The findPersonByAge Method:
     Uses for-loops to identify the "age" attributes of the Person objects at 
     certain indecies of the "group" array.
     Returns the age of the Person object if found.
     Returns "null" if the name cannot be found.*/
  public Person findPersonByAge(int age){
    for (int n = 0; n <= group.length -1; n++){
      /* If the "name" attribute matches a the name of one of the Person objects,
     returns the Person object's name. */ 
      if (age == group[n].age){
        return group[n];
      }
    }
    /* If the name attribute cannot be found, returns null */
    return null;
  }


}

/* Put Person class from last assignment here (Student class is not needed) */
class Person {
  /* Declare and initialize fields */
  String name;
  int age;
  boolean isStudent;

  /* Create the Person Class constructor */
  public Person(String name, int age){
    this.name = name;
    this.age = age;
    this.isStudent = false;
  }

  /* Create the toString function */
  /* Returns a string with the following text, changes */
  /* depending on the boolean's value */
  public String toString(){
    if (this.isStudent){
      return (this.name + " is a student and is " + this.age + " years old");
    }
    else{
      return(this.name + " is not a student and is " + this.age + " years old");
    }
  }
}


/** Main class - contains entry point */
// DO NOT MODIFY ANY CODE BELOW
public class Main {
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
    Mysterious.checkAnswer(addedAllPeople, p1, p2);
  }
}
