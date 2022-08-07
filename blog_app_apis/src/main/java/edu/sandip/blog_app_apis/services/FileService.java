package edu.sandip.blog_app_apis.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadImage(String directoryPathToSave, MultipartFile multipartFile);
}
