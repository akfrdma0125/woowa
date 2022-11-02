package com.woowahan.prac.woowa_clone.members.dto;

import com.woowahan.prac.woowa_clone.members.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // dto객체를 json으로 serialize 할 때 getter 필요
@AllArgsConstructor
public class GetMemberRes {
    private Long id;
    private String email;
    private String name;
    private RoleType role;
}
