package com.ashutosh.referralapi.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;


public class ProfileDto {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Name is required")
    private String name;

    private boolean profileCompleted = true;  // default to true

    public ProfileDto() {
    }

    public ProfileDto(Long userId, String name, boolean profileCompleted) {
        this.userId = userId;
        this.name = name;
        this.profileCompleted = profileCompleted;
    }

    public @NotNull(message = "User ID is required") Long getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "User ID is required") Long userId) {
        this.userId = userId;
    }

    public @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public boolean isProfileCompleted() {
        return profileCompleted;
    }

    public void setProfileCompleted(boolean profileCompleted) {
        this.profileCompleted = profileCompleted;
    }
}
