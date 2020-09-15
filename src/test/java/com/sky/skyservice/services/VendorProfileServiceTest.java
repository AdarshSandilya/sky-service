package com.sky.skyservice.services;

import com.sky.skyservice.models.VendorProfile;
import com.sky.skyservice.repositories.VendorProfileRepository;
import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith({MockitoExtension.class, RandomBeansExtension.class})
class VendorProfileServiceTest {

    @Mock
    private VendorProfileRepository repository;
    @InjectMocks
    private  VendorProfileService profileService;
    
    @Test
    void should_create_a_vendor_profile(@Random VendorProfile profile, @Mock VendorProfile insertedProfile) {
        when(repository.insert(profile)).thenReturn(insertedProfile);
        VendorProfile vendorProfile = this.profileService.create(profile);

        assertThat(vendorProfile, equalTo(insertedProfile));
    }
}