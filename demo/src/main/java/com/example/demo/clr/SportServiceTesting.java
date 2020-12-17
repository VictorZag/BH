package com.example.demo.clr;

import com.example.demo.beans.Item;
import com.example.demo.beans.ItemType;
import com.example.demo.services.SportsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Order(4)
public class SportServiceTesting implements CommandLineRunner {

    private final SportsServiceImpl sportsService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("++++++SportServiceTesting");
        // print all items + count
        System.out.println("------get all sports items");
        System.out.println(sportsService.getAllItems().toString());
        System.out.println(sportsService.getItemsCount().toString());

        // add new item
        System.out.println("------add item");
        Item item = Item.builder().name("newItem").price(BigDecimal.valueOf(11.1)).itemType(ItemType.SPORTS).build();
        sportsService.addItem(item);

        System.out.println(sportsService.getAllItems().toString());
        System.out.println(sportsService.getItemsCount().toString());

        // edit item
        System.out.println("------edit item");
        item.setName("editedItem");
        sportsService.updateItem(item);

        System.out.println(sportsService.getAllItems().toString());

        // get item by id
        System.out.println("------get item by id");
        System.out.println(sportsService.getSingleItem(item.getId()).toString());

    }
}
