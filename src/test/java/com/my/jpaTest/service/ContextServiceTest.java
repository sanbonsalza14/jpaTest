package com.my.jpaTest.service;

import com.my.jpaTest.entity.Member;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional; // 스프링 Tx

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ContextServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    ContextService contextService;

    @Test
    @DisplayName("1차 캐시 테스트")
    @Transactional
    void firstCash() {
        Member m = contextService.memberInsert(); // "jang" 저장 + 조회
        // 같은 트랜잭션 내에서 재조회 -> 1차 캐시 동일성 확인
        Member again = em.find(Member.class, "jang");
        assertNotNull(again);
        assertSame(m, again); // 동일 인스턴스 (1차 캐시)
        System.out.println("=======" + m);
    }

    @Test
    @DisplayName("데이터 영속성 보장 테스트")
    @Transactional
    void 데이터_영속성_보장_테스트() {
        // (A) 값 객체 equals 검증 (롬복 @Data/@EqualsAndHashCode 가정)
        Member a_1 = Member.builder().memberId("hong").name("홍길동").build();
        Member b_1 = Member.builder().memberId("hong").name("홍길동").build();
        System.out.println("위 : " + a_1.equals(b_1)); // true 기대 (값 동등성)

        // (B) 영속성 컨텍스트 동일성 검증: 먼저 "jang" 저장 보장
        contextService.memberInsert(); // persist("jang")

        Member a = em.find(Member.class, "jang");
        Member b = em.find(Member.class, "jang");

        assertNotNull(a);
        assertNotNull(b);
        // 동일 엔티티 인스턴스여야 함 (1차 캐시)
        assertSame(a, b);
        System.out.println("아래 동일성 : " + (a == b));
    }


}
