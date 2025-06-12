/*
 * Write a Java program having a class “Person” and with attributes name, age and gender.
 *  Create the getter and setter methods for each attribute in “Person” class and display()
 *  method to display the information of the person. Use the “Person” class in the “Main” 
 * class by creating the object of the “Person” class.
*/

class Person{
    String name;
    short age;
    char gender;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public short getAge() {
        return age;
    }
    public void setAge(short age) {
        this.age = age;
    }
    
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public void display(){
        System.out.printf("""
                Name    =>  %s
                Age     =>  %d
                Gender  =>  %c
                """, name, age, gender);
    }
}
class JavaProgramWithClassAndObject{
    public static void main(String[] arg){
        Person person1 = new Person();

        person1.setName("Aman");
        person1.setAge((short)24);
        person1.setGender('M');
        System.out.println("The person1 before age updation");
        person1.display();
        
        Person person2 = new Person();
        
        person2.setName("Kiara");
        person2.setAge((short)21);
        person2.setGender('F');
        System.out.println("The person2 before age updation");
        person2.display();
        
        person1.setAge((short)19);
        System.out.println("The person1 after age updation");
        person1.display();
        
        person2.setAge((short)18);
        System.out.println("The person2 after age updation");
        person2.display();
    }
}