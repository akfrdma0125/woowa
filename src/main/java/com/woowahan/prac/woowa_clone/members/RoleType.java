package com.woowahan.prac.woowa_clone.members;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RoleType {
    USER, ADMIN, STORE;

    public static RoleType toRoleType(String role) {
        return RoleType.valueOf(role);
    }
}
