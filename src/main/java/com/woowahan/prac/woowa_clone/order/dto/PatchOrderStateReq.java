package com.woowahan.prac.woowa_clone.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PatchOrderStateReq {
    private Long id;
    private String State;
}
