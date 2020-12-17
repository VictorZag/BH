package com.example.demo.services;

import com.example.demo.beans.Item;
import com.example.demo.exception.InvalidEntityException;
import com.example.demo.repo.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements ItemService, AdminService {

    private final ItemRepository itemRepository;

    @Override
    public void addItem(Item item) throws InvalidEntityException {
        itemRepository.save(item);
    }

    @Override
    public void updateItem(Item item) throws InvalidEntityException {
        if(item.getId() == getSingleItem(item.getId()).getId())
        {
            itemRepository.saveAndFlush(item);
        }
        else
        {
            throw new InvalidEntityException("Cannot update not existing id");
        }
    }

    @Override
    public void deleteItem(Item item) throws InvalidEntityException{
        if(item.getId() == getSingleItem(item.getId()).getId())
        {
            itemRepository.delete(item);
        }
        else
        {
            throw new InvalidEntityException("cannot delete - id not exist");
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
            return itemRepository.findById(id).get();
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Long getItemsCount() {
        return itemRepository.count();
    }
}
