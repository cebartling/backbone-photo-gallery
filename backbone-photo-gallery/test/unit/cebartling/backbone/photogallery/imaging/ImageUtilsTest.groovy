package cebartling.backbone.photogallery.imaging

import org.apache.commons.io.IOUtils
import org.junit.Before
import org.junit.Test

import java.awt.image.PixelGrabber

class ImageUtilsTest {

    byte[] imageData

    @Before
    void doBeforeEachTest() {
        InputStream is = Thread.currentThread().contextClassLoader.getResourceAsStream('cebartling/backbone/photogallery/imaging/test-image.JPG')
        assert is, 'Unable to load test image resource.'
        imageData = IOUtils.toByteArray(is)
    }

    @Test
    void createImage() {
        def image = ImageUtils.createImage(imageData)
        assert image
        PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, -1, -1, false)
        assert pixelGrabber.grabPixels()
        assert 552 == pixelGrabber.getWidth()
        assert 736 == pixelGrabber.getHeight()
    }

    @Test
    void createBufferedImage() {
        def bufferedImage = ImageUtils.createBufferedImage(imageData)

        assert bufferedImage
        assert 552 == bufferedImage.width
        assert 736 == bufferedImage.height
    }

    @Test
    void scaleImage() {
        def scaledImage = ImageUtils.scaleImage(ImageUtils.createBufferedImage(imageData), new BigDecimal('0.5'))

        assert scaledImage
        assert 276 == scaledImage.width
        assert 368 == scaledImage.height
    }
}
