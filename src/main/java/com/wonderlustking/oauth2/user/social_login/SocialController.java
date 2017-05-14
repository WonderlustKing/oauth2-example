package com.wonderlustking.oauth2.user.social_login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/signin")
public class SocialController {

    @Autowired
    private SocialService socialService;

    @RequestMapping(value = "/facebook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpHeaders loginUserViaSocial(@RequestBody OauthFbRequest oauthFbRequest) {
       return socialService.loginSocialUser(oauthFbRequest.getUser_access_tokken());
    }

}
