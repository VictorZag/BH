package com.example.demo.clr;

import com.example.demo.beans.Item;
import com.example.demo.beans.ItemType;
import com.example.demo.services.ElectricityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Order(3)
public class ElectricityServiceTesting implements CommandLineRunner {

    private final ElectricityServiceImpl electricityService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("++++++ElectricityServiceTesting");
        // print all items + count
        System.out.println("------get all electricity items");
        System.out.println(electricityService.getAllItems().toString());
        System.out.println(electricityService.getItemsCount().toString());

        // add new item
        System.out.println("------add item");
        Item item = Item.builder().name("newItem").price(BigDecimal.valueOf(11.1)).itemType(ItemType.ELECTRICITY).build();
        electricityService.addItem(item);

        System.out.println(electricityService.getAllItems().toString());
        System.out.println(electricityService.getItemsCount().toString());

        // edit item
        System.out.println("------edit item");
        item.setName("editedItem");
        electricityService.updateItem(item);

        System.out.println(electricityService.getAllItems().toString());

        // get item by id
        System.out.println("------get item by id");
        System.out.println(electricityService.getSingleItem(item.getId()).toString());

    }
}
