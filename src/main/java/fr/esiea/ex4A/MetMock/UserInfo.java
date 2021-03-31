package fr.esiea.ex4A.MetMock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {

    private final String userEmail;
    private final String userName;
    private final String userTweeter;
    private final String userCountry;
    private final String userSex;
    private final String userSexPref;

    public UserInfo(@JsonProperty("userEmail") String userEmail, @JsonProperty("userName") String userName, @JsonProperty("userTweeter") String userTweeter, @JsonProperty("userCountry") String userCountry, @JsonProperty("userSex") String userSex, @JsonProperty("userSexPref") String userSexPref) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserTweeter() {
        return userTweeter;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserSexPref() {
        return userSexPref;
    }
}
