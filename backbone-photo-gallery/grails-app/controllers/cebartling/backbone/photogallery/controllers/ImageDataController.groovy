package cebartling.backbone.photogallery.controllers

import cebartling.backbone.photogallery.domain.Photo
import cebartling.backbone.photogallery.imaging.ImageUtils

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class ImageDataController {


    def retrieve() {
        def photo = Photo.get(params.id)
        if (photo && photo.imageData) {
            def image = ImageUtils.createBufferedImage(photo.imageData)
            BufferedImage scaledImage = ImageUtils.scaleImage(image, new BigDecimal('.2'))
            response.setContentType("media/jpg")
            OutputStream out = response.getOutputStream()
            try {
                ImageIO.write(scaledImage, 'jpg', out)
            } finally {
                out.flush()
                out.close()
            }
        }
        null
    }


}
