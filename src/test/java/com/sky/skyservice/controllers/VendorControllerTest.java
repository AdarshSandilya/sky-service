package com.sky.skyservice.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sky.skyservice.models.VendorProfile;
import com.sky.skyservice.services.VendorProfileService;
import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;


@AutoConfigureMockMvc
@ExtendWith({MockitoExtension.class, RandomBeansExtension.class})
class VendorControllerTest {
    @Autowired
    private MockMvc mvc;
    @Mock
    private VendorProfileService profileService;
    @InjectMocks
    private VendorController controller;

    
    @Test
    void shouldGetProfile(@Random String profileId, @Random VendorProfile persistedProfile) {
        when(profileService.findById(profileId)).thenReturn(Optional.of(persistedProfile));

        ResponseEntity<VendorProfile> response = this.controller.getProfile(profileId);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(persistedProfile));
    }
    
    @Test
    void should_create_a_vendor_profile(@Random VendorProfile profile, @Random VendorProfile createdProfile) {
        when(profileService.create(profile)).thenReturn(createdProfile);

        ResponseEntity<VendorProfile> responseEntity = controller.create(profile);
        assertThat(createdProfile, equalTo(responseEntity.getBody()));
    }
}