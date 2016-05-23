package com.tr.exercise.peoplestats.domain;

/**
 * Person domain object
 */
public class Person {

    private String name;
    private String birthMonth;
    private String age;
    private String office;

    public Person(String name, String birthMonth, String age, String office) {
        this.name = name;
        this.birthMonth = birthMonth;
        this.age = age;
        this.office = office;
    }

    public String getName() { return name; }

    public String getBirthMonth() { return birthMonth; }

    public String getOffice() {
        return office;
    }

    public String getAge() { return age; }

}
