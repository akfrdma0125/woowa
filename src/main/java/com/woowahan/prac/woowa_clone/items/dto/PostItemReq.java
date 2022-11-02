package com.woowahan.prac.woowa_clone.items.dto;

import com.woowahan.prac.woowa_clone.items.CategoryType;
import lombok.Getter;

@Getter
public class PostItemReq {
    private String name;
    private CategoryType category;
    private int price;
    private int stockQuantity;
}
