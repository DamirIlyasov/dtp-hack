package com.hackteam.dtp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String save(MultipartFile multipartFile) throws IOException;

    void delete(String imgName) throws IOException;

    String getStoragePath();
}
