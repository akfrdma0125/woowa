package com.woowahan.prac.woowa_clone.members;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private RoleType role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
