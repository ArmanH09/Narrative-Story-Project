import org.code.theater.*;
import org.code.media.*;

/* 
 * Represents an image that contains multiple filters
 */

public class ImageFilter extends ImagePlus {

  /*
   * Calls the superclass contructor to initialize the 2D array
   */

  public ImageFilter(String filename) {
    super(filename);
  }


  /*
  Pixelates the photo by x ammount
  Traverse the photo and traverse regions that are X by X pixels, get the average of each pixel in that region and set the entire region to the same color

  Get the image pixels into a 2d array
  First traversal increments by values of grid size, so each traversal goes to the top left corner of each region
  Uses the current position and adds grid size to determine the end point of the region, Math.min() is used to prevent number from going out of bounds for the pixels array
  Resets count and RGB values
  Uses curent row and col position, along with endRow and endCol to traverse the inner region
  Traverse and add up all the RGB values, for each pixel traverse count gets added by 1
  Divide the RGB values by count, and retraverse to set the pixel values to the average in the region
  At the next traversal RGB and count values are reset
  Goes on until the outer traversal finishes with the whole photo
  */
  
  public void pixelate (int gridSize) {
    Pixel[][] pixels = getImagePixels();


    for(int row = 0; row < pixels.length; row += gridSize) {
      for (int col = 0; col < pixels[0].length; col += gridSize) {
        int endRow = Math.min(row + gridSize, pixels.length); 
        int endCol = Math.min(col + gridSize, pixels[0].length);
        int Red = 0;
        int Green = 0;
        int Blue = 0;
        int count = 0;

        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            Red += pixels[regionRow][regionCol].getRed();
            Green += pixels[regionRow][regionCol].getGreen();
            Blue += pixels[regionRow][regionCol].getBlue();
            count++;
          }
        }

        Red /= count;
        Green /= count;
        Blue /= count;

        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            pixels[regionRow][regionCol].setRed(Red);
            pixels[regionRow][regionCol].setGreen(Green);
            pixels[regionRow][regionCol].setBlue(Blue);
          }
        }
      }
    }
  }
}