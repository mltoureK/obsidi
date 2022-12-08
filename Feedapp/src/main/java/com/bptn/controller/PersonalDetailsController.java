package com.bptn.controller;

import com.bptn.models.AuthenticationUser;
import com.bptn.models.Profile;
import com.bptn.models.UserID;
import com.bptn.request.AddressRequest;
import com.bptn.service.PersonalDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonalDetailsController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonalDetailsService personalDetailsService;

    @PutMapping("/user/personal/security")
    public ResponseEntity<?> securityUpdate(@RequestBody AuthenticationUser authenticationUser)  {
        LOGGER.debug("securityUpdate request received = {}", authenticationUser);
        authenticationUser = personalDetailsService.securityUpdate(authenticationUser);
        return new ResponseEntity<>(authenticationUser, HttpStatus.OK);
    }


    @PutMapping("/user/personal/profile")
    public ResponseEntity<?> profileUpdate(@RequestBody Profile profile)  {
        LOGGER.debug("profileUpdate request received = {}", profile);
        profile = personalDetailsService.profileUpdate(profile);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
    
    @PutMapping("/user/personal/address")
    public ResponseEntity<?> addressUpdate(@RequestBody AddressRequest addressRequest)  {
        LOGGER.debug("addressUpdate request received = {}", addressRequest);
        UserID userID = personalDetailsService.addressUpdate(addressRequest);
        return new ResponseEntity<>(userID, HttpStatus.OK);
    }
}