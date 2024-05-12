package com.advancedJava.auction.backend.Items.Controller;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.advancedJava.auction.backend.Items.Dto.ItemDto;
import com.advancedJava.auction.backend.Items.Service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

        private ItemService itemService;
         private final ObjectMapper objectMapper;

    @Autowired
    public ItemController(ItemService itemService, ObjectMapper objectMapper) {
        this.itemService = itemService;
        this.objectMapper = objectMapper;
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown properties
    }
//    @Autowired
//    public ItemController(ItemService itemService) {
//        this.itemService = itemService;
//    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDto> addNewItem(
            @RequestParam("itemDto") String itemDtoJson,
            @RequestParam("imageUrl") MultipartFile imageUrl
    ) throws IOException {
        if (imageUrl == null || imageUrl.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Handle empty Image
        }
        // Convert JSON string to ItemDto object
        ItemDto itemDto = new ObjectMapper().readValue(itemDtoJson, ItemDto.class);

        // Set the image data in the itemDto
        itemDto.setImageUrl(imageUrl.getBytes());

        // Save the itemDto using the itemService
        ItemDto savedItem = itemService.addNewItem(itemDto);

        // Return ResponseEntity with the savedFee and CREATED status
        return new ResponseEntity<>(savedItem,HttpStatus.CREATED);
    }

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<ItemDto>> getAllItem() {
            List<ItemDto> item=itemService.getAllItem();
            return ResponseEntity.ok(item);
        }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable String itemId) {
        // Logic to fetch item by itemId from database or service
        ItemDto itemDto = itemService.getItemById(itemId);
        if (itemDto != null) {
            return ResponseEntity.ok(itemDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//        @PutMapping( value = "{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//        public ResponseEntity<ItemDto> updateItem(@PathVariable("id")String itemId,@RequestBody ItemDto updateItem){
//            ItemDto itemDto = itemService.updateItem(itemId,updateItem);
//            return ResponseEntity.ok(itemDto);
//        }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDto> updateItem(
            @PathVariable("id") String itemId,
            @RequestParam("itemDto") String itemDtoJson,
            @RequestParam("imageUrl") MultipartFile imageUrl
    ) throws IOException {
        if (imageUrl == null || imageUrl.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Handle empty Image
        }

        // Convert JSON string to ItemDto object
        ItemDto itemDto = new ObjectMapper().readValue(itemDtoJson, ItemDto.class);

        // Set the image data in the itemDto
        itemDto.setImageUrl(imageUrl.getBytes());

        // Update the item using the itemService
        ItemDto updatedItem = itemService.updateItem(itemId, itemDto);

        // Return ResponseEntity with the updated item and OK status
        return ResponseEntity.ok(updatedItem);
    }

    // Delete Outgoing by Id
        @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> deleteItem(@PathVariable("id") String itemId) {
            itemService.deleteItem(itemId);
            return ResponseEntity.ok("Item details deleted successfully");
        }
}