package Automation_test;

import java.util.Random;

public class KhoiTaoDriver {

        String khoiTaoChomre = "webdrive.chrome.driver";

        String KhoiTaoFireFox = "webdriver.gecko.driver";
        String getProperty = System.getProperty("user.dir");
        String source = "\\chromedriver.exe";

        String sourcefirefox = "\\geckodriver.exe";


        public long SleepInTime(long num){
            try {
                Thread.sleep(num*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return num;
        }

        public int RandomNum(){
            Random rand = new Random();
            int random = rand.nextInt(1000);
            return random;
        }

    }

