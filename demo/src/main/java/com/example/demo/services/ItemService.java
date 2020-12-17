package  com.example.demo.services;

import com.example.demo.beans.Item;
import com.example.demo.exception.InvalidEntityException;
import java.util.List;

public interface ItemService {

    void addItem(Item item) throws InvalidEntityException;
    void updateItem(Item item) throws InvalidEntityException;
    Item getSingleItem(Long id) throws InvalidEntityException;
    List<Item> getAllItems();
    Long getItemsCount();
}
