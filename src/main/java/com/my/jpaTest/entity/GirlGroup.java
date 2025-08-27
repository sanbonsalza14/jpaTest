package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GirlGroup {
    @Id
    private String groupId;
    private String groupName;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "enterId")
    Entertainment entertainment;

//    @OneToMany(mappedBy ="girlGroup",
//          fetch = FetchType.EAGER)
    @Builder.Default
    @OneToMany(mappedBy = "girlGroup", fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    List<IdolMember> members = new ArrayList<>();

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long g_id;
//
//    @Column(nullable = false, unique = true, length = 50)
//    private String code;
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "e_id")
//    private Entertainment entertainment;
//
//    @OneToMany(mappedBy = "group",
//            fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
//    private List<IdolMember> members = new ArrayList<>();

    }
