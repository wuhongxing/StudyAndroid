package com.example.design_pattern.interfaceegregation;

//public class Dog implements IAnimalAction {
//    @Override
//    public void eat() {
//
//    }
//
//    @Override
//    public void fly() {
//
//    }
//
//    @Override
//    public void swim() {
//
//    }
//}

public class Dog implements ISwimAnimalAction, IEatAnimalAction {

    @Override
    public void eat() {

    }

    @Override
    public void swim() {

    }
}
