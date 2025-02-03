import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  String[][] AmericanCarInfo;
  String[][] GermanCarInfo;


  // No argument constructor
  public MyStory() {
    
  }


  // Parameterized Constructor, takes in US and EU car String arrays
  public MyStory(String[][] AmericanCarInfo, String[][] GermanCarInfo) {
    this.AmericanCarInfo = AmericanCarInfo;
    this.GermanCarInfo = GermanCarInfo;
  }

  /*
  Method to return how fast a car is based on its horsepower (string)
  If the horsepower String has a length of 4, then it is atleast 1000 HP,so it return Extremely Fast
  If the horsepower String has a length of 3, and the first character as an int is greater than or equal to 6, then it is at least 600hp and is Very Fast
  If the horsepower String has a length of 3, and the first character as an int is greater than or equal to 4 and is less than 6, then the horsepower is between 400 and 600 HP, and is Fast
  */
  public String howFast(String Horsepower) {
    
    if (Horsepower.length() >= 4) {
      return "Extremely Fast!";
    } else if (Character.getNumericValue(Horsepower.charAt(0)) >= 6 && Horsepower.length() == 3) {
      return "Very Fast!";
    } else if (((Character.getNumericValue(Horsepower.charAt(0)) >= 4 && Character.getNumericValue(Horsepower.charAt(0)) < 6) && Horsepower.length() == 3)) {
      return "Fast!";
    }

    return null;
  }


  /*
  Method to draw the scene for the US car portion (audio clips are shorter than EU cars)
  Set Text Size to default, say "These are my Favorite American Cars!"
  Clear and traverse the rows in the American Car array
  For each traversal it draws the car, prints out info using other array values and the howFast method, plays the audio clip, pixelates the photo, and resets the backdrop
  */
  
  public void drawUSCar() {
    setTextHeight(20);
    clear("white");
    drawText("These are my Favorite American Cars!", 25, 200);
    pause(2);
    clear("white");
    setTextHeight(10);
    for(int r = 0; r < AmericanCarInfo.length; r++) {
      ImageFilter photo = new ImageFilter(AmericanCarInfo[r][2]);
      drawImage(photo, 0, 0, 400);
      drawText("This is the " + AmericanCarInfo[r][0] + ", it has " + AmericanCarInfo[r][1] + "HP and it is " + howFast(AmericanCarInfo[r][1]), 0, 350);
      playSound(AmericanCarInfo[r][3]);
      pause(12);
      photo.pixelate(5);
      drawImage(photo, 0, 0, 400);
      pause(2);
      clear("white");
    }
  }

  /*
  Method to draw the scene for the german car portion (audio clips are longer than US cars)
  Set Text Size to default, say "These are my Favorite German Cars!"
  Clear and traverse the rows in the German Car array
  For each traversal it draws the car, prints out info using other array values and the howFast method, plays the audio clip, pixelates the photo, and resets the backdrop
  */
  
  public void drawEUCar() {
    setTextHeight(20);
    clear("white");
    drawText("These are my Favorite German Cars!", 25, 200);
    pause(2);
    clear("white");
    setTextHeight(10);
    for(int r = 0; r < GermanCarInfo.length; r++) {
      ImageFilter photo = new ImageFilter(GermanCarInfo[r][2]);
      drawImage(photo, 0, 0, 400);
      drawText("This is the " + GermanCarInfo[r][0] + ", it has " + GermanCarInfo[r][1] + "HP and it is " + howFast(GermanCarInfo[r][1]), 0, 350);
      playSound(GermanCarInfo[r][3]);
      pause(12);
      photo.pixelate(5);
      drawImage(photo, 0, 0, 400);
      pause(3);
      clear("white");
    }
  }

  /*
  Combines both car scene arrays to draw the full scene
  drawUSCar() and drawEUCar() are interchangable so it could present the EU cars first without any issues
  */
  public void drawScene() {
    drawUSCar();
    drawEUCar();
  }
  
}