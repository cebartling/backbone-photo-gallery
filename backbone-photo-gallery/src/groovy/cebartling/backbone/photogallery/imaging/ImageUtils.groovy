package cebartling.backbone.photogallery.imaging

import org.apache.log4j.Logger

import java.awt.AlphaComposite
import java.awt.Graphics2D
import java.awt.Image
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.awt.image.PixelGrabber

class ImageUtils {

    private static final Logger log = Logger.getLogger(ImageUtils)

    /**
     * Create a scaled BufferedImage from an original image.
     *
     * @param originalImage
     * @param scaledWidth
     * @param scaledHeight
     * @param preserveAlpha
     * @return
     */
    static BufferedImage resizeImage(Image originalImage,
                                     int scaledWidth,
                                     int scaledHeight,
                                     boolean preserveAlpha) {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB
        BufferedImage scaledBufferedImage = new BufferedImage(scaledWidth, scaledHeight, imageType)
        Graphics2D graphics2DContext = scaledBufferedImage.createGraphics()
        if (preserveAlpha) {
            graphics2DContext.setComposite(AlphaComposite.Src)
        }
        graphics2DContext.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null)
        graphics2DContext.dispose()
        scaledBufferedImage
    }

    /**
     * Create a scaled BufferedImage from an original image.
     *
     * @param originalImage
     * @param scalingPercentage A scaling percentage as a BigDecimal.
     * @param preserveAlpha
     * @return
     */
    static BufferedImage resizeImage(Image originalImage, BigDecimal scalingPercentage, boolean preserveAlpha) {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB
        PixelGrabber grabber = new PixelGrabber(originalImage, 0, 0, -1, -1, false)
        grabber.grabPixels()
        log.debug "Image original size: Height: ${grabber.getHeight()} pixels, Width: ${grabber.getWidth()} pixels."

        int scaledWidth = scalingPercentage.multiply(new BigDecimal(grabber.getWidth())).intValue()
        int scaledHeight = scalingPercentage.multiply(new BigDecimal(grabber.getHeight())).intValue()
        log.debug "Image scaled size: Height: ${scaledHeight} pixels, Width: ${scaledWidth} pixels."

        BufferedImage scaledBufferedImage = new BufferedImage(scaledWidth, scaledHeight, imageType)
        Graphics2D graphics2DContext = scaledBufferedImage.createGraphics()
        if (preserveAlpha) {
            graphics2DContext.setComposite(AlphaComposite.Src)
        }
        graphics2DContext.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null)
        graphics2DContext.dispose()
        scaledBufferedImage
    }

    /**
     * Create a java.awt.Image from a raw byte array.
     */
    static Image createImage(byte[] rawImageData) {
        Toolkit.getDefaultToolkit().createImage(rawImageData)
    }


}
