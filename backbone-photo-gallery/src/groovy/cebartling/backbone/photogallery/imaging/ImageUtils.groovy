package cebartling.backbone.photogallery.imaging

import com.mortennobel.imagescaling.ResampleOp
import org.apache.log4j.Logger

import java.awt.Image
import java.awt.Toolkit
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class ImageUtils {

    private static final Logger log = Logger.getLogger(ImageUtils)



    static BufferedImage scaleImage(BufferedImage originalImage, BigDecimal scalingPercentage) {
        log.debug "Image original size: Height: ${originalImage.height} pixels, Width: ${originalImage.width} pixels."

        int scaledWidth = scalingPercentage.multiply(new BigDecimal(originalImage.width)).intValue()
        int scaledHeight = scalingPercentage.multiply(new BigDecimal(originalImage.height)).intValue()
        log.debug "Image scaled size: Height: ${scaledHeight} pixels, Width: ${scaledWidth} pixels."

        ResampleOp resampleOp = new ResampleOp(scaledWidth, scaledHeight)
        return resampleOp.filter(originalImage, null)
    }

    /**
     * Create a java.awt.Image from a raw byte array.
     */
    static Image createImage(byte[] rawImageData) {
        Toolkit.getDefaultToolkit().createImage(rawImageData)
    }

    /**
     * Create a java.awt.image.BufferedImage from a raw byte array.
     *
     * @param rawImageData A byte array representing an image.
     * @return A java.awt.image.BufferedImage instance representing the image contained in the
     * raw image data byte array passed in.
     */
    static BufferedImage createBufferedImage(byte[] rawImageData) {
        ImageIO.read(new ByteArrayInputStream(rawImageData))
    }


}
