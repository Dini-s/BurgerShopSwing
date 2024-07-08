package Control;

import DB.CustomerList;
import Model.Customer;

public class BurgerShop {

    public static CustomerList list=new CustomerList();


    public static final double UNITPRICE = 500.00;
    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int Cancel = 2;

    public static String getOrdID(){
        if(list.size()==0){
            return "O0001";
        }
        String lastOrdId=list.getLast().getOrdID();
        int number=Integer.parseInt(lastOrdId.split("O")[1]);
        number++;
        return String.format("O%04d",number);
    }

    public static boolean isValid(String phone){
        if(phone.length()==10 || phone.charAt(0)==0){
            return  true;
        }
        return false;
    }

    public static Customer[] removeDuplicate(){
        //copy customer object details to tempery object array
        Customer[] temp1=new Customer[list.size()];

        for(int i=0;i< temp1.length;i++){
            temp1[i]=list.get(i);
        }
        //check and update values
        Customer[] temp2=new Customer[0];
        for(int i=0;i<temp1.length;i++){
            boolean isExist=false;

            for (int j = 0; j < temp2.length; j++) {

                if (temp1[i].getPhone().equals(temp2[j].getPhone())) {
                    temp2[j].setPrice(temp2[j].getTotal() + temp1[i].getTotal());
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                Customer[] temp3 = new Customer[temp2.length + 1];
                for (int j = 0; j < temp2.length; j++) {
                    temp3[j] = temp2[j];
                }
                temp3[temp3.length - 1] = temp1[i];
                temp2 = temp3;
            }
        }
        return temp2;
    }
    //sort object array by price
    public static Customer[] sortByPrice(){
        System.out.println("duplicate length:"+removeDuplicate().length);
        Customer[] temp1=removeDuplicate();
        for(int i=0;i< temp1.length-1;i++){
            for(int j=0;j<temp1.length-1-i;j++){
                if(temp1[j].getTotal()<=temp1[j+1].getTotal()){
                    Customer tempVar=temp1[j];
                    temp1[j]=temp1[j+1];
                    temp1[j+1]=tempVar;
                }
            }
        }
        return temp1;
    }
}
