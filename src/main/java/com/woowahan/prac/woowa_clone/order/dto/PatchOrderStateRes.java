package com.woowahan.prac.woowa_clone.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PatchOrderStateRes {
    private Long id;
    private Long memberid;
    private Long menuid;
    private String State;
    private LocalDateTime created_at;
    private LocalDateTime delivered_at;
}
