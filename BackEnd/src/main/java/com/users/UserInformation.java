package com.users;


import javax.persistence.*;

@Entity
@Table
public class UserInformation{

    @Id
    @SequenceGenerator(name = "userInformation_sequence",
            sequenceName = "userInformation_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userInformation_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;

    public UserInformation(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserInformation(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserInformation() {

    }

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
}
