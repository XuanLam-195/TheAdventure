package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item testItem;

    @BeforeEach
    void setup(){
        testItem = new Item("Test","This is a test item.");
    }

    @Test
    void getName() {
        String expectedName = "Test";
        assertEquals(expectedName,testItem.getName());
    }

    @Test
    void setName() {
        testItem.setName("Test1");
        String expectedName = "Test1";
        assertEquals(expectedName,testItem.getName());
    }

    @Test
    void getDescription() {
        String expectedDescription = "This is a test item.";
        assertEquals(expectedDescription, testItem.getDescription());
    }

    @Test
    void setDescription() {
        testItem.setDescription("Test2");
        String expectedDescription = "Test2";
        assertEquals(expectedDescription, testItem.getDescription());
    }

    @Test
    void getPlayer() {
    }

    @Test
    void setPlayer() {
    }

    @Test
    void getRoom() {
    }

    @Test
    void setRoom() {
    }
}