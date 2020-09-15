package com.sky.skyservice.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Document(collection = "vendorProfiles")
public class VendorProfile {

    @Id
    private final String id;
    
    @CreatedDate
    private final Date createdAt;
    
    @LastModifiedDate
    private final Date updatedAt;
    
    @NotBlank
    private final String displayName;
    
    @NotBlank
    private final String actualFullName;
    
    private final String profilePicturePath;
    private final LocalDate birthday;
    private final UUID genderId;
    private final String aboutMe;
    private final Location location;
    private final String occupation;

    public VendorProfile(String id, Date createdAt, Date updatedAt, String displayName, String actualFullName,
                         String profilePicturePath, LocalDate birthday, UUID genderId, String occupation, String aboutMe, Location location) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.displayName = displayName;
        this.actualFullName = actualFullName;
        this.profilePicturePath = profilePicturePath;
        this.birthday = birthday;
        this.genderId = genderId;
        this.occupation = occupation;
        this.aboutMe = aboutMe;
        this.location = location;
    }

    public String getId() {
        return this.id;
    }


    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
