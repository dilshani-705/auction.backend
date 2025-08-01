package com.advancedJava.auction.backend.Items.Mapper;

import com.advancedJava.auction.backend.Items.Dto.ItemDto;
import com.advancedJava.auction.backend.Items.Entity.Item;

public class ItemMapper {
        public static ItemDto mapToItemDto(Item item){
            return new ItemDto(
                    item.getItemId(),
                    item.getItemName(),
                    item.getDescription(),
                    item.getStarting_price(),
                    item.getCategory(),
                    item.getStartDateTime(),
                    item.getEndDateTime(),
                    item.getImageUrl()
            );
        }

        public static Item mapToItem(ItemDto itemDto){
            return new Item(
                    itemDto.getItemId(),
                    itemDto.getItemName(),
                    itemDto.getDescription(),
                    itemDto.getStarting_price(),
                    itemDto.getCategory(),
                    itemDto.getStartDateTime(),
                    itemDto.getEndDateTime(),
                    itemDto.getImageUrl()
                    );
        }
}
