import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

  /*
  US and German Car arrays
  Each array has 3 rows, each row is a different car
  1st cloumn has the year, make, model, and trim of the car
  2nd column has the horsepower (as a string)
  3rd column has the String for corresponding image file for the car
  4th column has the String for corresponding audio file for the car
  Each row has a car from a unique Manufacturer and the arrays are split between American and German Manufacturers
  */
  String[][] USCars = {{"2023 Dodge Demon 170", "1025", "Demon.jpg", "Demonaudio.wav"},
                       {"2025 Ford Mustang GTD", "815", "GTD.jpg", "GTDaudio.wav"},
                       {"2013 Chevrolet Corvette Z06", "505", "C6.jpg", "C6audio.wav"}};
    
  String[][] EUCars = {{"2025 BMW M4 Competition", "503", "M4COMP.jpg", "M4audio.wav"},
                       {"2025 Porsche 911 GT3RS", "518", "911GT3RS.jpg", "GT3RSaudio.wav"},
                       {"2024 Mercedes-Benz AMG GT63S", "630", "GT63S.jpg", "GT63Saudio.wav"}};

  // Instantiate the MyStory object Car and use the parameterized constructor to 
  MyStory Car = new MyStory(USCars, EUCars);


  // Call the draw scene method
  Car.drawScene();

  // Play the scene using theater class
  Theater.playScenes(Car);

    
  }
}