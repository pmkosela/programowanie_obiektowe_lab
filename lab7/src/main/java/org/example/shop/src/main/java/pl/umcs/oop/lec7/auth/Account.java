package org.example.shop.src.main.java.pl.umcs.oop.lec7.auth;

import at.favre.lib.crypto.bcrypt.BCrypt;

class Account {
    private String name;
    private String password;

    public Account(String name, String password) {
        this.name = name;
        this.password =
                BCrypt.withDefaults().hashToString(12, password.toCharArray());
        System.out.println(this.password);
    }

    public boolean authenticate(String name, String password) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), this.password);
        return result.verified;
    }
}
