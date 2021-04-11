# spring-base64-example
Demo project for displaying Base64 images in HTML

### Features
- Display image files in HTML not using a server based url but using a base64 encoded string.
- Using base64 encoded string, it's possible to show tif/tiff images in all web browsers. 
  - Convert a tif/tiff file to a jpeg file using [jai-imageio](https://github.com/jai-imageio/jai-imageio-core) and then encode to base64.
  - cf. [Comparison of web browsers: Image format support](https://en.wikipedia.org/wiki/Comparison_of_web_browsers#Image_format_support)

### References
- Sample .tif image: https://people.math.sc.edu/Burkardt/data/tif/tif.html
