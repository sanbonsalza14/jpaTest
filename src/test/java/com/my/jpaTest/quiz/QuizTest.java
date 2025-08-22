package com.my.jpaTest.quiz;

import com.my.jpaTest.dto.Gender;
import com.my.jpaTest.entity.Users;
import com.my.jpaTest.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class QuizTest {
    @Autowired
    UsersRepository repository;

    @Test
    @Transactional
    @DisplayName("Given/when/Then으로 테스트 하기")
    void assertThatTest() {
        //신규데이터 추가 테스트
        //Given
        Users jin = Users.builder()
                .name("안유진")
                .email("jin@korea.com")
                .gender(Gender.Female)
                .likeColor("Red")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        //When
        repository.save(jin);
        //Then
        // 이름으로 검색한 결과와  jin 이랑 같으면...성공
        Users result = repository.findByName("안유진").get(0);
        //검사
        Assertions.assertThat(result.getEmail()).isEqualTo(jin.getEmail());


    }

    @Test
    @DisplayName("문제 1.")
    void findByGenderAndNameContainsOrGenderAndNameContains() {
        repository.findByGenderAndNameContainingIgnoreCaseOrGenderAndNameContainingIgnoreCase(
                Gender.Female, "w",
                Gender.Female, "m"
        ).forEach(x -> System.out.println(x));
    }

    @Test
    @DisplayName("문제2: email LIKE %net% 전체 출력")
    void findByEmailContains() {
        repository.findByEmailContains("net")
                .forEach(x -> System.out.println(x));
    }

    @Test
    @DisplayName("문제 3. 가장 최근 한달이내에 업데이트된 자료 중 이름 첫자가 \"J\"인 자료를 출력하시오.")
    void findByUpdatedAtGreaterThanEqualAndNameStartingWith() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(3);
        repository.findByUpdatedAtGreaterThanEqualAndNameStartingWith(oneMonthAgo, "J")
                .forEach(x -> System.out.println(x));
    }

    @Test
    @DisplayName("문제 4. 가장 최근 생성된 자료 10건을 ID, 이름, 성별, 생성일 만 출력하시오.")
    void findTop10ByOrderByCreatedAtDesc() {
        repository.findTop10ByOrderByCreatedAtDesc()
                .forEach(x-> System.out.println(
                        "ID:" + x.getId()+
                        ",이름:" + x.getName() +
                        ",성별:" + x.getGender() +
                        ", 생성일 :" + x.getCreatedAt()
                ));
    }

    @Test
    @DisplayName("문제 5. \"Red\"를 좋아하는 남성 이메일 계정 중 사이트를 제외한 계정만 출력하시오.\n" +
            "(예, apenley2@tripod.com  → apenley2)")
    void findByGenderAndLikeColor() {
        List<Users>maleRed = repository.findByGenderAndLikeColor(Gender.Male, "Red");
        maleRed.stream().map(user -> user.getEmail().split("@")[0]) //@기준으로 앞부분만 추출
                .forEach(x -> System.out.println(x));

    }

}




