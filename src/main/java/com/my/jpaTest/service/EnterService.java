package com.my.jpaTest.service;

import com.my.jpaTest.entity.Entertainment;
import com.my.jpaTest.entity.GirlGroup;
import com.my.jpaTest.entity.IdolMember;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EnterService {
    @Autowired
    EntityManager em;

    public void initData() {
        //enter생성
        Entertainment startship = Entertainment.builder()
                .enterId("starShip")
                .enterName("스타쉽")
                .build();
        Entertainment YG = Entertainment.builder()
                .enterId("YG")
                .enterName("와이지")
                .build();
        GirlGroup ive = GirlGroup.builder()
                .groupId("ive")
                .groupName("아이브")
                .entertainment(startship)
                .build();
        GirlGroup black = GirlGroup.builder()
                .groupId("blackPink")
                .groupName("블랙핑크")
                .entertainment(YG)
                .build();
        //ㅎ개ㅕㅔtodtjd
        IdolMember ahn = IdolMember.builder()
                .id("안유진")
                .name("유진")
                .girlGroup(ive)
                .build();
        IdolMember jang = IdolMember.builder()
                .id("장원영")
                .name("원영")
                .girlGroup(ive)
                .build();
        IdolMember jeni= IdolMember.builder()
                .id("제니")
                .name("쩨니")
                .girlGroup(black)
                .build();
        IdolMember jisu= IdolMember.builder()
                .id("지수")
                .name("찌")
                .girlGroup(black)
                .build();
        //idol생성

        //enter에 group list 등록
        startship.getGroups().add(ive);
       YG.getGroups().add(black);
        //group에 idol list 등록
        ive.getMembers().add(ahn);
        ive.getMembers().add(jang);
        black.getMembers().add(jeni);
        black.getMembers().add(jisu);



        //starship 저장

        //yg
    }
}
