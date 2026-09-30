package ra.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetail {
    private Long orderDetailId;
    private Long orderId;
    private String proId;
    private Integer quantity;
    private Double price;
}
