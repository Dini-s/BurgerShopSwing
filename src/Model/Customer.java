package Model;

public class Customer {
    //variable declaration

    private String phone;
    private String customerName;
    private String ordID;
    private int ordStatus;
    private int qty;
    private double total;

    public Customer(){

    }

    public Customer(String phone,String customerName,String ordID,int ordStatus,int qty,double total){
        this.phone=phone;
        this.customerName=customerName;
        this.ordID=ordID;
        this.ordStatus=ordStatus;
        this.qty=qty;
        this.total=total;
    }
    public String getPhone(){
        return phone;
    }
    public String getCustomerName(){return customerName;}
    public String getOrdID(){return ordID;}
    public int getOrdStatus(){return ordStatus;}
    public int getQty(){return qty;}
    public double getTotal(){return total;}


    public void setOrdersId(String ordID){this.ordID=ordID;}
    public void setPhone(String phone){this.phone=phone;}
    public void setCustomerName(String customerName){ this.customerName=customerName; }
    public void setOrderStatus(int ordStatus){ this.ordStatus=ordStatus; }
    public void setOrderQTY(int qty){ this.qty=qty; }
    public void setOrderValue(double total){ this.total=total; }
    public String toString(){
        return "{ "+getPhone()+"-"+getCustomerName()+" - "+getOrdID()+" - "+getQty()+" - "+getTotal()+" - "+getOrdStatus()+" }";
    }

    public void setPrice(double total){
        this.total=total;
    }

}
