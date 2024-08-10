package com.example.sales.global.kafka;

import java.sql.Timestamp;

public record KafkaSalesDTO(
        Long storeId,
        Timestamp time,
        int sales
) {
}
