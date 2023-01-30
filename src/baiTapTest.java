public class baiTapTest {
    public static void main(String[] args) {
        System.out.println(createUserName("123","okbede123@das.nett","123456"));
    }


    public static String createUserName(String userName,String emails,String password){
        String[] emaillist = {".com",".net",".vn"};
        if(userName.isEmpty()){
            return "name không được để trống \n Failed";
        } else if (userName.length() > 250) {
            return "name không được quá 250 kí tự \n Failed";
        }
        if(!emails.contains("@")){
            return "email khong dung dinh dang \n Failed";
        }
        if(emails.contains("@")){
            for (String email:emaillist) {
                if(emails.contains(email)){
                    break;
                }
            }
        }
        if(password.length() < 6){
            return "password toi thieu 6 ki tu \n Failed";
        }

       return "Success";
    }

    public void TC_01_EmailEmpty(){

    }
}
