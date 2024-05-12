package com.advancedJava.auction.backend.Items.Service;
import com.advancedJava.auction.backend.Items.Dto.ItemDto;
import java.util.List;

public interface ItemService {

    ItemDto addNewItem(ItemDto itemDto);

    List<ItemDto> getAllItem();

    ItemDto updateItem(String itemId, ItemDto updateItem);

    // Delete Outgoing by Id
    void deleteItem(String itemId);

    ItemDto getItemById(String itemId);
}