package com.example.stropee2017.lokacar.beans;

public class Login {
    private int id_login;
    private String username;
    private String password;

    public Login(){
        super();
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login(int id_login, String username, String password) {
        this.id_login = id_login;
        this.username = username;
        this.password = password;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
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
}
