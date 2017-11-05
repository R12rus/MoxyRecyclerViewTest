package r12.moxybug.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by R12 on 05.11.2017.
 */

public class GitHubUser {

    @SerializedName("login")
    @Expose
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}