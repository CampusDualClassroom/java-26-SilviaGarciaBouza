package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {
        Contact c = new Contact("999999999","DDD","BBB");
        Contact c2= new Contact("77777777","EEE","AAA");
        Contact c3 = new Contact("000000000","FFF","CCC");
        Phonebook pb= new Phonebook();
        pb.addContact(c);
        pb.addContact(c2);
        pb.addContact(c3);
        pb.menu();
    }
}
