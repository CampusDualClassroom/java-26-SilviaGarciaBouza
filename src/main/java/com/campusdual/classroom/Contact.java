package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.Map;
import java.util.regex.Pattern;

public class Contact implements ICallActions {

    private String name;
    private String surnames;
    private String phoneNumber;
    private String code;
    private static final Pattern DIACRITICS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");


    public Contact(String phoneNumber, String surname,String name) {
        this.name = name;
        this.surnames = surname;
        this.phoneNumber = phoneNumber;
        this.code = generateCode();
    }


    private String generateCode() {
        String firstName = this.phoneNumber.split(" ")[0];
        String firstInitial = firstName.substring(0, 1).toLowerCase();
        String normalizedSurnames;
        if (this.surnames.contains(" ")) {
            normalizedSurnames = Normalizer.normalize(this.surnames.charAt(0) + this.surnames.substring(this.surnames.indexOf(" ") + 1), Normalizer.Form.NFD);
        } else if (countSpaces() > 1) {
            normalizedSurnames = Normalizer.normalize(this.surnames.charAt(0) + this.surnames.substring(this.surnames.indexOf(" ") + 1), Normalizer.Form.NFD);
        } else {
            normalizedSurnames = Normalizer.normalize(this.surnames, Normalizer.Form.NFD);
        }
        normalizedSurnames = normalizedSurnames.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replace(" ", "");
        normalizedSurnames = normalizedSurnames.toLowerCase();
        return firstInitial + normalizedSurnames;
    }

    private int countSpaces() {
        int count = 0;
        for (int i = 0; i < this.getSurnames().length(); i++) {
            if (this.getSurnames().charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurname(String surname) {
        this.surnames = surname;
    }

    public String getPhone() {
        return phoneNumber;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String id) {
        this.code = id;
    }

    @Override
    public void callMyNumber() {
        System.out.println("LLAma a: ");
        showContactDetails();
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("El numero del nombre: " + this.name + " y con Apellidos: " + this.surnames + " Llama al numero " + number);


    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + getName() + " Apellidos: " + getSurnames() + " Codigo " + getCode() + " Telefono " + getPhone());

    }


    public Contact getContact(Phonebook p, String numeber) {
        Contact c = null;
        for (Map.Entry<String, Contact> element : p.data.entrySet()) {
            element.getValue().getPhone().equals(numeber);
            c = element.getValue();
        }
        return c;

    }


}
