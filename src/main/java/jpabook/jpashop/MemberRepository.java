package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        // Command 와 Query 를 분리해라
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
