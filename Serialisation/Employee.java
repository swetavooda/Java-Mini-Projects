/*Serialization is a mechanism of converting the state of an object into a byte stream.
Deserialization is the reverse process where the byte stream is used to recreate the actual 
Java object in memory. This mechanism is used to persist the object.To make a Java object 
serializable we implement the java.io.Serializable interface.
The ObjectOutputStream class contains writeObject() method for serializing an Object.
Advantages of Serialization
1. To save/persist state of an object.
2. To travel an object across a network.
Only the objects of those classes can be serialized which are implementing 
java.io.Serializable interface.
Serializable is a marker interface (has no data member and method).
It is used to 'mark' java classes so that objects of these classes may get certain capability. 


Points to remember
1. If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true.
2. Only non-static data members are saved via Serialization process.
3. Static data members and transient data members are not saved via Serialization process.So, if you don’t want to save value of a non-static data member then make it transient.
4. Constructor of object is never called when an object is deserialized.
5. Associated objects must be implementing Serializable interface.*/


import java.io.Serializable;  
public class Employee implements Serializable{  
/*Select the instance variables which would be marked as transient*/
 int id;  
 String name;  
 transient String fname;
 transient String lname;
 public Employee(int id, String name) {  
  this.id = id;  
  this.name = name;
  String names[] = name.split(" ");
  this.fname = names[0];
  this.lname = names[1];
 }  
}  
