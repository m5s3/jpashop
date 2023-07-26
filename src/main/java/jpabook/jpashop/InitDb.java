package jpabook.jpashop;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        public void dbInit1() {
            Member member = createMember("userA", "서울", "1", "1111");
            em.persist(member);

            Book book1 = Book.of("JPA1 BOOK", 10000, 100);
            em.persist(book1);

            Book book2 = Book.of("JPA2 BOOK", 20000, 200);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.of(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.of(book2, 20000, 2);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order = Order.of(member, delivery, List.of(orderItem1, orderItem2));
            em.persist(order);
        }

        public void dbInit2() {
            Member member = createMember("userB", "대구", "2", "2222");
            em.persist(member);

            Book book1 = Book.of("BOOK", 20000, 100);
            em.persist(book1);

            Book book2 = Book.of("BOOK", 40000, 200);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.of(book1, 10000, 2);
            OrderItem orderItem2 = OrderItem.of(book2, 20000, 4);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order = Order.of(member, delivery, List.of(orderItem1, orderItem2));
            em.persist(order);
        }
    }

    private static Member createMember(String userName, String city, String street, String zipcode) {
        Member member = new Member();
        member.setName(userName);
        member.setAddress(new Address(city, street, zipcode));
        return member;
    }
}
