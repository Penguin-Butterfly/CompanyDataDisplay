package sample;

import java.time.LocalDate;
import java.util.ArrayList;

class Business {
    private static ArrayList<Business> Businesses;
    private int rank;
    private String Name;
    private double Revenue;
    private int EmployeeCt;
    private static Controller listController;

    public Business(int rank, String name, double revenue, int employeeCt) {
        this.rank = rank;
        Name = name;
        Revenue = revenue;
        EmployeeCt = employeeCt;

        if (Businesses == null) Businesses = new ArrayList<Business>();
        Businesses.add(this);
    }

    int getRank() {
        return rank;
    }

    void setRank(int rank) {
        this.rank = rank;
    }

    String getName() {
        return Name;
    }

    void setName(String name) {
        Name = name;
    }

    double getRevenue() {
        return Revenue;
    }

    void setRevenue(float revenue) {
        Revenue = revenue;
    }

    int getEmployeeCt() {
        return EmployeeCt;
    }

    void setEmployeeCt(int employeeCt) {
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

    public static Controller getMyController() {
        return listController;
    }

    public static void setlistController(Controller listController) {
        Business.listController = listController;
    }

    public static ArrayList<Business> getAllMyData() {
        return Businesses;
    }




}
