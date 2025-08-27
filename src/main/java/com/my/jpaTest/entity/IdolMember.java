package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdolMember {

    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "groupId")
    private GirlGroup girlGroup;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long m_id;
//
//    @Column(nullable = false, unique = true, length = 50)
//    private String code;
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "g_id")
//    private GirlGroup girlGroup;
}
