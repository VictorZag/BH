package com.example.demo.services;

import com.example.demo.beans.Item;
import com.example.demo.beans.ItemType;
import com.example.demo.exception.InvalidEntityException;
import com.example.demo.repo.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectricityServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public void addItem(Item item) throws InvalidEntityException {
        if(item.getItemType() == ItemType.ELECTRICITY)
        {
            itemRepository.save(item);
        }
        else
        {
            throw new InvalidEntityException("cannot add an item outside your domain");
        }
    }

    @Override
    public void updateItem(Item item) throws InvalidEntityException {
        if(item.getItemType() != ItemType.ELECTRICITY)
        {
            throw new InvalidEntityException("cannot update an item outside your domain");
        }

        if(item.getId() == getSingleItem(item.getId()).getId())
        {
            itemRepository.saveAndFlush(item);
        }

    }

    @Override
    public Item getSingleItem(Long id) throws InvalidEntityException {
        if (itemRepository.findById(id).isEmpty())
        {
            throw new InvalidEntityException("Item not found");
        }
        else
        {
            Item item = itemRepository.findById(id).get();
            if(item.getItemType() == ItemType.ELECTRICITY)
            {
                return itemRepository.findById(id).get();
            }
            else
            {
                throw new InvalidEntityException("cannot get an item outside your domain");
            }

        }
    }

    @Override
    public List<Item> getAllItems() {
    /*    List<Item> items = new ArrayList<>();
        for (Item item:itemRepository.findAll()) {
            if(item.getItemType() == ItemType.ELECTRICITY){
                items.add(item);
            }
        }
        return items;*/
        return itemRepository.findAll(Example.of(Item.builder().itemType(ItemType.ELECTRICITY).build()));
    }

    @Override
    public Long getItemsCount() {
        return itemRepository.count(Example.of(Item.builder().itemType(ItemType.ELECTRICITY).build()));
        //return getAllItems().size();
    }

}
