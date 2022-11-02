package com.woowahan.prac.woowa_clone.members.dto;

import com.woowahan.prac.woowa_clone.members.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatchMemberByPwReq {
    private String name;
    private String email;
    private String password;
    private String newPassword;
}
