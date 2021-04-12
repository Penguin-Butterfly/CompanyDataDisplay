package sample;


class BusinessData {
    public static void main(String[] args) {
        // write your code here
            String DotComData = args[0];
            String CompanyData = args[1];
            sample.DotCom.read(DotComData);

        Business.describeAll();
    }
}
