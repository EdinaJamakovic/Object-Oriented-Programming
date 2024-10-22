package labs.lab4.people;

public class Person {
    private String name;
    private String adress;
    private int age;
    private String country;

    public Person(String name, String adress){
        this.name = name;
        this.adress = adress;
    }

    public Person(String name, String adress, int age, String country){
        this.name = name;
        this.adress = adress;
        this.age = age;
        this.country = country;
    }

    public int getAge(){
        return this.age;
    }

    public String getCountry(){
        return this.country;
    }



    public String toString(){
        return this.name + "\n   " +  this.adress;
    }
}
