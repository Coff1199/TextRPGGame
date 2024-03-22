import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
class Print extends TextClass
{
  
  public static String x;

  public Print(String xy)
  {
    x=xy;
  }

  public static void p()
  {
    for(int i = 0; i < x.length(); i++)
    {
      try
      {
        Thread.sleep(20);
        System.out.print(x.charAt(i));
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
    }
    System.out.println("");
    try
      {
        Thread.sleep(900);
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
  }
  public static void pnl(String xz)
  {
    for(int i = 0; i < xz.length(); i++)
    {
      try
      {
        Thread.sleep(20);
        System.out.print(xz.charAt(i));
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
    }
    try
      {
        Thread.sleep(900);
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
  }
  public static void pY(String xy, boolean skipline)
  {
    for(int i = 0; i < xy.length(); i++)
    {
      try
      {
        Thread.sleep(20);
        System.out.print(ANSI_YELLOW + ANSI_BOLD + xy.charAt(i) + ANSI_RESET);
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
    }
    if(skipline == true)
    {
      System.out.println("");
    }
    try
      {
        Thread.sleep(900);
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
  }
  public static void pP(String xy, boolean skipline)
  {
    for(int i = 0; i < xy.length(); i++)
    {
      try
      {
        Thread.sleep(20);
        System.out.print(ANSI_PURPLE + ANSI_BOLD + xy.charAt(i) + ANSI_RESET);
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
    }
    if(skipline == true)
    {
      System.out.println("");
    }
    try
    {
      Thread.sleep(900);
    }
      catch(InterruptedException ex)
      {
       Thread.currentThread().interrupt();
      }
  }  
}