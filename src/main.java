// main app

// this class provieds a structure for
// tiket data
class tiket_data{
    public double charge = 0;
    public String tiketType = "No data";
    public String intializedTime = "No data";
}

// thiket machin class
// this contains methods for tiket
class machin_tiket{
    private tiket_data tiketData = new tiket_data();

    public machin_tiket(double firstCharge, String type){
        tiketData.charge = firstCharge;
        tiketData.tiketType = type;
    }

    public void showTiketData(){
        System.out.println("Tiket Charge: " + tiketData.charge);
        System.out.println("Tiket Type: " + tiketData.tiketType);
    }

}

// main class
public class main
{
    public static void main(String args[])
    {
     machin_tiket tiket = new machin_tiket(1200.000, "Pro");
     tiket.showTiketData();
    }
}

