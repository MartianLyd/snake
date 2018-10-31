package com.kryocore.snake.kafka;

import kafka.api.FetchRequestBuilder;
import kafka.common.OffsetAndMetadata;
import kafka.javaapi.FetchRequest;
import kafka.javaapi.FetchResponse;
import kafka.message.MessageAndOffset;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Kafka consumer
 * created by kryocore 2018/10/5
 */
public class KafkaConsumerSnake {
    public static void main(String[] args) {
        Properties props = new Properties();
        // 这里不是配置zookeeper了，这个是配置bootstrap.servers
        props.put("bootstrap.servers", "leemaster001:9092,leeslave001:9092,leeslave002:9092");
        // 标识该使用者所属的消费者组的唯一字符串。
        props.put("group.id", "snake");
        // 如果true，消费者的偏移量将在后台定期提交。
        props.put("enable.auto.commit", "true");
        props.put("max.poll.records", 1000);
        // 消费者偏移量在毫秒内自动提交给Kafka
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "latest"); //latest   earliest
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        // 配置topic
        consumer.subscribe(Arrays.asList("snake"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records)
                // 直接通过record.offset()得到offset的值
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }




    }

}
