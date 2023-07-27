package jpabook.jpashop.repository.query.OrderSimpleRepository;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderSimpleQueryDto2 {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate; //주문시간 private OrderStatus orderStatus;
    private OrderStatus orderStatus;
    private Address address;
    public OrderSimpleQueryDto2(Long orderId, String name, LocalDateTime
            orderDate, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
    }
}
