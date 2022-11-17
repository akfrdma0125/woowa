package com.woowahan.prac.woowa_clone.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostOrderByCustomerReq {
    private Long memberid;
    private Long menuid;
}
