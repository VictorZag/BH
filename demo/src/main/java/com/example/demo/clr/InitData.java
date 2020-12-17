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
@Order(1)
public class InitData implements CommandLineRunner {

    private final AdminServiceImpl adminServiceImpl;

    @Override
    public void run(String... args) throws Exception {
        Item  item;
        for (int i = 1; i <= 10; i++) {
            item = Item.builder()
                    .name("item" + i)
                    .itemType(ItemType.values()[(int) (Math.random() * (ItemType.values().length))])
                    .price((BigDecimal.valueOf(Math.random() * 100)))
                    .build();
            adminServiceImpl.addItem(item);

        }

    }
}
