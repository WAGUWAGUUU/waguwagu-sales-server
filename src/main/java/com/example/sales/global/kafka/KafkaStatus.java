package com.example.sales.global.kafka;

public record KafkaStatus<T>(
        T data, String status
){
}
