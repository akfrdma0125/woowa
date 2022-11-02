package com.woowahan.prac.woowa_clone.items;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Item {
    private Long id;
    private String name;
    private CategoryType category;
    private int price;
    private int stockQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
