package com.woowahan.prac.woowa_clone.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class PostOrderByCustomerRes {
    private Long id;
    private Long memberid;
    private Long menuid;
    private String State;
    private LocalDateTime created_at;
}
