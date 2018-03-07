package com.java8.optional;


import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        Optional<User> a = Optional.ofNullable(null); // will return anonymous
//        Optional<User> a = Optional.ofNullable(new User());  // will return prem
        User user=OptionalExamples.getUserWithName(a);
        System.out.println(user.getName());
    }


    public static User getUserWithName(final Optional<User> user){
        user.ifPresent(usr-> usr.setName("Prem")); //if user not null do this with user
        return user.orElse(new User("Anonymous"));// if user is null set default user
    }
}

class User{
    String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public User(String name){
        this.name=name;
    }
    public User(){

    }
}