package com.advancedJava.auction.backend.Items.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    private String itemId;

    @Column (name="itemName")
    private String itemName;

    @Column (name="description")
    private String description;

    @Column (name="starting_price")
    private Float starting_price;

    @Column (name="category")
    private String category;

    @Column(name = "start_date_time")
    private String startDateTime;

    @Column(name = "end_date_time")
    private String endDateTime;

    @Lob
    @Column(name = "imageUrl", columnDefinition = "LONGBLOB")
    private byte[] imageUrl;

}
