package ra.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.orderservice.dto.Orders;
import ra.orderservice.services.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public String createOrder(@RequestBody Orders order) {
        orderService.createOrder(order);
        return "Đã tạo đơn hàng!";
    }
}
