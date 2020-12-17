package com.example.demo.clr;

import com.example.demo.beans.Item;
import com.example.demo.beans.ItemType;
import com.example.demo.services.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Order(2)
public class AdminServiceTesting implements CommandLineRunner {

    private final AdminServiceImpl adminService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("++++++AdminServiceTesting");
        // print all items + count
        System.out.println("------get all items");
        System.out.println(adminService.getAllItems().toString());
        System.out.println(adminService.getItemsCount().toString());

        // add new item
        System.out.println("------add item");
        Item item = Item.builder().name("newItem").price(BigDecimal.valueOf(11.1)).itemType(ItemType.OTHER).build();
        adminService.addItem(item);

        System.out.println(adminService.getAllItems().toString());
        System.out.println(adminService.getItemsCount().toString());

        // edit item
        System.out.println("------edit item");
        item.setName("editedItem");
        adminService.updateItem(item);

        System.out.println(adminService.getAllItems().toString());

        // get item by id
        System.out.println("------get item by id");
        System.out.println(adminService.getSingleItem(item.getId()).toString());

        // delete item
        System.out.println("------delete item");
        adminService.deleteItem(item);

        System.out.println(adminService.getAllItems().toString());
        System.out.println(adminService.getItemsCount().toString());

    }
}
