package com.my.jpaTest.service;

import com.my.jpaTest.entity.GirlGroup;
import com.my.jpaTest.entity.IdolMember;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class EnterServiceTest {
    @Autowired
    EnterService enterService;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("데이터 입력 테스트")
    Void dataInputTest() {
        enterService.initData();
    }

    @Test
    @DisplayName("문제 1")
    void 문제1() {
        IdolMember jisu = em.find(IdolMember.class, "지수");
        String.groupName = jisu.getGirlGroup().getGroupName();
        String.enterName = jisu.getGirlGroup().getEntertainment().getEnterName();
    }

    @Test
    @DisplayName("문제 2")
    void 문제2() {
        GirlGroup group = em.find(GirlGroup.class, "blackPink");
        group.getMembers().forEach(
                IdolMember x -> System.out.println(x.getName())
        );

    }
}