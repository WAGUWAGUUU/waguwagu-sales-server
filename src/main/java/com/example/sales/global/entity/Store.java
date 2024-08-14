package com.example.sales.global.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="stores")
@Builder
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(name = "STORE_NAME")
    private String storeName;

    @Column(name = "STORE_ADDRESS")
    private String storeAddress;

    @Column(name = "STORE_LONGITUDE")
    private double storeLongitude;

    @Column(name = "STORE_LATITUDE")
    private double storeLatitude;

    @Column(name = "STORE_OPEN_AT")
    private LocalTime storeOpenAt;

    @Column(name = "STORE_CLOSE_AT")
    private LocalTime storeCloseAt;

    @Column(name = "STORE_PHONE")
    private String storePhone;

    @Column(name = "STORE_MINIMUM_ORDER_AMOUNT")
    private int storeMinimumOrderAmount;

    @Column(name = "STORE_INTRODUCTION")
    private String storeIntroduction;

    @Column(name = "STORE_CATEGORY")
    private String storeCategory;

    @Column(name = "STORE_IS_DELETED")
    private boolean storeIsDeleted;

    //    1 -> 영업 수동 막기, 0 -> 정상 영업
    @Column(name = "STORE_BLOCK_IS_OPENED")
    private boolean storeBlockIsOpened;

    @Column(name = "STORE_IMAGE")
    private String storeImage;


    @ManyToOne
    @JoinColumn(name = "OWNER_ID")  // Foreign key
    private Owner owner;

//    @OneToMany(mappedBy = "store")
//    private List<String> menuCategories;

}

