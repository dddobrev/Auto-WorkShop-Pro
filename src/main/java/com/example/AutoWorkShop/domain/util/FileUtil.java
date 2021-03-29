package com.example.AutoWorkShop.domain.util;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface FileUtil {
    String[] getFileContent(String filePath) throws IOException;
}
