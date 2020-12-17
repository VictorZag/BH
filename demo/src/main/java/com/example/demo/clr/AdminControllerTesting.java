package com.example.demo.clr;

import com.example.demo.beans.Item;
import com.example.demo.beans.ItemType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@RequiredArgsConstructor
@Component
@Order(5)
public class AdminControllerTesting implements CommandLineRunner {

    private static final String URL = "http://localhost:8080/admin/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("++++++AdminControllerTesting");

        System.out.println("------get all items");
        Object res = restTemplate.getForObject(URL, Object.class);

        System.out.println(res);

        System.out.println("------get items count");
        int count = restTemplate.getForObject(URL+"count", Integer.class);

        System.out.println(count);

        System.out.println("------add item");
        Item newItem =Item.builder().name("newItem").itemType(ItemType.OTHER).build();
        restTemplate.postForObject(URL,newItem,Object.class);
        res = restTemplate.getForObject(URL, Object.class);
        System.out.println(res);

        System.out.println("------get item by id");
        Item item = restTemplate.getForObject(URL+14, Item.class);
        System.out.println(item);

        System.out.println("------edit item");
        item.setName("updatedItem");
        restTemplate.put(URL,item,Object.class);
        res = restTemplate.getForObject(URL, Object.class);
        System.out.println(res);

        System.out.println("------delete item");
        HttpEntity<Item> httpEntity =  new HttpEntity<>(item);
        System.out.println(restTemplate.exchange(URL,HttpMethod.DELETE ,httpEntity,String.class));
        res = restTemplate.getForObject(URL, Object.class);
        System.out.println(res);

    }
}
