package com.huntercodexs.genericv1.model.oauth2;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String description;

    @Column
    private String name;

}
