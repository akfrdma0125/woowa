package com.woowahan.prac.woowa_clone.order.dto;

import java.time.LocalDateTime;

public class GetOrderByStoreRes {
    private Long id;
    private Long memberid;
    private Long menuid;
    private String State;
    private LocalDateTime created_at;
    private LocalDateTime delivered_at;
}
