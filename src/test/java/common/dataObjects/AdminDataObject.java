package common.dataObjects;

import common.Utils;

public class AdminDataObject {

    public String UserName = "";
    public String DisplayName = "";
    public String Email = "";
    public String Password = "";
    public String ConfirmPassword = "";
    public String Role = "";

    public AdminDataObject(String UserName, String DisplayName, String Email, String Password, String ConfirmPassword, String Role){
        this.UserName = UserName;
        this.DisplayName = DisplayName;
        this.Email = Email;
        this.Password = Password;
        this.ConfirmPassword = this.Password;
        this.Role = Role;
    }

    public AdminDataObject(){
        this(getRandomUserName(), getRandomDisplayName(), getRandomEmail(), getRandomPassword(), getRandomPassword(), getAdminRole());
    }

    public static String getRandomUserName(){
        return "Auto" + Utils.getRandomInteger(10000);
    }

    public static String getRandomDisplayName(){
        return "AutoAdmin" + Utils.getRandomInteger(100);
    }

    public static String getRandomEmail(){
        return "test.tester+" + Utils.getRandomInteger(300) + "@gmail.com";
    }

    public static String getRandomPassword(){
        return "Admin" + Utils.getRandomInteger(3);
    }

    public static String getAdminRole(){
        return "admin";
    }
}
