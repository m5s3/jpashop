package jpabook.jpashop.dto;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;

import java.time.LocalDateTime;

public record SimpleOrderDto(
        Long orderId,
        String name,
        LocalDateTime orderDate,
        OrderStatus orderStatus,
        Address address
) {
    static public SimpleOrderDto of(Order order) {
        return new SimpleOrderDto(
                order.getId(),
                order.getMember().getName(),
                order.getOrderDate(),
                order.getStatus(),
                order.getDelivery().getAddress()
        );
    }
}
