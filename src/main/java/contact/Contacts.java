package contact;

import java.util.logging.Logger;
import java.util.Scanner;

class Contact{
    private static final Logger log = Logger.getLogger("InfoLogging");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll =  new LinkedList();
        int option;
        try{
        do{
            log.info("\n1.Insert info\n2.Display info\n3.Search\n4.Delete info\n5.Exit\nEnter option: ");
            option = sc.nextInt();
                if(option!=5){
                    switch(option){
                        case 1:
                        //insert
                        log.info("Enter contact name: ");
                            String name = sc.next();
                        log.info("Enter phone number: ");
                            long phone = sc.nextLong();
                        log.info("Enter Email address: ");
                            String email = sc.next();
                        ll.insert(name, phone, email);
                        break;
                        case 2:
                        //diplay
                        ll.display();
                        break;
                        case 3:
                        //search
                        log.info("Search by name: ");
                        String search = sc.next();
                        ll.search(search);
                        break;
                        case 4:
                        //delete contact
                        ll.delete();
                        break;
                        default:
                        log.info("Enter a valid option: ");
                        }
                }
         }while(option !=5);
        }catch(Exception e){
            String exp = ""+e;
            log.info(exp);
        }
    }
}