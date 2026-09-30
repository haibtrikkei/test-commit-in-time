package ra.inventoryservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ra.inventoryservice.dto.OrderDetail;
import ra.inventoryservice.dto.OrderEvent;

@Service
public class InventoryService {
    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void createInventoryService(OrderEvent orderEvent) {
        System.out.println("Nhận được sự kiện đặt hàng từ order-service: ");
        System.out.println("Thông tin đặt hàng: ");
        System.out.println("\tMã đơn hàng: "+orderEvent.getOrder().getOrderId());
        System.out.println("\tKhách hàng: "+orderEvent.getOrder().getFullName());
        System.out.println("\tSản phẩm: ");
        for(OrderDetail orderDetail : orderEvent.getOrderDetails()) {
            System.out.println("\t\tMã sản phẩm: "+orderDetail.getProId());
            System.out.println("\t\tSố lượng: "+orderDetail.getQuantity());
            System.out.println("\t\tGiá tiền: "+orderDetail.getPrice());
        }
    }
}
