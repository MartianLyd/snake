package com.kryocore.snake.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class KafkaProducerSnake {
    public static void main(String[] args) {
//        producer_test1(args);

        producer_test2();
    }

    private static void producer_test2() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "leemaster001:9092,leeslave001:9092,leeslave002:9092");
        props.put("acks", "all"); //回令类型
        props.put("retries", 0); //重试次数
        props.put("batch.size", 16384);  //批量提交大小
        props.put("linger.ms", 1); //提交延迟等待时间
        props.put("buffer.memory", 33554432); //缓存大小
        //序列化方法
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for(int i = 0; i < 5000; i++)
            producer.send(new ProducerRecord<String, String>("snake", Integer.toString(i), Integer.toString(i)));

        producer.close();
    }

    private static void producer_test1(String[] args) {
        String arg0 = args != null && args.length > 0 ? args[0] : "10";
        long events = Long.parseLong(arg0);
        Random rnd = new Random();

        //    /opt/kafka_2.12-1.1.0/bin/kafka-console-producer.sh --broker-list 192.178.0.111:9092 --sync --topic kafkatopic
        Properties props = new Properties();
        props.put("bootstrap.servers", "leemaster001:9092,leeslave001:9092,leeslave002:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 配置partitionner选择策略，可选配置
        props.put("partitioner.class", "com.dx.SimplePartitioner2");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (long nEvents = 0; nEvents < events; nEvents++) {
            long runtime = new Date().getTime();
            String ip = "192.178.0." + rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;
            ProducerRecord<String, String> data = new ProducerRecord<String, String>("snake", ip, msg);
            Future<RecordMetadata> send = producer.send(data,
                    new Callback() {
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            if (e != null) {
                                e.printStackTrace();
                            } else {
                                System.out.println("The offset of the record we just sent is: " + metadata.offset());
                            }
                        }
                    });
        }
        producer.close();
    }
}
