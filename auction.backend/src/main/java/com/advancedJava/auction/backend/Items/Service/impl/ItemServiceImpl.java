package com.advancedJava.auction.backend.Items.Service.impl;

import com.advancedJava.auction.backend.Items.Dto.ItemDto;
import com.advancedJava.auction.backend.Items.Entity.Item;
import com.advancedJava.auction.backend.Items.Mapper.ItemMapper;
import com.advancedJava.auction.backend.Items.Repository.ItemRepository;
import com.advancedJava.auction.backend.Items.Service.ItemService;
import com.advancedJava.auction.backend.Items.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ItemServiceImpl implements ItemService {

        private ItemRepository itemRepository;
        @Override
        public ItemDto addNewItem(ItemDto itemDto) {
            Item item = ItemMapper.mapToItem(itemDto);
            Item savedItem=itemRepository.save(item);
            return ItemMapper.mapToItemDto(savedItem);
        }

        @Override
        public List<ItemDto> getAllItem() {
            List<Item> items=itemRepository.findAll();
            return items.stream().map(ItemMapper::mapToItemDto).collect(Collectors.toList());
        }

        @Override
        public ItemDto getItemById(String itemId) {
            Item item = itemRepository.findById(itemId).orElseThrow(
                    () -> new ResourceNotFoundException("Item is not exists with given id:" + itemId)
            );

            return ItemMapper.mapToItemDto(item);
        }

        @Override
        public ItemDto updateItem(String itemId, ItemDto updateItem) {

            Item item = itemRepository.findById(itemId).orElseThrow(
                    ()-> new ResourceNotFoundException("Item is not exists with given id:" + itemId)
            );

            item.setItemName(updateItem.getItemName());
            item.setDescription(updateItem.getDescription());
            item.setStarting_price(updateItem.getStarting_price());
            item.setCategory(updateItem.getCategory());
            item.setStartDateTime(updateItem.getStartDateTime());
            item.setEndDateTime(updateItem.getEndDateTime());
            item.setImageUrl(updateItem.getImageUrl());

            Item updateItemObj = itemRepository.save(item);


            return ItemMapper.mapToItemDto(updateItemObj);
        }

        // Delete Outgoing by Id
        @Override
        public void deleteItem(String itemId) {
            Item item = itemRepository.findById(itemId).orElseThrow(
                    () -> new ResourceNotFoundException("Item is not exists with given id:" + itemId)
            );
            itemRepository.deleteById(itemId);
        }
}
