package com.komarov_s_s.final_project.library.model;

public enum Role {
    UNREGISTERED(1),
    USER(2),
    ADMIN(3);

    private int accessLevel;

    Role(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
}
