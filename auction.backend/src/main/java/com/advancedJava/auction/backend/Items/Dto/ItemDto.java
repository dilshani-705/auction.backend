package com.advancedJava.auction.backend.Items.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

        private long Item_id;

        private String name;

        private String description;

        private Float starting_price;

        private String category;

        private String imageUrl;

}
