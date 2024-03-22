import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
public class Fishing
{

  static int fishNums;
  static int luck;

  public Fishing(int numOfFish,int lucks)
  {
    fishNums=numOfFish;
    luck=lucks;
  } 

  public static void getFish()
  {
    Fish f1=new Fish(fishNums,luck);
    Print p1=new Print("You decide to go fishing for a while to get "+fishNums + " fish for dinner");
    p1.p();
    f1.goFishing();
  }

  

}