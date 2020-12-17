package com.example.demo.services;

import com.example.demo.beans.Item;
import com.example.demo.exception.InvalidEntityException;

public interface AdminService {

    void deleteItem(Item item) throws InvalidEntityException;
}
