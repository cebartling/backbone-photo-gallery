package cebartling.backbone.photogallery.controllers

import cebartling.backbone.photogallery.imaging.ImageUtils
import org.apache.commons.io.IOUtils

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class ImageDataController {


    def retrieve() {
        def imageFilePath = servletContext.getRealPath('/images/test-photos/test1.JPG')
        final File imageFile = new File(imageFilePath)
        final InputStream is = new BufferedInputStream(new FileInputStream(imageFile))
        final byte[] imageData = IOUtils.toByteArray(is)
        def image = ImageUtils.createBufferedImage(imageData)
        BufferedImage scaledImage = ImageUtils.scaleImage(image, new BigDecimal('.2'))
        response.setContentType("media/jpg")
        OutputStream out = response.getOutputStream()
        try {
            ImageIO.write(scaledImage, 'jpg', out)
        } finally {
            out.flush()
            out.close()
        }
        null
    }


}
