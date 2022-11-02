package com.woowahan.prac.woowa_clone.members.dto;

import com.woowahan.prac.woowa_clone.members.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostMemberRes {
    private Long id;
    private String name;
    private String email;
    private RoleType role;
}
