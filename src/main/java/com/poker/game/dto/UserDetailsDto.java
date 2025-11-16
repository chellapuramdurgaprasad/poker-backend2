/*
package com.poker.game.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
//@Setter
//@Getter
public class UserDetailsDto {

    @NotBlank(message = "First name is mandatory.")
    private String firstName;

    @NotBlank(message = "Last name is mandatory.")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date of Birth is required.")
    private LocalDate dateOfBirth;

    @NotNull(message = "Mobile is mandatory.")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number is must be 10 digits and start with 6 and 9.")
    @JsonProperty("mobile")
    private String mobile;

    @NotBlank(message = "Password is mandatory.")
    @Size(min = 6, message = "password must be at least 6 characters long." )
    private String password;

    // ✅ Getters and Setters (needed for Jackson)
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
*/

package com.poker.game.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class UserDetailsDto {

    @NotBlank(message = "First name is mandatory.")
    private String firstName;

    @NotBlank(message = "Last name is mandatory.")
    private String lastName;

    @NotNull(message = "Date of Birth is required.")
    private LocalDate dateOfBirth;

 //   @JsonProperty("mobile") // explicitly maps JSON key -> field
    @NotNull(message = "Mobile is mandatory.")
    @JsonProperty("mobile")
  //  @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be 10 digits and start with 6 and 9.")
    private String mobile;

    @NotBlank(message = "Password is mandatory.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;

    // ✅ Default constructor (needed for Jackson)
    public UserDetailsDto() {}

    // ✅ Getters and Setters (needed for Jackson)
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

