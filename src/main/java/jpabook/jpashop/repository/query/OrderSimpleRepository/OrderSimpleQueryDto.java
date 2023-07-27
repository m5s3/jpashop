package jpabook.jpashop.repository.query.OrderSimpleRepository;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.OrderStatus;

import java.time.LocalDateTime;

public record OrderSimpleQueryDto(
        Long orderId,
        String name,
        LocalDateTime orderDate,
        OrderStatus orderStatus,
        Address address
) {

    public static OrderSimpleQueryDto of(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        return new OrderSimpleQueryDto(orderId, name, orderDate, orderStatus, address);
    }
}
