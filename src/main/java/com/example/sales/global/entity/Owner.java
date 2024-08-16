package com.example.sales.global.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="OWNERS")
@Builder
public class Owner {
    @Id
    @Column(name = "OWNER_ID")
    private Long ownerId;

    @Column(name = "OWNER_EMAIL")
    private String ownerEmail;

    @Column(name = "OWNER_NAME")
    private String ownerName;

    @Column(name = "OWNER_BUSINESS_NUMBER")
    private String ownerBusinessNumber;

    @Column(name = "OWNER_IS_DELETED")
    private boolean ownerIsDeleted;

}
