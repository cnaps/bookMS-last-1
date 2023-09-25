package com.msa.BookMS.flamework.kafkaadapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.BookMS.application.usecase.MakeAvailableUsecase;
import com.msa.BookMS.application.usecase.MakeUnavailableUsecase;
import com.msa.BookMS.domin.model.event.EventResult;
import com.msa.BookMS.domin.model.event.EventType;
import com.msa.BookMS.domin.model.event.ItemRented;
import com.msa.BookMS.domin.model.event.ItemReturned;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BookEventConsumers {
    //private final Logger log = LoggerFactory.getLogger(BookEventConsumers.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MakeAvailableUsecase makeAvailableUsecase;
    private final MakeUnavailableUsecase makeUnavailableUsecase;
    private final BookEventProducer eventProducer;

    @KafkaListener(topics="${consumer.topic1.name}",groupId = "${consumer.groupid.name}")
    public void consumeRental(ConsumerRecord<String, String> record) throws IOException {

        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);

        EventResult eventResult = new EventResult();
        eventResult.setEventType(EventType.RENT);
        eventResult.setIdName(itemRented.getIdName());
        eventResult.setItem(itemRented.getItem());
        eventResult.setPoint(itemRented.getPoint());

        try{
            System.out.printf("전송받은 값 :" + record.value());

            makeUnavailableUsecase.makeUnavailable(itemRented.getItem().getNo());
            eventResult.setSuccessed(true);
            eventProducer.occurEvent(eventResult);
        } catch (IllegalArgumentException e) {
            System.out.println("도서 상태가 논리적으로 맞지 않은 상태임");
            eventResult.setSuccessed(false);
            eventProducer.occurEvent(eventResult);
        } catch (Exception e) {
            eventResult.setSuccessed(false);
            eventProducer.occurEvent(eventResult);
        }
    }
    @KafkaListener(topics="${consumer.topic2.name}",groupId = "${consumer.groupid.name}")
    public void consumeReturn(ConsumerRecord<String, String> record) throws IOException{
        EventResult eventResult = new EventResult();
        eventResult.setEventType(EventType.RETURN);

        try{
            System.out.printf("전송받은 값 :"  +record.value());
            ItemReturned itemReturned = objectMapper.readValue(record.value(), ItemReturned.class);
            makeAvailableUsecase.available(itemReturned.getItem().getNo());
            eventResult.setSuccessed(true);
            eventProducer.occurEvent(eventResult);
        } catch (IllegalArgumentException e) {
            System.out.println("도서 상태가 논리적으로 맞지 않은 상태임");
            eventResult.setSuccessed(false);
            eventProducer.occurEvent(eventResult);
        } catch (Exception e) {
            eventResult.setSuccessed(false);
            eventProducer.occurEvent(eventResult);
        }

    }

}
