package sample;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DotCom extends Business implements Serializable{
    public String HQLocation;
    public double MarketCap;
    public int FoundingYear;
    public int FiscalYear;
    public static ArrayList<DotCom> DotComData;

    public void setMarketCap(double marketCap) {
        MarketCap = marketCap;
    }

    public static ArrayList<DotCom> getDotComData() {
        return DotComData;
    }

    public static void setDotComData(ArrayList<DotCom> dotComData) {
        DotComData = dotComData;
    }

    public DotCom(int rank, String name, float revenue, int employeeCt, String HQLocation, float marketCap, int foundingYear) {
        super(rank, name, revenue, employeeCt);
        this.HQLocation = HQLocation;
        this.MarketCap = marketCap;
        this.FoundingYear = foundingYear;
        if (DotComData == null){
            DotComData = new ArrayList<DotCom>();
        }
        DotComData.add(this);
    }

    public String getHQLocation() {
        return HQLocation;
    }

    public void setHQLocation(String HQLocation) {
        this.HQLocation = HQLocation;
    }

    public double getMarketCap() {
        return Math.round(MarketCap);
    }

    public void setMarketCap(float marketCap) {
        MarketCap = marketCap;
    }

    public int getFoundingYear() {
        return FoundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        FoundingYear = foundingYear;
    }

    public int getFiscalYear() {
        return FiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        FiscalYear = fiscalYear;
    }

    public String toString() {
        String desc = "";
        desc += this.getName() + ": " + this.getHQLocation() + ", " + this.getFoundingYear();
        return desc;
    }

    static void read(String datafilePath) {
        File file = new File(datafilePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Can't open " + datafilePath);
        }

        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();
            Scanner lineScanner = new Scanner(next);
            lineScanner.useDelimiter("\t");

            int rank = lineScanner.nextInt();

            String name = lineScanner.next();

            float revenue = lineScanner.nextFloat();

            int FY = lineScanner.nextInt();

            int employeeCt = lineScanner.nextInt();

            float marketCap;
            String mCap = lineScanner.next();
            if (mCap.contains("-")) {
                marketCap = 0;
            }
            else marketCap = Float.parseFloat(mCap);

            String HQLocation = lineScanner.next();

            int foundingYear = lineScanner.nextInt();

            new DotCom(rank, name, revenue, employeeCt, HQLocation, marketCap, foundingYear);

        }

    }

    static void initialize(){
        String DotComFile = "src\\DotComData";
        read(DotComFile);
        getlistController().updateDotComs();
        Business.describeAll();
    }


    static public void save() {
        if (DotComData != null && !DotComData.isEmpty()) {
            try {
                File saveFile = new File("C:\\Users\\Bfly\\Downloads\\School work\\Comp sci\\DotComs");
                FileOutputStream FileSaved = new FileOutputStream(saveFile);
                ObjectOutputStream out = new ObjectOutputStream(FileSaved);
                out.writeObject(DotComData);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static public boolean load() {
        File saveFile = new File("C:\\Users\\Bfly\\Downloads\\School work\\Comp sci\\DotComs");
        if (saveFile.exists()) {
            try {
                FileInputStream FileSaved = new FileInputStream(saveFile);
                ObjectInputStream in = new ObjectInputStream(FileSaved);
                DotComData = (ArrayList<DotCom>)in.readObject();
                if (!DotComData.isEmpty()) {
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


}
