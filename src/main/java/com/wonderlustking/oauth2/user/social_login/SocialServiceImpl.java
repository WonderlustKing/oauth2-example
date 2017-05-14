package com.wonderlustking.oauth2.user.social_login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;


import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;


@Service
public class SocialServiceImpl implements SocialService {

    @Autowired
    TokenEndpoint tokenEndpoint;

    @Override
    public ResponseEntity<OAuth2AccessToken> loginSocialUser(String token) throws HttpRequestMethodNotSupportedException {
        Facebook facebook = new FacebookTemplate("EAAGNgVRrE0QBAK8V7eW77iD5z6K2MO2KAUmoICNfTAUc1A3xHgQLL2z1mL9NbgZAud9VFZAJfjN8YZCWras2mpOTYQpAaTBZChofoZB3sugCY3rJViFrPG6N0nd2ZCYnphBQMFQdoAdzdAp5I4xV2FisORL6PyZCrlSHs1uZCgzWtQun52xmXQqCN27mYCsIFkFExCM4cPA37Xp68VK6JNPIzahpCOigYG8ZD");
        String [] fields = { "name","email, birthday" };
        User userProfile = facebook.fetchObject("me", User.class, fields);
        String email =  userProfile.getEmail();
        String name = userProfile.getName();

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        "clientId", "secret",
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_TRUSTED_CLIENT"))));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return getToken(authentication, name);

    }

    public ResponseEntity<OAuth2AccessToken> getToken(Principal principal, String name) throws HttpRequestMethodNotSupportedException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "password");
        parameters.put("password", "password");
        parameters.put("scope", "read write");
        parameters.put("username", name);

        return tokenEndpoint.postAccessToken(principal, parameters);
    }
}
