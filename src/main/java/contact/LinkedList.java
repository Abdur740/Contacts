package contact;

import java.util.logging.Logger;

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