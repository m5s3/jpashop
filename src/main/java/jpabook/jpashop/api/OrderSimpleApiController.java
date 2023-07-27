package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.dto.OrderSearch;
import jpabook.jpashop.dto.SimpleOrderDto;
import jpabook.jpashop.repository.query.OrderSimpleRepository.OrderSimpleQueryDto;
import jpabook.jpashop.repository.query.OrderSimpleRepository.OrderSimpleQueryDto2;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderSimpleApiController {
    private final OrderService orderService;

    @GetMapping("/v2/simple-orders")
    public List<SimpleOrderDto> ordersV2() {
        List<Order> orders = orderService.findOrders(new OrderSearch());
        return orders.stream().map(SimpleOrderDto::of).collect(toList());
    }

    @GetMapping("/v3/simple-orders")
    public List<SimpleOrderDto> orderV3() {
        List<Order> orders = orderService.findAllWithMemberDelivery();
        return orders.stream().map(SimpleOrderDto::of).collect(toList());
    }

    @GetMapping("/v4/simple-orders")
    public List<OrderSimpleQueryDto2> orderV4() {
        return orderService.findOrderDtos();
    }
}
