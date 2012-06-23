package cebartling.backbone.photogallery.controllers

import org.apache.commons.io.IOUtils

class ImageDataController {


    def retrieve() {
        def imageFilePath = servletContext.getRealPath('/images/test-photos/test1.JPG')
        final File imageFile = new File(imageFilePath)
        final InputStream is = new BufferedInputStream(new FileInputStream(imageFile))
        final byte[] imageData = IOUtils.toByteArray(is)

        response.setContentType("media/jpg")
        response.setContentLength(imageData.length)
        OutputStream out = response.getOutputStream()
        out.write(imageData)
        out.flush()
        out.close()
        return null
    }


}
