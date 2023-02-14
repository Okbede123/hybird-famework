package JavaTest.DemoJson;

import src2.testdataa.techpanda.account.AccountData;

public class TestReadFileJson {

    public static void main(String[] args) {
        AccountData accountData = AccountData.getAccountData();
        System.out.println(accountData.getEmailAddress());
    }
}
