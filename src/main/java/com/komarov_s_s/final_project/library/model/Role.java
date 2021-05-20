package com.komarov_s_s.final_project.library.model;

public enum Role {
    UNREGISTERED(1),
    USER(2),
    LIBRARIAN(3),
    ADMIN(4);

    private int accessLevel;

    Role(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
}
