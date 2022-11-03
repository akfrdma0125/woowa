package com.woowahan.prac.woowa_clone.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostMenuReq {
    private Long storeid;
    private String menuname;
    private int soldout;
}
