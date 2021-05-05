package sample;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Business implements Serializable {
    public static ArrayList<Business> Businesses;
    public int rank;
    public String Name;
    public double Revenue;
    public int EmployeeCt;
    public static Controller listController;

    public Business(int rank, String name, double revenue, int employeeCt) {
        this.rank = rank;
        this.Name = name;
        this.Revenue = revenue;
        this.EmployeeCt = employeeCt;

        if (Businesses == null) Businesses = new ArrayList<Business>();
        Businesses.add(this);
    }

    public static ArrayList<Business> getBusinesses() {
        return Businesses;
    }

    public static void setBusinesses(ArrayList<Business> businesses) {
        Businesses = businesses;
    }

    public void setRevenue(double revenue) {
        Revenue = revenue;
    }

    public static void setListController(Controller listController) {
        Business.listController = listController;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getRevenue(){return Math.round(Revenue);}

    public void setRevenue(float revenue) {
        Revenue = revenue;
    }

    public int getEmployeeCt() {
        return EmployeeCt;
    }

    public void setEmployeeCt(int employeeCt) {
        EmployeeCt = employeeCt;
    }

    public String toString() {
        String desc = "";
        desc += "Company: " + this.getName() + ", " + this.getRank() + ", " + this.getRevenue();
        return desc;
    }

    static void describeAll() {
        Businesses.forEach(Business -> System.out.println(Business.toString()));
    }

    public static Controller getlistController() {
        return listController;
    }

    public static void setlistController(Controller listController) {
        Business.listController = listController;
    }

    public static ArrayList<Business> getAllMyData() {
        return Businesses;
    }




}
