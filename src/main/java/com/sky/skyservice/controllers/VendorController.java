package com.sky.skyservice.controllers;

import com.sky.skyservice.models.VendorProfile;
import com.sky.skyservice.services.VendorProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vendor")
public class VendorController {
    private VendorProfileService profileService;

    public VendorController(VendorProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorProfile> getProfile(@PathVariable("id") String profileId) {
        return profileService.findById(profileId)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<VendorProfile> create(@RequestBody  VendorProfile profile) {
        VendorProfile createdProfile = profileService.create(profile);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    

}
