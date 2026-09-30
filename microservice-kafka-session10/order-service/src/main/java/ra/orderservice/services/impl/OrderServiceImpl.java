package ra.orderservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ra.orderservice.dto.OrderDetail;
import ra.orderservice.dto.OrderEvent;
import ra.orderservice.dto.Orders;
import ra.orderservice.services.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @Override
    public Orders createOrder(Orders order){
        System.out.println("Xử lý đơn hàng");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Đơn hàng đã được tạo...");

        //Xử lý đơn hàng xong thì phát sinh ra sự kiện để inventory-service và payment-service chạy
        List<OrderDetail> orderDetails = List.of(
                OrderDetail.builder()
                        .orderId(order.getOrderId())
                        .proId("p01")
                        .quantity(10)
                        .price(50000D)
                        .build(),
                OrderDetail.builder()
                        .orderId(order.getOrderId())
                        .proId("p02")
                        .quantity(5)
                        .price(120000D)
                        .build(),
                OrderDetail.builder()
                        .orderId(order.getOrderId())
                        .proId("p03")
                        .quantity(15)
                        .price(30000D)
                        .build()

        );

        OrderEvent orderEvent = OrderEvent.builder()
                .order(order)
                .orderDetails(orderDetails)
                .build();

        //Thực hiện gửi
        kafkaTemplate.send("order-topic", order.getOrderId().toString(), orderEvent);

        return order;
    }
}
