package com.inventory.enums;

public enum Authority {
    ROLE_ADMIN,
    ROLE_EMPLOYEE,
    ANONYMOUS;

    public String getAuthority(){return this.name();}

}
