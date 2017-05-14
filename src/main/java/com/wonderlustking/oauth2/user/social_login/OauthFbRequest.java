package com.wonderlustking.oauth2.user.social_login;


public class OauthFbRequest {

    private String user_access_tokken;

    OauthFbRequest(){}

    public String getUser_access_tokken() {
        return user_access_tokken;
    }

    public void setUser_access_tokken(String user_access_tokken) {
        this.user_access_tokken = user_access_tokken;
    }
}
