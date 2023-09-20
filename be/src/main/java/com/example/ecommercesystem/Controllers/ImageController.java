package com.example.ecommercesystem.Controllers;

import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
@Controller
@RequestMapping("/images")
public class ImageController {
    private final String directoryImage = "/static/images/products/";

    @GetMapping(
            value = "/products/{nameImage}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getProductImage(@PathVariable String nameImage)
            throws IOException {
        String pathImage = directoryImage + nameImage;

        InputStream in = getClass()
                .getResourceAsStream(pathImage);

        return IOUtils.toByteArray(in);
    }
}
