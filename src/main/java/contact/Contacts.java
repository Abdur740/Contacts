package contact;

import java.util.logging.Logger;
import java.util.Scanner;

class LinkedList{
    private static final Logger log = Logger.getLogger("InfoLogging");
    StringBuilder print = new StringBuilder();
    Node head;
    class Node{
        long phno;
        String contact;
        String email;
        Node next;
        Node(String contact,long phno,String email){
            this.phno = phno;
            this.contact = contact;
            this.email = email;
            next = null;
        }
    }
    void insert(String contact,long phno,String email){
        Node n1 = new Node(contact,phno,email);
        Node temp = head;
        if(head == null){
            head = n1;
        }
        else{
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = n1;
        }

    }
    void search(String search){
        Node temp = head;
        int set=0;
        while (temp!=null){
            if(search.equals(temp.contact)){

                set=1;
                String res = "\nContact found.\nContact: "+temp.contact+"\nPhno: "+temp.phno+"\nEmail Address: "+temp.email+"\n";
                log.info(res);
            }
            temp = temp.next;
        }
        if(set==0)
            {
                log.info("\nContact not found\n");
            }
    }

    void delete(){
        Node temp = head;
        Node prev = temp;
            while(temp.next!=null){
                prev = temp;
                temp = temp.next;
            }
            log.info("Deleted.");
            prev.next=temp.next;
        } 

    

    void display(){
        Node temp = head;
        while(temp!=null){
            print.append("\nContact: "+temp.contact+"\nPhno: "+temp.phno+"\nEmail Address: "+temp.email+"\n");
            temp = temp.next;
        }
        String res =""+print;
        log.info(res);
        print.delete(0,print.length());
    }
}


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
