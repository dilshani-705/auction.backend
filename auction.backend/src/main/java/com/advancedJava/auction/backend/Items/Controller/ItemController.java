package com.advancedJava.auction.backend.Items.Controller;

import com.advancedJava.auction.backend.Items.Dto.ItemDto;
import com.advancedJava.auction.backend.Items.Service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

        private ItemService itemService;


        @PostMapping(consumes = "application/json", produces = "application/json")
        public ResponseEntity<ItemDto> addNewItem(@RequestBody ItemDto itemDto) {
            ItemDto savedItem=itemService.addNewItem(itemDto);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        }

        @GetMapping(produces = "application/json")
        public ResponseEntity<List<ItemDto>> getAllItem() {
            List<ItemDto> item=itemService.getAllItem();
            return ResponseEntity.ok(item);
        }

        @PutMapping( value = "{id}",produces = "application/json")
        public ResponseEntity<ItemDto> updateItem(@PathVariable("id")Long itemId,@RequestBody ItemDto updateItem){
            ItemDto itemDto = itemService.updateItem(itemId,updateItem);
            return ResponseEntity.ok(itemDto);
        }

        // Delete Outgoing by Id
        @DeleteMapping(value = "{id}", produces = "application/json")
        public ResponseEntity<String> deleteItem(@PathVariable("id") Long itemId) {
            itemService.deleteItem(itemId);
            return ResponseEntity.ok("Item details deleted successfully");
        }
}