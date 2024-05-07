package com.advancedJava.auction.backend.Items.Service;
import com.advancedJava.auction.backend.Items.Dto.ItemDto;
import java.util.List;

public interface ItemService {

    ItemDto addNewItem(ItemDto itemDto);

    List<ItemDto> getAllItem();

    ItemDto updateItem(Long itemId, ItemDto updateItem);

    // Delete Outgoing by Id
    void deleteItem(Long itemId);
}