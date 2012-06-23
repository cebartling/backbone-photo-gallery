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
        def image = ImageUtils.createImage(imageData)
        BufferedImage scaledImage = ImageUtils.resizeImage(image, new BigDecimal('.5'), true)
        response.setContentType("media/jpg")
        response.setContentLength(imageData.length)
        OutputStream out = response.getOutputStream()
//        out.write(imageData)
        ImageIO.write(scaledImage, 'jpg', out)
        out.flush()
        out.close()
        return null
    }


}
