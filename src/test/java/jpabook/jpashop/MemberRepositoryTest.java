package jpabook.jpashop;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    void testMember() throws Exception {
        // Given
        Member member = new Member();
        member.setUsername("memberA");

        // When
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        // Then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        // 1차 캐시로
        // 영속성 컨텍스트에서 관리되고 있는 대상이 있기 때문에 1차 캐시에서 가져옴(Query 도 날리지않음)
        assertThat(findMember).isEqualTo(member);
    }
}