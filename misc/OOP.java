public class OOP {
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.schoolName = "abc";

        Student s2 = new Student();
        System.out.println(s2.schoolName);

        Student s3 = new Student();
        s3.schoolName = "xyz";

        System.out.println(s1.schoolName);
    }
}

class Student {
    String name;
    int roll;

    static String schoolName;
    
    void setName(String name) {
       this.name = name;
    } 

    String getName() {
        return this.name;
    }
}

// interface Herbivour {
//     void eatGrass();
// }

// interface Carnivour {
//     void eatMeat();
// }

// class Bear implements Herbivour, Carnivour {
//     public void eatGrass() {
//         System.out.println("Bear eats berries furits sometime");
//     }
//     public void eatMeat() {
//         System.out.println("They eat meat most of the times");
//     }
// }



// class A {
//     String name = "Parent";
//     void show() {
//         System.out.println("Parent Class A");
//     }
// }
// class B extends A {
//     String name = "Child";
//     void print() {
//         System.out.println("Name: " + super.name);
//         System.out.println("Name: " + name);
//     }
//     @Override
//     void show() {
//         System.out.println("Child Class B");
//     }
// }