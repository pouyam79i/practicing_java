import java.util.ArrayList;
import java.util.Iterator;

public class Run{
    public static void main(String[] args) {
        ArrayList<String> myArrList = new ArrayList<String>();
        myArrList.add("Pouya is Good");
        myArrList.add("Yes");
        myArrList.add(1, "New Index");
        for (String s : myArrList) {
            System.out.println(s);
        }
    }
}