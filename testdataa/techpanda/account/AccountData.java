package src2.testdataa.techpanda.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import src2.cores.commons.GlobalConstants;

import java.io.File;

public class AccountData {

    public static AccountData getAccountData(){
        System.out.println(GlobalConstants.DATA_TEST_PATH);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH), AccountData.class);


        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public String getEmailAddress() {
        return login.emailAddress;
    }

    public String getWebEmailServer() {
        return login.webEmailServer;
    }

    public String getPassword() {
        return login.password;
    }

    public String getFirstName() {
        return login.firstName;
    }

    public String getLastName() {
        return login.lastName;
    }



    public String getAddress() {
        return address;
    }


    public String getCity() {
        return city;
    }


    static class Login{
        @JsonProperty("emailAddress")
        private String emailAddress;

        @JsonProperty("webEmail")
        private String webEmailServer;


        @JsonProperty("password")
        private String password;


        @JsonProperty("firstName")
        private String firstName;

        @JsonProperty("lastName")
        private String lastName;
    }

    @JsonProperty("Login")
    private Login login;


    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;
}
