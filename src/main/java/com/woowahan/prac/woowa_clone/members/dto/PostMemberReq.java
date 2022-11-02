package com.woowahan.prac.woowa_clone.members.dto;

import com.woowahan.prac.woowa_clone.members.RoleType;
import lombok.Getter;

@Getter
public class PostMemberReq {
    private String name;
    private String email;
    private String password;
    private RoleType role;
}
