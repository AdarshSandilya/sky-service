package com.sky.skyservice.services;

import com.sky.skyservice.models.VendorProfile;
import com.sky.skyservice.repositories.VendorProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorProfileService {
    
    private final VendorProfileRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(VendorProfileService.class);
    
    public VendorProfileService(VendorProfileRepository repository) {
        this.repository = repository;
    }
    
    public  VendorProfile create(VendorProfile profile) {
        logger.info("Attempting to create a profile");

        VendorProfile insertedProfile = repository.insert(profile);

        logger.info("Created profile with ID [{}]", insertedProfile.getId());
        return insertedProfile;
    }

    public Optional<VendorProfile> findById(String profileId) {
        return repository.findById(profileId);
    }
}
