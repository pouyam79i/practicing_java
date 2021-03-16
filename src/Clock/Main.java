package Clock;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClockDisplay clock = new ClockDisplay(12, 59, 50);
        System.out.println(clock.getTime());
        while(true){

            Thread.sleep(1000);
            clock.timeTick();
            System.out.println(clock.getTime());
        }
    }
}

