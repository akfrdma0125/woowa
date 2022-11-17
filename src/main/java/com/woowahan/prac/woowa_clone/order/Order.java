package com.woowahan.prac.woowa_clone.order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Order {
    private Long id;
    private Long memberid;
    private Long menuid;
    private String State;
    private LocalDateTime created_at;
    private LocalDateTime delivered_at;
}
