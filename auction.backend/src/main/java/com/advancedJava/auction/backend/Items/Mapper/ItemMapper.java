package com.advancedJava.auction.backend.Items.Mapper;

import com.advancedJava.auction.backend.Items.Dto.ItemDto;
import com.advancedJava.auction.backend.Items.Entity.Item;

public class ItemMapper {
        public static ItemDto mapToItemDto(Item item){
            return new ItemDto(
                    item.getItem_id(),
                    item.getName(),
                    item.getDescription(),
                    item.getStarting_price(),
                    item.getCategory(),
                    item.getImageUrl()
            );
        }

        public static Item mapToItem(ItemDto itemDto){
            return new Item(
                    itemDto.getItem_id(),
                    itemDto.getName(),
                    itemDto.getDescription(),
                    itemDto.getStarting_price(),
                    itemDto.getCategory(),
                    itemDto.getImageUrl()
                    );
        }
}
