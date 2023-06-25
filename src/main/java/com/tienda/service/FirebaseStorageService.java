package com.tienda.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "techshop-f8cbe.appspot.com";

    final String rutaSuperiorStorage = "techshop";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "techshop-f8cbe-firebase-adminsdk-ebkvt-1c4b753205.json";

}
