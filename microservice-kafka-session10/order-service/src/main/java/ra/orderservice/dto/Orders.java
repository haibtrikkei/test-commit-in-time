package ra.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Orders {
    private Long orderId;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDate orderDate;
    private String userId;
    private String fullName;
    private String address;
    private String email;
}
