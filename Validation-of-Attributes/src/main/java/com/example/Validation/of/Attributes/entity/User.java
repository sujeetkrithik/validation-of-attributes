package com.example.Validation.of.Attributes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    @NotBlank(message = "Name is mandatory")
    @Size(min=2, max=15, message = "name should have at least 2 characters and maximum 15 characters")
//    @Pattern(regexp = "^[a-zA-Z]{2,15}$", message  = "name should have at least 2 characters, only characters and space between word")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message  = "name should have only characters and space between word")
    private String name;
//    @Pattern(regexp = "^[A-Za-z\\s]+$")

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;


    @NotBlank(message = "Password is required")
//    @Size(min = 8, max=30, message = "password should have at least 8 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",
            message = "password should have at least 8 characters")
    private String password;

    @NotBlank(message = "Address is required")
    @Size(min=3, max=100, message = "address should have at least 3 characters")
    private String address;
    @NotBlank(message = "Mobile Number is required")
//    @Size(min=10, max=12, message="mobile number should have at least 10 and maximum 12 characters")
//    @Pattern(regexp = "^(0|91)|(0|91?)[6-9]{1}[0-9]{9}$")
    @Pattern(regexp = "[6-9]{1}[0-9]{9}| (0|91)?[6-9]{1}[0-9]{9}",
            message="mobile number should have 10 characters")
    private String mobileNumber;
    //((0091)|(\+91)|0?)
    //   @Pattern(regexp = "^(0|91)?[6-9]{1}[0-9]{9}$")
    @Size(min=2, message="nominee name should have at least 2 characters")
    private String nomineeName;
    @Size(min=2, message="relation with nominee name should have at least 2 characters")
    private String relationWithNominee;
    public User() {
    }

    public User(Long id,Long customerId,String name, String email,  String password, String address, String mobileNumber,
                String nomineeName, String relationWithNominee) {
        this.id=id;
        this.customerId=customerId;
        this.name = name;
        this.email = email;
        this.password=password;
        this.address=address;
        this.mobileNumber=mobileNumber;
        this.nomineeName=nomineeName;
        this.relationWithNominee=relationWithNominee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getRelationWithNominee() {
        return relationWithNominee;
    }

    public void setRelationWithNominee(String relationWithNominee) {
        this.relationWithNominee = relationWithNominee;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", nomineeName='" + nomineeName + '\'' +
                ", relationWithNominee='" + relationWithNominee + '\'' +
                '}';
    }

}
