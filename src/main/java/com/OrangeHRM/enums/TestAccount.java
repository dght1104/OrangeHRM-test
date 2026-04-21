package com.icrm.enums;

public enum TestAccount {

    ADMIN_USER("jdoe",
            "123456",
            "jdoe@example.com",
            1),
    STAFF_USER("jsmith",
            "123456",
            "jsmith@example.com",
            0),
    INACTIVE_USER("lmartinez",
            "123456",
            "lmartinez@example.com",
            0),
    INCORRECT_USER("jamsist",
            "123456",
            "jamsist@example",
            0);

    private final String username;
    private final String password;
    private final String email;
    private final int role;

    TestAccount(String username, String password, String email, int role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
