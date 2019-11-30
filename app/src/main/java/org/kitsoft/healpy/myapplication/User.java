package org.kitsoft.healpy.myapplication;

public class User {
    String email;
    String name;
    String password;
    String gender;
    String birth;

    public User(String email, String name, String password, String gender, String birth) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birth = birth;
    }

    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getGender() { return gender; }
    public String getBirth() { return birth; }
}
