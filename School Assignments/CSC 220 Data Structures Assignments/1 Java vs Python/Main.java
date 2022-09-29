/**************************************************************
 * Name: Colin Bumpass, CSC 220 - 003
 * Date: September 19, 2021
 * Desc:  Program 1: Java vs Python. Given a python file with
 *        a parent class "Person" and an inheiritting child 
 *        subclass "Student," as well as a function "birthday",
 *        translate the file's contents to work in a java file.
 *************************************************************/
 
/** 
 * Person class: The parent class of the "Student" subclass,
 * this class takes in an instance's name and age as fields and
 * determines if they are a student using the subclas, and finally
 * prints out a statement with the instance's name, age, and if 
 * they're a student.
**/
class Person {
  // Declare fields
  // Be sure to start fields with private unless otherwise
  private String name;
  private int age;
  public boolean isStudent;

  // Create the Person Class constructor
  public Person(String name, int age){
    // Initialize fields
    this.name = name;
    this.age = age;
    this.isStudent = false;
  }

  // Create the Birthday function
  // Increase instance's age field by 1

  public void birthday(){
    // increase the age field by 1
    // Note that this function doesn't return anything, it just does its job
    this.age += 1;
  }

  // Create the toString function
  // Returns a string with the following text, changes 
  // depending on the boolean's value
  public String toString(){
    // If true....
    if (this.isStudent)
      // return string saying object is a student
      // notice there are no {}, as it returns one line
      return (this.name + " is a student and is " + this.age + " years old");
    else
      // return string saying object is not a student
      return(this.name + " is not a student and is " + this.age + " years old");
  }
}

/** 
 * Student Class: Inherits from the Person parent class.
 * If the instance calls the student class, the boolean field 
 * that determines if they're a student switches to true.
**/
class Student extends Person {
  // Create the student's constructor
  public Student(String name, int age){
    // Call the parent's constructor with the parameters the super class needs (name and age fields.)
    super(name, age);
    // Boolean field switches to True
    this.isStudent = true;
  }
}

/** Main class - contains entry point */
public class Main {
  public static void main(String[] args) {
    // Create new Student instance with name and age
    Student s1 = new Student("Bob", 20);
    // Print statement, calls the toString function in Person Class
    System.out.println(s1);
    // Call the birthday function in Person Class
    s1.birthday();
    // Print statement, call the toString function again with new age
    System.out.println(s1);

    // Create new Person instance with name and age
    Person p1 = new Person("Rob", 22);
    // Print statement, calls the toString function in Person Class
    System.out.println(p1);
  }
}
