package com.librarysystem.server.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class RegisterUserDTO implements Serializable
{
    // Register: This web service is invoked for during registration.
    //
    // The user provides the following fields:
    // first name, last name, email, phone (optional), date of birth (optional).
    //
    // Response will return a success status.

    private String firstName;
    private String lastName;
    private String email;
    private String phone; // optional
    private LocalDate dob; // optional

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public LocalDate getDob()
    {
        return dob;
    }

    public void setDob(LocalDate dob)
    {
        this.dob = dob;
    }

    @Override
    public String toString()
    {
        return "RegisterUserDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", dob=" + dob + "]";
    }

}
