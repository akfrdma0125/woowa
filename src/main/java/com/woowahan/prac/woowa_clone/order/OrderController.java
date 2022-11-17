package com.woowahan.prac.woowa_clone.order;

import com.woowahan.prac.woowa_clone.members.dto.GetMemberByNameReq;
import com.woowahan.prac.woowa_clone.order.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @PostMapping("/reception")
    public PostOrderByCustomerRes findByName(@RequestBody PostOrderByCustomerReq postOrderByCustomerReq) {
        return orderRepository.createOrder(postOrderByCustomerReq);
    }
    @GetMapping("/info")
    public List<GetOrderByStoreRes> findByStoreId(@RequestBody Long storeid) {
        return orderService.findByStoreId(storeid);
    }
    //메뉴테이블타고가야해서?서비스

    @PutMapping("/state")
    public PatchOrderStateRes state(@RequestBody PatchOrderStateReq patchOrderStateReq) {
        return orderRepository.updateOrderState(patchOrderStateReq);
    }

}
