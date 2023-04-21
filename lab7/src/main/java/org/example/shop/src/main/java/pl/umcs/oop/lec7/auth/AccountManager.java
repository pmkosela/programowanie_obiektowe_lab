package org.example.shop.src.main.java.pl.umcs.oop.lec7.auth;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    Map<String, Account> accounts = new HashMap<>();

    public boolean register(String name, String password) {
        if(accounts.containsKey(name))
            return false;
        else {
            accounts.put(name, new Account(name, password));
            return true;
        }
    }

    public boolean login(String name, String password) {
        if(!accounts.containsKey(name))
            return false;
        else
            return accounts.get(name).authenticate(name, password);
    }
}
