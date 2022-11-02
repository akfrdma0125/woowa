package com.woowahan.prac.woowa_clone.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
    private Long id;
    private Long storeid;
    private String menuname;
    private int soldout;
}
