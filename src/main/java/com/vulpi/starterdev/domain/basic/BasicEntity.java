package com.vulpi.starterdev.domain.basic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean deleted = false;


}
