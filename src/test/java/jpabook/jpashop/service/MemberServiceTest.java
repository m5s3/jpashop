package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @DisplayName("회원가입")
    @Test
    void join() throws Exception {
        // Given
        Member member = new Member();
        member.setName("park");

        // When
        Long savedId = memberService.join(member);

        // Then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @DisplayName("중복 회원 예외")
    @Test
    void validateDuplicateName() throws Exception {
        // Given
        Member member1 = new Member();
        member1.setName("park");

        Member member2 = new Member();
        member2.setName("park");

        // When
        memberService.join(member1);
        try {
            memberService.join(member2);
        } catch(IllegalStateException e) {
            return;
        }

        // Then
        fail("예외가 발생해야 한다.");

    }
}