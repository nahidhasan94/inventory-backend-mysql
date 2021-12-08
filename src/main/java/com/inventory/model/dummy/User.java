package com.inventory.model.dummy;

import com.inventory.enums.Authority;
import java.util.List;


public class User {

    private static final long serialVersionUID = 7954325925563724664L;

    private String username;
    private List<Authority> authorities;


    public void setAuthorities(final List<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean hasAuthority(Authority authority) {
        return authorities.contains(authority);
    }
}