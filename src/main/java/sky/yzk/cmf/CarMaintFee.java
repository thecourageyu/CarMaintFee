package sky.yzk.cmf;

import example.PassArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class CarMaintFee {


    public static double spendPerKm(int parkingFee, int taxFee, int kmPerYear) {

        int maintenanceFeePer5000km = 6000;
        int oil95PerL = 28;
        int runKmPerL = 10;

        int maintenanceFee;
        double oilFee, totalSpendPerYear, spendPerKm;
        maintenanceFee = maintenanceFeePer5000km * kmPerYear / 5000;
        oilFee = kmPerYear / runKmPerL * oil95PerL;
        totalSpendPerYear = parkingFee + taxFee + maintenanceFee + oilFee;

        spendPerKm = totalSpendPerYear / kmPerYear;
        return spendPerKm;
    }

    public static void main(String[] args){


        int i;

        int parkingFee = 12 * 3800;
        int taxFee = 4800 + 7120;
        int kmPerYear = 5000;
        int[] kms = new int[]{5000, 10000, 15000, 30000};

        Logger log = LoggerFactory.getLogger("Log");

        PassArgs pa;

        ArrayList<Integer> fq;

        pa = new PassArgs();
        pa.passIntFromJava(kms);

        fq = new ArrayList<>();
        System.out.println(fq.isEmpty());
        System.out.println(fq.contains(-999));
        System.out.println(fq.toString());
        System.out.println("check fq " + fq.toString());
        for (i=0; i<kms.length; i++) {
            fq.add(kms[i]);
            System.out.println(fq.toString());
        }


        System.out.printf("no parking fee = %f\n", spendPerKm(0, taxFee, kmPerYear));

        for (i=0; i<kms.length; i++) {
            System.out.printf("km = %d, spendPerYear = %f\n", kms[i], spendPerKm(parkingFee, taxFee, kms[i]));
        }



        int[] fff;

        fff = new int[10];
        System.out.println("Hello World");




        for (i=0; i < 10; i++) {
            fff[i] = i * 5;
        }

    }



// no parking fee, km =   5000, spendPerKm = 6.384000
// no parking fee, km =  10000, spendPerKm = 5.192000
// no parking fee, km =  15000, spendPerKm = 4.794667
// no parking fee, km =  30000, spendPerKm = 4.397333

// km =   5000, spendPerKm = 15.504000
// km =  10000, spendPerKm = 9.752000
// km =  15000, spendPerKm = 7.834667
// km =  30000, spendPerKm = 5.917333

}
