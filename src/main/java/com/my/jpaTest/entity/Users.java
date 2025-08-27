package com.my.jpaTest.entity;

import com.my.jpaTest.dto.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    //Enum Type 은 생성 순번이 기본
    //Enum Type 자체 문자열로 저장
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="like_color")
    private String likeColor;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

//// src/main/java/com/my/jpaTest/repository/EntertainmentRepository.java
//package com.my.jpaTest.repository;
//
//import com.my.jpaTest.entity.Entertainment;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface EntertainmentRepository extends JpaRepository<Entertainment, Long> {
//    Optional<Entertainment> findByCode(String code);
//    boolean existsByCode(String code);
//}
