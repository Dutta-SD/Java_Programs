package edu.sandip.blog_app_apis.services.impl;

import edu.sandip.blog_app_apis.services.FileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String directoryPathToSave, MultipartFile multipartFile) {
        String fullPathOfUploadedImage = prepareFullPathOfUploadedImage(directoryPathToSave, multipartFile);
        createImageDirectoryIfNotExists(directoryPathToSave);
        copyImageToTargetDestination(fullPathOfUploadedImage, multipartFile);
        return fullPathOfUploadedImage;
    }

    private void copyImageToTargetDestination(String fullPathOfUploadedImage, MultipartFile multipartFile) {
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(fullPathOfUploadedImage));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Uploading Image Error For Image Name " + multipartFile.getOriginalFilename());
            throw new RuntimeException(e);
        }
    }

    private void createImageDirectoryIfNotExists(String directoryPathToSave) {
        File f = new File(directoryPathToSave);
        if (!f.exists()) {
            f.mkdir();
        }
    }

    private String prepareFullPathOfUploadedImage(String directoryPathToSave, MultipartFile multipartFile) {
        String fileExtension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String randomFileName = String.format("%s.%s", UUID.randomUUID(), fileExtension);
        return directoryPathToSave + File.separator + randomFileName;
    }
}