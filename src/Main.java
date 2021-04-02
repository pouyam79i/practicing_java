/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
 */

public class Main {

    static class Person {

        private String firstName;
        private String lastName;
        private int id;

        public Person(String firstName, String lastName, int id){
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        public void express(){
            System.out.println("I feel neutral");
        }

        public void express(String state){
            System.out.println("I feel " + state + " today");

        }

        public void print(){
            System.out.println("person{" +
                    "first name = '" + firstName + '\'' +
                    ", last name = '" + lastName + '\'' +
                    ", id = " + id +
                    '}');
        }

    }

    public static void main(String[] args) {
        Person p1 = new Person("Ted", "Mosby", 123456);
        p1.express();
        p1.express("Happy");
        p1.print();
    }

}
