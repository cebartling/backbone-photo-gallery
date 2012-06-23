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
    void resizeImage_WidthAndHeightSpecified() {

    }

    @Test
    void resizeImage_ScalingPercentageSpecified() {

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
}
