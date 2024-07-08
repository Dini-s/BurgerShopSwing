package DB;

import Model.Customer;

public class CustomerList {

    private Node first;

    public int size(){
        int count=0;
        Node temp=first;
        while(temp !=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public boolean isEmpty(){
        if(size()==0){
            return true;
        }
        return false;
    }

    public Customer get(int index){
        if(isEmpty()){
            return null;
        }
        if(index==0){
            return first.customer;
        }
        else{
            Node temp=first;
            int count=0;
            while(count<index){
                temp=temp.next;
                count++;
            }
            return temp.customer;
        }
    }

    public int get(String value){
        Node temp=first;
        int count=0;
        while(temp.next!=null){
            if(value.equals(temp.customer.getOrdID())){
                return count;
            }
            count++;
            temp=temp.next;
        }
        return -1;
    }
    public boolean isContains(String value){
        Node temp=first;
        while(temp!=null){
            if(value.equals(temp.customer.getPhone())||value.equals(temp.customer.getOrdID())){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public Customer getObject(String value){
        Node temp=first;
        while(temp!=null){
            if((value.equals((temp.customer.getPhone())))||(value.equals((temp.customer.getOrdID())))){
                return temp.customer;
            }
            temp=temp.next;
        }
        return null;
    }

    public void add(Customer obj){
        Node n1=new Node(obj);
        if(isEmpty()){
            first=n1;
        }
        else{
            Node temp=first;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n1;
        }
    }

    public Customer getLast() {
        Node temp = first;
        if (isEmpty()){
            return null;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp.customer;
    }
}
