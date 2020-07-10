package com.balleyne.inheritance.test;

public class RunFarm {
  public static void main(String[] args) {
    Animal animal = new Tiger();
    System.out.println(animal.getRoar());
    animal.setRoar("Chee wee");
    System.out.println(animal.getRoar());
    Tiger tiger = (Tiger)animal;
    tiger.chaseMans();
    System.out.println(tiger.getRoar());
  }
}
