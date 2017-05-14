package com.wonderlustking.oauth2.user.social_login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class SocialServiceImpl implements SocialService {

    @Autowired
    ConnectionRepository connectionRepository;

    @Override
    public HttpHeaders loginSocialUser(String token) {
        Facebook facebook = new FacebookTemplate("EAAGNgVRrE0QBAA82hVCJ3CMukBiDwPH0bvDnfGgXV2lM9jwaL3yEXc5M1htUTdYBLaAnY4RULOU1yf3ftfb1RaK1vZCWbbM1HWX5KcXmcrxdi0LKfJawMpdNymXKYSe7UJtbiS2FMfxx1EnS9dne1MN46D2cukoMGZBB6eDmaZAoiimQUky6wCTblOoWWosWrLknYZCtGZB4DIPznVysvAUwl1ZAcZAzQMZD");
        String [] fields = { "name","email" };
        User userProfile = facebook.fetchObject("me", User.class, fields);
        String email =  userProfile.getEmail();
        String name = userProfile.getName();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(SocialController.class).slash(name).slash(email).toUri());
        return httpHeaders;
    }
}
