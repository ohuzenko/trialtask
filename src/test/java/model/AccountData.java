package model;

import static java.lang.System.currentTimeMillis;

/**
 * Created by sunny_IT on 1/26/2017.
 */
public class AccountData {
    private String userName;
    private String emailAddress;
    private String password;

    private String solt = Long.toString(currentTimeMillis());

    public String getUserName() {
        return userName;
    }

    public AccountData withUserName(String userName) {

        this.userName = userName != null? userName + solt:userName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public AccountData withEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress != null? userName + emailAddress : emailAddress;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AccountData withPassword(String password) {

        this.password = password != null? password + solt:password;
        return this;
    }



}
