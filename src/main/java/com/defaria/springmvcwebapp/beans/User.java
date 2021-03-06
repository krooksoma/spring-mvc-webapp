package com.defaria.springmvcwebapp.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class User {

    @Id
    private int Id;
//do not forget to add dependency spring-boot-starter-validation
    @Size(min=6, message = "{username.min.length}")
    private String username;

    @Pattern(regexp= "((?=.*[A-Z]).{6,10})", message = "{user.password.min.length}")
    private String password;

    @NotEmpty(message = "{user.firstname.not.empty}")
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @NotNull(message = "{user.gender.not.empty}")
    private String activity;

//    this annotation will allow for the string value to be saved, not the ordinal value(0, 1, 2, ...)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
