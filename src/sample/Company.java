package sample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Company extends Business{

    private String Country;
    private double profit;
    private String Industry;

    Company(int rank, String name, double revenue, int employeeCt, String country, float profit, String industry) {
        super(rank, name, revenue, employeeCt);
        this.Country = country;
        this.profit = profit;
        this.Industry = industry;
    }

    String getCountry() {
        return Country;
    }

    void setCountry(String country) {
        Country = country;
    }

    double getProfit() {
        return profit;
    }

    void setProfit(float profit) {
        this.profit = profit;
    }

    String getIndustry() {
        return Industry;
    }

    void setIndustry(String industry) {
        Industry = industry;
    }


    public String toString() {
        String desc = "";
        desc += "Company: " + this.getName() + ", belongs to the " + this.getIndustry() + " industry, but is home to " + this.getCountry();
        desc += "With" + this.getEmployeeCt() + " employees," + this.getName() + "earns" + this.getRevenue() + "in revenue, but only makes a profit of" + this.getProfit();
        desc += "Considering the previous data" + this.getName() + " earns a global rank of" + this.getRank();
        return desc;
    }

    static void read(String dataFilePath) {
        // try to create Scanner
        Scanner scanner = null;
        try {
            File file = new File(dataFilePath);
            scanner = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problem opening file: " + dataFilePath);
        }
        if (scanner == null) {
            return;
        }


        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            Scanner lineScanner = new Scanner(next);
            lineScanner.useDelimiter("\t");

            int ranking = lineScanner.nextInt();
            int peak = lineScanner.nextInt();
            String title = lineScanner.next();
            long revenue = lineScanner.nextLong();
            int year = lineScanner.nextInt();

            int rank = lineScanner.nextInt();
            String name = lineScanner.next();
            int employeeCt = lineScanner.nextInt();
            String country = lineScanner.next();
            int profit = lineScanner.nextInt();
            String industry = lineScanner.next();

            Company businessData = new Company(rank, name, revenue, employeeCt, country, profit, industry);
        }
    }
}
