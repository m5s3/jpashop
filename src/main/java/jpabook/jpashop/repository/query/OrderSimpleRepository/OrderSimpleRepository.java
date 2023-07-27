package jpabook.jpashop.repository.query.OrderSimpleRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleRepository {
    private final EntityManager em;

    public List<OrderSimpleQueryDto2> findOrderDto() {
//        return em.createQuery("SELECT jpabook.jpashop.repository.query.OrderSimpleRepository.OrderSimpleQueryDto.of(o.id, m.name, o.orderDate, o.status, d.address)" +
//                " FROM Order o" +
//                " JOIN o.member m" +
//                " JOIN o.delivery d", OrderSimpleQueryDto.class)
//                .getResultList();
        return em.createQuery("SELECT new jpabook.jpashop.repository.query.OrderSimpleRepository.OrderSimpleQueryDto2(o.id, m.name, o.orderDate, o.status, d.address)" +
                        " FROM Order o" +
                        " JOIN o.member m" +
                        " JOIN o.delivery d", OrderSimpleQueryDto2.class)
                .getResultList();
    }
}
