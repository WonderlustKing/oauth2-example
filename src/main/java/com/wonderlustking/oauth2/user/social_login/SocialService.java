package com.wonderlustking.oauth2.user.social_login;


import com.wonderlustking.oauth2.user.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.HttpRequestMethodNotSupportedException;

public interface SocialService {
    ResponseEntity<OAuth2AccessToken> loginSocialUser(String token) throws HttpRequestMethodNotSupportedException;
}
