package com.wonderlustking.oauth2.user.social_login;


import com.wonderlustking.oauth2.user.User;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;

public interface SocialService {
    HttpHeaders loginSocialUser(String token);
}
