package com.huntercodexs.genericv1.model;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    String address;

    @Column
    String userIdentify;

    @Column
    String active;

    @Column
    String createdAt;

    @Column
    String updatedAt;

    @Column
    String deletedAt;

}
