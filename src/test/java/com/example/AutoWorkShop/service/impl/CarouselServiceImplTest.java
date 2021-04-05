package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.service.ImageShuffler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class CarouselServiceImplTest {
    private CarouselServiceImpl serviceToTest;

    @BeforeEach
    void setUp() {
        serviceToTest = new CarouselServiceImpl(
                new TestImageShuffler()
        );
    }

    @Test
    public void testRefresh() {
        serviceToTest.refresh();

        Assertions.assertEquals("6.jpg", serviceToTest.firstImage());
        Assertions.assertEquals("5.jpg", serviceToTest.secondImage());
        Assertions.assertEquals("3.jpg", serviceToTest.thirdImage());
    }

    static class TestImageShuffler implements ImageShuffler {
        @Override
        public void shuffle(List<String> images) {
            Collections.reverse(images);
        }
    }
}