package org.cap.apps.freelancerapp.adminms.dto;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import javax.validation.constraints.NotBlank;

public class UpdateAdminDetails {
    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



