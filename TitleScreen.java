import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
class TitleScreen extends TextClass
{
  public static int width;
  public static int height;
  public static String title;
  public static String ch;
  
  public TitleScreen(String nTitle, String nCh)
  {
    width = 150;
    height = 20;
    title=nTitle;
    ch=nCh;
    
  }

  public static void Load()
  {

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics graphics = bufferedImage.getGraphics();
    graphics.setFont(new Font("Serif", Font.PLAIN, 15));
    Graphics2D g2D = (Graphics2D) graphics;
    g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2D.drawString(title, 5, 15);
    for(int i = 0; i < height; i++)
    {
      StringBuilder builder = new StringBuilder();
      for(int x = 0; x < width; x++)
      {
        builder.append(bufferedImage.getRGB(x, i) == -16777216 ? ch : " ");
      }
      System.out.println(ANSI_BOLD + ANSI_FRAME + builder + ANSI_RESET);
    }
    System.out.println("");
  }
}