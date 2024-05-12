package com.advancedJava.auction.backend.Items.Repository;

import com.advancedJava.auction.backend.Items.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
