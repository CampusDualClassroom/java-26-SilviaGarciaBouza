package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    Map<String, Contact> data= new HashMap<>();

    public Map<String, Contact> getData() {
        return data;
    }

    public void setData(Map<String, Contact> data) {
        this.data = data;
    }

   public  void addContact(Contact c){
        data.put(c.getCode(), c);
   }
   public  void deleteContact(String code){
        data.remove(code);
   }
   public   void showPhonebook(){
        for(Map.Entry<String, Contact> element: data.entrySet()){
            element.getValue().showContactDetails();
        }
   }

    public Phonebook() {

    }
    public  void menu(){
        int option=0;
        while(option !=5) {
            System.out.println("Elige una opcion: ");
            option = Utils.integer("1-Añadir, 2-Mostrar, 3-menu,4-eliminar, 5-Salir");
            switch (option) {
                case 1: {
                    String name = Utils.string("Escribe el nombre: ");
                    String surname = Utils.string("Escribe el apellido: ");
                    String phone = Utils.string("Escribe el telefono: ");
                    this.addContact(new Contact(phone, surname, name));
                    break;
                }
                case 2: {
                    this.showPhonebook();
                    break;

                }
                case 3: {
                    String phone = Utils.string("Escribe el telefono: ");
                    if(this.existContact(phone)!=null){
                        this.menuContact(this.existContact(phone));
                    }
                    break;
                }
                case 4: {

                    String code = Utils.string("Escribe el codigo: ");
                    this.deleteContact(code);
                    break;
                }
                case 5: {

                    break;
                }
                default:
                    System.out.println("Opcion incorrecta");


            }
        }}



            public void menuContact(Contact c){
                int option=0;
                while(option !=4) {
                    System.out.println("Elige una opcion: ");
                    option = Utils.integer("1-Llamaste a ti mismo, 2-Llamar otro numero, 3-Mostrar datos,4-Salir");
                    switch (option) {
                        case 1: {
                           c.callMyNumber();
                            break;
                        }
                        case 2: {
                            String number= Utils.string("Indica el numero a llamar: ");
                            c.callOtherNumber(number);
                            break;

                        }
                        case 3: {
                           c.showContactDetails();
                            break;
                        }
                        case 4: {

                            break;
                        }

                        default:
                            System.out.println("Opcion incorrecta");


                    }
                }}

        public Contact existContact(String number){

            for(Map.Entry<String, Contact> element: this.data.entrySet()){

                if(element.getValue().getPhone().equals(number)){
                    return element.getValue();
                }

            }
            return null;
        }




}
