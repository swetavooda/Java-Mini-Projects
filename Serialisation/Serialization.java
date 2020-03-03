import java.io.*;  
class Serialization{  
 public static void main(String args[]){  
  try{  
  //Creating the object  
  Employee s1 =new Employee(211,"ravi sharma");  
  //Creating stream and writing the object  
  FileOutputStream fout=new FileOutputStream("obj.ser");  
  ObjectOutputStream out=new ObjectOutputStream(fout);  
  out.writeObject(s1);  
  out.flush();  
  //closing the stream  
  out.close();  
  System.out.println("success");  
  /***************************DeSerialization ****************************/
    //Creating stream to read the object  
  ObjectInputStream in=new ObjectInputStream(new FileInputStream("obj.ser"));  
  Employee s=(Employee)in.readObject();  
  //printing the data of the serialized object  
  String names[] = s.name.split(" ");
  s.fname = names[0];
  s.lname = names[1];
  System.out.println(s.id+" "+s.name+" "+s.fname+" "+s.lname);  
  //closing the stream  
  in.close();  
  
  }catch(Exception e){System.out.println(e);}  
 }  
}  