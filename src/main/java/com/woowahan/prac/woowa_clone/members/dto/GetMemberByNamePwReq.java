package com.woowahan.prac.woowa_clone.members.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetMemberByNamePwReq {
    private String name;
    private String password;
}
