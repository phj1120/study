package me.silvernine.tutorial.entity;

public enum AuthorityType {
    ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

    String name;

    AuthorityType(String name) {
        this.name = name;
    }
}
