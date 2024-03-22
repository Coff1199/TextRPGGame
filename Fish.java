import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
public class Fish extends Fishing
{

  public static String  fish;
  String fishTypes[]={"Grouper","Bass","Minnoh","Salmon","Tuna","Codfish","Sardine","Angel Fish","Swordfish","Cat Fish","Puffer Fish"};

  public Fish(int numOfFish,int lucks)
  {
    super(numOfFish,lucks);
  }

  public void goFishing()
  {
    while (fishNums!=0)
    {
      Random random=new Random();
      int rand=random.nextInt(10);
      fish=fishTypes[rand];
      Print p2=new Print("You caught a "+fish);
      p2.p();
      fishNums--;
    }
  }

}