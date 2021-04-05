package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.service.CarouselService;
import com.example.AutoWorkShop.service.ImageShuffler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    private final Logger LOGGER = LoggerFactory.getLogger(CarouselServiceImpl.class);
    private final ImageShuffler imageShuffler;

    private List<String> images = new ArrayList<>(List.of("1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg"));

    public CarouselServiceImpl(ImageShuffler imageShuffler) {
        this.imageShuffler = imageShuffler;
    }

    @PostConstruct
    public void afterInitialize() {
        if (images.size() < 3) {
            throw new IllegalArgumentException("Sorry, but you must add more then three images...");
        }
    }

    @Override
    public String firstImage() {
        return images.get(0);
    }

    @Override
    public String secondImage() {
        return images.get(1);
    }

    @Override
    public String thirdImage() {
        return images.get(3);
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void refresh() {
        LOGGER.info("Shuffling images...");
        imageShuffler.shuffle(images);
    }
}
