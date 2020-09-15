package com.sky.skyservice.repositories;

import com.sky.skyservice.models.VendorProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorProfileRepository extends MongoRepository <VendorProfile, String> {
}
