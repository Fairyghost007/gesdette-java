package org.example.data.enums;

public enum Role {
    ADMIN(1),
    BOUTIQUIER(2),
    CLIENT(3);

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static Role getValue(String value) {
        for (Role r : Role.values()) {
            if (r.name().compareToIgnoreCase(value) == 0) {
                return r;
            }
        }
        return null;
    }

    public static Role getValue2(int roleId) {
        for (Role role : Role.values()) {
            if (role.getId() == roleId) {
                return role;
            }
        }
        return null; // Return null if no matching role is found
    }
    
    
}
