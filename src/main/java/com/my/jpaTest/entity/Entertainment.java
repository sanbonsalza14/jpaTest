package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entertainment {
    @Id
    private String enterId;
    private String enterName;
    @OneToMany(mappedBy = "girlGroup",
            fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
            @Builder.Default
    List<GirlGroup> groups = new ArrayList<>();
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long e_id;
//    @Column(nullable = false, unique = true, length = 50)
//    private String code;
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @OneToMany(mappedBy = "entertainment",
//        fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
//    private List<GirlGroup> groups = new ArrayList<>();


}
