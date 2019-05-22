package com.vulpi.starterdev.domain.contact;

import com.vulpi.starterdev.domain.basic.BasicEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_contact")
@EqualsAndHashCode(callSuper = true)
public class Contact extends BasicEntity {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    private String phone;

    private String job;

    private String notes;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private ContactStatus status = ContactStatus.ACTIVE;

}

