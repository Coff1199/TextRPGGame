import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;   
class Main
{
  static boolean playagain = true;
  static int atk = 0;
  static int def = 10;
  static int spd = 0;
  static int maxdef = 0;
  static int smite = 1;
  static int gold = 0;
  static int potions = 0;
  static String Class = new String("");
  static boolean hasSkill = false;
  static boolean demonSkill = false;
  static boolean boss2Skill = false;
  public static String manInBlackStatus=new String("neutral");
  static boolean oldManSaved=true;
  static int shi=0;
  public static int luck=0;
  public static final String ANSI_YELLOW = "\u001B[33m"; 
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLINKER = "\u001B[5m";
  public static final String ANSI_FRAME = "\u001B[51m";
  public static final String ANSI_BOLD = "\u001B[1m";
  public static final String ANSI_PURPLE = "\u001B[35m";

  public static int getRandomNumberInRange(int min,int max) 
  {
		if (min >= max) 
    {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

  public static void Die()
  {
    Scanner die = new Scanner(System.in);
    Print p1=new Print("GAME OVER");
    p1.p();
    Print p2=new Print("Do you want to play again?");
    p2.p();
    String playornah = die.next();
    if(playornah.equals("yes") || playornah.equals("Yes"))
    {
      playagain = true;
      
    }
    else
    {
      playagain = false;
    }
  }
  //Type "cc" to find this method
  public static void CharacterChoice(String character)
  {
    String[] ThiefNames = { "Remi", "Rowan", "Amari" };
    int lengththief = ThiefNames.length;
    int randthief = (int) (Math.random() * lengththief);
    String[] SwordsmanNames = { "Leonidas", "Tobin", "Jordan" };
    int lengthswordsman = SwordsmanNames.length;
    int randswordsman = (int) (Math.random() * lengthswordsman);
    String[] SorcererNames = { "Zion", "Auden", "Shay" };
    int lengthsorcerer = SorcererNames.length;
    int randsorcerer = (int) (Math.random() * lengthsorcerer);
    String[] SPLNames = { "Casey", "Arthur", "Ryan" };
    int lengthSPL = SPLNames.length;
    int randSPL = (int) (Math.random() * lengthSPL);
    String name = new String("");
    String thief = new String("Thief");
    String swordsman = new String("Swordsman");
    String sorcerer = new String("Sorcerer");
    String SPL = new String("SPL");
    if(character.equals(thief) || character.equals("thief"))
    {
      atk = 8;
      spd = 7;
      def = 50;
      maxdef = 50;
      Class = "Thief";
      name = ThiefNames[randthief];
      Print p1=new Print("You chose " + name + " the Thief");
      p1.p();
    }
    if(character.equals(swordsman) || character.equals("swordsman"))
    {
      atk = 10;
      spd = 3;
      def = 70;
      maxdef = 70;
      Class = "Swordsman";
      name = SwordsmanNames[randswordsman];
      Print p2=new Print("You chose " + name + " the Swordsman");
      p2.p();
    }
    if(character.equals(sorcerer) || character.equals("Sorcerer"))
    {
      atk = 6;
      spd = 5;
      def = 65;
      maxdef = 65;
      Class = "Sorcerer";
      name = SorcererNames[randsorcerer];
      Print p3=new Print("You chose " + name + " the Sorcerer ");
      p3.p();
    }
    if(character.equals(SPL) || character.equals("spl"))
    {
      atk = 1000;
      spd = 1000;
      def = 1000;
      Class = "SPL";
      name = SPLNames[randSPL];
      Print p4=new Print("You chose " + name + " the Supreme Patrol Leader. ");
      p4.p();
    }
  }

  //Type "destiny" to find this method
  public static void Loot(int droptablenum)
  {
    if(droptablenum == 1)
    {
      switch(getRandomNumberInRange(1,4))
      {
        case 1:
          Print pnl10=new Print("You found ");
          pnl10.pnl("You found ");
          Print pY1=new Print("1 gold");
          pY1.pY("1 gold", true);
          gold++;
          break;
        case 2:
          Print pnl9=new Print("You found ");
          pnl9.pnl("You found ");
          Print pY2=new Print("2 gold");
          pY2.pY("2 gold", true);
          gold++;
          gold++;
          break;
        case 3:
          Print pnl8=new Print("You found ");
          pnl8.pnl("You found ");
          Print pY3=new Print("3 gold");
          pY3.pY("3 gold", true);
          gold++;
          gold++;
          gold++;
          break;
       default:
          break;
      }
    }
    if(droptablenum == 2) //"Lucky" (2x) droptable
    {
      switch(getRandomNumberInRange(1,5))
      {
        case 1:
          Print pnl7=new Print("You found ");
          pnl7.pnl("You found ");
          Print pY4=new Print("2 gold");
          pY4.pY("2 gold", true);
          gold += 2;
          break;
        case 2:
          Print pnl6=new Print("You found ");
          pnl6.pnl("You found ");
          Print pY5=new Print("4 gold");
          pY5.pY("4 gold", true);
          gold += 4;
          break;
        case 3:
          Print pnl5=new Print("You found ");
          pnl5.pnl("You found ");
          Print pY6=new Print("6 gold");
          pY6.pY("6 gold", true);
          gold += 6;
          break;
       default:
          break;
      }
    }
    if(droptablenum == 3) //boss drop table
    {
      switch(getRandomNumberInRange(1,3))
      {
        case 1:
          Print pnl4=new Print("You found ");
          pnl4.pnl("You found ");
          Print pY7=new Print("11 gold");
          pY7.pY("11 gold", true);
          gold += 11;
          break;
        case 2:
          Print pnl3=new Print("You found ");
          pnl3.pnl("You found ");
          Print pY8=new Print("7 gold");
          pY8.pY("7 gold", false);
          Print pnl2=new Print(" and ");
          pnl2.pnl(" and ");
          Print pP1=new Print("1 potion");
          pP1.pP("1 potion", false);
          Print p50=new Print("!");
          p50.p();
          gold += 7;
          potions++;
          break;
        case 3:
          Print pnl1=new Print("You found ");
          pnl1.pnl("You found ");
          Print pP2=new Print("3 potions");
          pP2.pP("3 potions", false);
          Print p51=new Print("!");
          p51.p();
          potions += 3;
          break;
       default:
          break;
      }
    }
  }
  
  public static void monsterencounter(String monsterencountertext, int healthmin, int healthmax, int monsteratk, int monsteratkspdmin, int monsteratkspdmax, int monsterdodgespd, int bonusatk, int bonusenemyatk, int bonusdef, int bonusenemydef, boolean canSmite, int drops)
  {
    Scanner playeraction = new Scanner(System.in);
    if(def > 0)
    {
    Print p1=new Print(monsterencountertext);
    p1.p();
    int hp = getRandomNumberInRange(healthmin, healthmax);
    hp = hp - bonusatk + bonusenemydef;
    def = def - bonusenemyatk + bonusdef;
    boolean dodged = false;
          while(hp > 0)
          {
            dodged = false;
            if(Class.equals("Sorcerer"))
            {
              if(hasSkill == true)
              {
                Print p2=new Print("Do you want to attack, dodge, use magic, or use a skill?");
                p2.p();
              }
              else
              {
                Print p3=new Print("Do you want to attack, dodge, or use magic?");
                p3.p();
              }
            }
            else if(Class.equals("Swordsman"))
            {
              if(hasSkill == true)
              {
                Print p4=new Print("Do you want to attack, dodge, jab, or use a skill?");
                p4.p();
              }
              else
              {
                Print p5=new Print("Do you want to attack, dodge, or jab?");
                p5.p();
              }
            }
            else
            {
              if(hasSkill == true)
              {
                Print p6=new Print("Do you want to attack, dodge, or use a skill?");
                p6.p();
              }
              else
              {
                Print p7=new Print("Do you want to attack or dodge?");
                p7.p();
              }
            }
            String attackordodge = playeraction.next();
            if(attackordodge.equals("attack")||attackordodge.equals("Attack"))
            {
              if(getRandomNumberInRange(0, monsterdodgespd) <= spd)
              {
                hp = hp-atk;
                Print p8=new Print("You attacked the enemy, doing " + atk + " damage.");
                p8.p();
              }
              else
              {
                Print p9=new Print("The enemy dodged your attack!");
                p9.p();
              }
            }
            else if(attackordodge.equals("Dodge") || attackordodge.equals("dodge"))
            {
              if(getRandomNumberInRange(monsteratkspdmin, monsteratkspdmax) <= spd)
              {
                Print p9=new Print("You dodged the enemies attack, and successfully landed a counterattack!");
                p9.p();
                hp = hp-(atk-1);
                dodged = true;
              }
              else
              {
                Print p10=new Print("Your dodge fails, and you ungracefully flop to the ground.");
                p10.p();
                if(getRandomNumberInRange(1,10) <= 5)
                {
                  Print p11=new Print("You manage to injure yourself in the process of dodging.");
                  p11.p();
                  def = def - 3;
                }
              }
            }
            else if(attackordodge.equals("enemyop"))
            {
              Print p12=new Print("The enemy has now been powered up to 1-shot mode.");
              p12.p();
              monsteratk = 1000;
              hp = 1000;
            }
            else if(attackordodge.equals("magic") || attackordodge.equals("Magic"))
            {
              if(Class.equals("Sorcerer") && smite > 0)
              {
                Print p13=new Print("You call upon the heavens and smite your foe.");
                p13.p();
                smite = smite-1;
                hp = 0;
              }
              else{
              Print p14=new Print("You have no idea how to do what your subconcious is telling you, so you stand helplessly while the enemy attacks.");
              p14.p();
              }
            }
            else if(attackordodge.equals("jab") || attackordodge.equals("Jab"))
            {
              if(Class.equals("Swordsman"))
              {
                Print p15=new Print("You jab your foe with the hilt of your hammer");
                p15.p();
                hp = hp - 3;
              }
              else{
              Print p16=new Print("You have no idea how to do what your subconcious is telling you, so you stand helplessly while the enemy attacks.");
              p16.p();
              }
            }
            else if(attackordodge.equals("skill") || attackordodge.equals("Skill"))
            {
              if(hasSkill == true)
              {
                Print p17=new Print("Which skill do you want to use?");
                p17.p();
                if(demonSkill == true)
                {
                  Print p18=new Print("Requiem");
                  p18.p();
                }
                String whichSkill = playeraction.next();
                if(whichSkill.equals("Requiem") || whichSkill.equals("requiem"))
                {
                  Print p19=new Print("You used requiem which summons a beam from the land below and deals " + (atk - 4) + "damage");
                  p19.p();
                  hp -= (atk-4);
                }
              }
              else{
              Print p20=new Print("You have no idea how to do what your subconcious is telling you, so you stand helplessly while the enemy attacks.");
              p20.p();
              }
            }
          if(def <= 0)
          {
            return;
          }
          if(hp>0 && dodged == false)
          {
            if(getRandomNumberInRange(monsteratkspdmin, monsteratkspdmax) <= spd)
            {
              Print p21=new Print("The enemy's attack missed!"); //This is for calculating if monsters land hits
              p21.p();
              if(getRandomNumberInRange(monsteratkspdmin, monsteratkspdmax) <= spd)
              {
                Print p22=new Print("You quickly launch a counter-attack!");
                p22.p();
                hp = hp - (atk-2);
              }
            }
            else
            {
              Print p23=new Print("The enemy hit you for " + monsteratk + " damage.");
              p23.p();
              def = def-monsteratk; //this is where an enemy successfully lands a hit on the player
            }
          }
          if(def <= 0)
          {
            return;
          }
          else
          {
            Print p24=new Print("Your health is at " + def + ", and the enemy's health is at " + hp + ".");
            p24.p();
          }
          }
          if (def>0)
          {
          Print p25=new Print("You won!");
          p25.p();
          }
          Loot(drops);
    }
    else{
      return;
    }
  }


  //dilemma
  public static void  friendorFoeDilemma(String humanencountertext, int healthmin, int healthmax, int humanatk, int humanatkspdmin, int humanatkspdmax, int humandodgespd, /*int bonusatk, int bonusenemyatk, int bonusdef, int bonusenemydef,*/int drops, int humanmoveid)
  {
    int atk2 = atk;
    boolean drainingAttack=false;
    int spd2 = spd;
    boolean humanmoveused=false;
    Scanner playeraction = new Scanner(System.in);
    if(def > 0)
    {
    Print p77=new Print(humanencountertext);
    p77.p();
    Print p111=new Print("You stare at the person before you. There is devilish glint in there eyes as if they had been possesed by someone or something. Can you even call this person a human anymore? A dilemma is presented before you,take a human life and live the rest of your life with sin or try to help them with the potential that you yourself will die trying.Remember,some people just can't be saved.Make your choice.");
    p111.p();
    boolean battleEnd=false;
    int hp = getRandomNumberInRange(healthmin, healthmax);
    //hp = hp - bonusatk + bonusenemydef;
    //def = def - bonusenemyatk + bonusdef;
    boolean dodged = false;
          while(hp > 0||battleEnd!=true)
          {
            if(getRandomNumberInRange(1,5) == 1 && hp > 0)
            {
              if(humanmoveid == 1)
              {
                drainingAttack=true;
                Print p1=new Print("The person bites you again");
                p1.p();
                Print p2=new Print("You can feel your health draining.");
                p2.p();
                def--;
                humanmoveused = true;
              }
              if(humanmoveid == 2)
              {
               drainingAttack=true;
                Print p3=new Print("The person bites you again");
                p3.p();
                Print p4=new Print("You can feel your health draining.");
                p4.p();
                def = def-2;
                humanmoveused = true;
              }
            }
            else
            {
              humanmoveused = false;
            }
            dodged = false;
            Print p5=new Print("Do you want to attack or help?");
            p5.p();
            String attackordodge = playeraction.next();
            if(attackordodge.equals("attack")||attackordodge.equals("Attack"))
            {
              if(getRandomNumberInRange(0, humandodgespd) <= spd2)
              {
                hp = hp-atk2;
                Print p6=new Print("You attacked the enemy, doing " + atk2 + " damage.");
                p6.p();
              }
              else
              {
                Print p7=new Print("The enemy dodged your attack!");
                p7.p();
              }
            }
            else if(attackordodge.equals("Help") || attackordodge.equals("help"))
            {
              if(getRandomNumberInRange(0,25) <= 23)
              {
                Print p8=new Print("You tried but nothing is working.Do you truly believe they can still be saved?");
                p8.p();
                
              }
              else
              {
                Print p9=new Print("The person has stopped. the glare has left their eyes.They seem normal now.\u001B[35mYOU SAVED THEM!");
                p9.p();
                shi=0;
                battleEnd=true;

              }
            }
            else
            {
              Print p11=new Print("You have no idea how to do what your subconcious is telling you, so you stand helplessly while the enemy attacks.");
              p11.p();
              shi=1;
            }
          if(def <= 0)
          {
            return;
          }
          if(hp>0 && dodged == false)
          {
            if(getRandomNumberInRange(humanatkspdmin, humanatkspdmax) <= spd2)
            {
              Print p12=new Print("The enemy's attack missed!"); 
              p12.p();
              if(getRandomNumberInRange(humanatkspdmin, humanatkspdmax) <= spd2)
              {
                Print p13=new Print("You quickly launch a counter-attack!");
                p13.p();
                hp = hp - (atk2-2);
              }
            }
            else
            {
              Print p14=new Print("The enemy hit you for " + humanatk + " damage.");
              p14.p();
              def = def-humanatk; //this is where an enemy successfully lands a hit on the player
            }
          }
          if(def <= 0)
          {
            return;
          }
          else
          {
            Print p15=new Print("Your health is at " + def + ", and the enemy's health is at " + hp + ".");
            p15.p();
            if (drainingAttack==true)
            {
              def--;
            }
            
            if(humanmoveid == 1 && humanmoveused== true)
            {
              Print p16=new Print("The Draining effect is gone");
              p16.p();
              drainingAttack=false;
            }
          }
          }
          if (def>0)
          {
            Print p17=new Print("You won, but at what cost?Is another life that worthless to you?Or do you think that this was the only way you could truly bring them to salvation?Only time will tell.");
            p17.p();

          }
          
    }
    else{
      return;
    }
  }

  public static String EastWest (String ew)
  {
    String weast = new String();
    final String east = new String("east");
    final String west = new String("west");
    final String East = new String("East");
    final String West = new String("West");
    if(ew.equals(east) || ew.equals(East))
    {
      Print p1=new Print("You chose the east path.");
      p1.p();
      weast = east;
    }
    else if(ew.equals(west) || ew.equals(West))
    {
      Print p2=new Print("You chose the west path.");
      p2.p();
      Print p3=new Print("...a gruesome fate awaits...");
      p3.p();
      weast = west;
    }
    else if(ew.equals("North") || ew.equals ("north") || ew.equals("South") || ew.equals("south"))
    {
      Print p4=new Print("You wander off in that direction, feeling proud of your individuality and confidence, which made you quite tasty for the bear that ate you shortly after you left the path. The End.");
      p4.p();
      def=0;
      System.exit(0);
    }
    return weast;
  }


  public static void bossencounter1(String monsterencountertext, int healthmin, int healthmax, int monsteratk, int monsteratkspdmin, int monsteratkspdmax, int monsterdodgespd, /*int bonusatk, int bonusenemyatk, int bonusdef, int bonusenemydef,*/int drops, int bossmoveid)
  {
    int atk2 = atk;
    int spd2 = spd;
    boolean bossmoveused = false;
    Scanner playeraction = new Scanner(System.in);
    if(def > 0)
    {
    Print p77=new Print(monsterencountertext);
    p77.p();
    int hp = getRandomNumberInRange(healthmin, healthmax);
    //hp = hp - bonusatk + bonusenemydef;
    //def = def - bonusenemyatk + bonusdef;
    boolean dodged = false;
          while(hp > 0)
          {
            if(getRandomNumberInRange(1,5) == 1 && hp > 0)
            {
              if(bossmoveid == 1)
              {
                Print p1=new Print("The Demon stomps the ground!");
                p1.p();
                Print p2=new Print("The ground starts to shake, and you lose your footing.");
                p2.p();
                spd2--;
                bossmoveused = true;
              }
              if(bossmoveid == 2)
              {
                Print p3=new Print("The Demon stomps the ground!");
                p3.p();
                Print p4=new Print("The ground starts to shake, and you lose your footing.");
                p4.p();
                spd2--;
                bossmoveused = true;
              }
            }
            else
            {
              bossmoveused = false;
            }
            dodged = false;
            Print p5=new Print("Do you want to attack or dodge?");
            p5.p();
            String attackordodge = playeraction.next();
            if(attackordodge.equals("attack")||attackordodge.equals("Attack"))
            {
              if(getRandomNumberInRange(0, monsterdodgespd) <= spd2)
              {
                hp = hp-atk2;
                Print p6=new Print("You attacked the enemy, doing " + atk2 + " damage.");
                p6.p();
              }
              else
              {
                Print p7=new Print("The enemy dodged your attack!");
                p7.p();
              }
            }
            else if(attackordodge.equals("Dodge") || attackordodge.equals("dodge"))
            {
              if(getRandomNumberInRange(monsteratkspdmin, monsteratkspdmax) <= spd2)
              {
                Print p8=new Print("You dodged the enemies attack, and successfully landed a counterattack!");
                p8.p();
                hp = hp-(atk2-1);
                dodged = true;
              }
              else
              {
                Print p9=new Print("Your dodge fails, and you ungracefully flop to the ground.");
                p9.p();
                if(getRandomNumberInRange(1,10) <= 5)
                {
                  Print p10=new Print("You manage to injure yourself in the process of dodging.");
                  p10.p();
                  def -= 3;
                }
              }
            }
            else
            {
              Print p11=new Print("You have no idea how to do what your subconcious is telling you, so you stand helplessly while the enemy attacks.");
              p11.p();
            }
          if(def <= 0)
          {
            return;
          }
          if(hp>0 && dodged == false)
          {
            if(getRandomNumberInRange(monsteratkspdmin, monsteratkspdmax) <= spd2)
            {
              Print p12=new Print("The enemy's attack missed!"); //This is for calculating if monsters land hits
              p12.p();
              if(getRandomNumberInRange(monsteratkspdmin, monsteratkspdmax) <= spd2)
              {
                Print p13=new Print("You quickly launch a counter-attack!");
                p13.p();
                hp = hp - (atk2-2);
              }
            }
            else
            {
              Print p14=new Print("The enemy hit you for " + monsteratk + " damage.");
              p14.p();
              def = def-monsteratk; //this is where an enemy successfully lands a hit on the player
            }
          }
          if(def <= 0)
          {
            return;
          }
          else
          {
            Print p15=new Print("Your health is at " + def + ", and the enemy's health is at " + hp + ".");
            p15.p();
            if(bossmoveid == 1 && bossmoveused== true)
            {
              Print p16=new Print("You regained your footing.");
              p16.p();
              spd2++;
            }
          }
          }
          if (def>0)
          {
            Print p17=new Print("You won!");
            p17.p();
            if(bossmoveid == 1)
            {
              Print p18=new Print("The demon has been slayed, dropping nothing but ashattered crystal. You pick it up.");
              p18.p();
              Print pY1=new Print("NEW SKILL OBTAINED: Requiem");
              pY1.pY("NEW SKILL OBTAINED: Requiem", true);
              hasSkill = true;
              demonSkill = true;
            }
          }
          Loot(drops);
    }
    else{
      return;
    }
  }

  public static void quickbreak(String pausetext)
  {
    int price1 = getRandomNumberInRange(2, 4);
    int price2 = getRandomNumberInRange(7, 12);
    int price3 = getRandomNumberInRange(7, 12);
    int price4 = getRandomNumberInRange(7, 12);
    Scanner pause = new Scanner(System.in);
    Print p1=new Print(pausetext);
    p1.p();
    Print p2=new Print("Would you like to take a break?");
    p2.p();
    String takebreak = pause.next();
    if(takebreak.equals("Yes")||takebreak.equals("yes"))
    {
      while(0==0)
      {
      Print p3=new Print("Press 1 to check your stats, 2 to check your inventory, 3 to visit the flying merchant, or 4 to end your break.");
      p3.p();
      int pauseoption = pause.nextInt();
      if(pauseoption == 1)
      {
        Print p4=new Print("Class: " + Class);
        p4.p();
        Print p5=new Print("Attack: " + atk);
        p5.p();
        Print p6=new Print("Health: " + def + " / " + maxdef);
        p6.p();
        Print p7=new Print("Speed: " + spd);
        p7.p();
        Print p8=new Print("Press enter to go back");
        p8.p();
        pause.nextLine();
        pause.nextLine();
        continue;
      }
      if(pauseoption == 2)
      {
        Print pnl22=new Print("You have ");
        pnl22.pnl("You have ");
        Print pY1=new Print(" gold");
        pY1.pY(gold + " gold", false);
        Print pnl20=new Print(", and ");
        pnl20.pnl(", and ");
        Print pP1=new Print(" potions.");
        pP1.pP(potions + " potions.", true);
        Print p9=new Print("Do you want to use a potion? (y/n)");
        p9.p();
        String potionuse = pause.next();
        if(potionuse.equals("Y") || potionuse.equals("y") && potions>0)
        {
          int healthregained = getRandomNumberInRange(5, 15);
          if((def + healthregained) <= maxdef)
          {
            Print p10=new Print("You used a potion, and regained " + healthregained + "health. Your health is now at " + def + ".");
            p10.p();
            def = def + healthregained;
            potions--;
          }
          else if((def + healthregained) > maxdef && def != maxdef)
          {
            Print p11=new Print("You used a potion, and regained " + ((healthregained + def) - maxdef) + "health. Your health is now at " + maxdef + ".");
            p11.p();
            def = maxdef;
            potions--;
          }
          else
          {
            Print p12=new Print("Your health is already at the maximum.");
            p12.p();
          }
        }
        else if(potionuse.equals("Y") || potionuse.equals("y") && potions==0)
        {
          Print p13=new Print("You have no potions");
          p13.p();
        }
        Print p14=new Print("Press enter to go back");
        p14.p();
        pause.nextLine();
        pause.nextLine();
        continue;
      }
      if(pauseoption==3)
      {
        boolean keepshopping = true;
        String continueshopping = new String("");
        Print p15=new Print("The flying merchant glides towards you. ");
        p15.p();
        Print p16=new Print("");
        p16.p();
        Print p17=new Print("\tThe prices for today are:");
        p17.p();
        Print p18=new Print("\t" + "\u001B[35m" +"Potions: "+ ANSI_RESET + price1 + " gold");
        p18.p();
        Print p19=new Print("\t" + "\u001B[32m" +"Mercury's Grace: " + ANSI_RESET + price2 + " gold");
        p19.p();
        Print p20=new Print("\t" + "\u001B[34m" + "Vesuvius's Vigilance" + ANSI_RESET + ": " + price3 + " gold");
        p20.p();
        Print p21=new Print("\t" +"\u001B[31m"+"Vulcan's Rage" + ANSI_RESET + ": " + price4 + " gold");
        p21.p();
        Print p22=new Print("");
        p22.p();
        while(keepshopping == true)
        {
        Print p23=new Print("Press 1 to buy a potion, 2 to buy Mercury's Grace, 3 to buy Vesuvius's Vigilance, 4 to buy Vulcan's Rage, or 5 to quit.");
        p23.p();
        int merchantoption = pause.nextInt();
        if(merchantoption == 1)
        {
          if(gold>=price1)
          {
            Print p24=new Print("You bought a potion");
            p24.p();
            gold = gold - price1;
            potions = potions + 1;
          }
          else
          {
            Print p25=new Print("You don't have enough gold for that.");
            p25.p();
          }
          Print p26=new Print("Do you want to continue shopping?");
          p26.p();
          continueshopping = pause.next();
          if(continueshopping.equals("yes"))
          {
            keepshopping = true;
          }
          else
          {
            keepshopping = false;
          }
        }
        else if(merchantoption == 2)
        {
          if(gold>=price2)
          {
            Print p27=new Print("You bought the " + "\u001B[32m" + "Mercury's Grace " + ANSI_RESET + "upgrade! Speed increased by 2.");
            p27.p();
            gold = gold - price2;
            spd = spd + 2;
          }
          else
          {
            Print p28=new Print("You don't have enough gold for that.");
            p28.p();
          }
          Print p29=new Print("Dtxt11o you want to continue shopping");
          p29.p();
          continueshopping = pause.next();
          if(continueshopping.equals("yes"))
          {
            keepshopping = true;
          }
          else
          {
            keepshopping = false;
          }
        }
        else if(merchantoption == 3)
        {
          if(gold>=price3)
          {
            Print p30=new Print("You bought the " + "\u001B[34m" +"Vesuvius's Vigilance " +ANSI_RESET+ "upgrade! Max Health is increased by 30, and you gained 30 health back!");
            p30.p();
            gold = gold - price3;
            maxdef += 30;
            def = def + 30;
          }
          else
          {
            Print p31=new Print("You don't have enough gold for that.");
            p31.p();
          }
          Print p32=new Print("Do you want to continue shopping?");
          p32.p();
          continueshopping = pause.next();
          if(continueshopping.equals("yes"))
          {
            keepshopping = true;
          }
          else
          {
            keepshopping = false;
          }
        }
        else if(merchantoption == 4)
        {
          if(gold>=price4)
          {
            Print p33=new Print("You bought the " + "\u001B[31m" + "Vulcan's Rage " + ANSI_RESET + "upgrade! Attack increased by 3.");
            p33.p();
            gold = gold - price4;
            atk = atk + 3;
          }
          else
          {
            Print p34=new Print("You don't have enough gold for that.");
            p34.p();
          }
          Print p35=new Print("Do you want to continue shopping?");
          p35.p();
          continueshopping = pause.next();
          if(continueshopping.equals("yes"))
          {
            keepshopping = true;
          }
          else
          {
            keepshopping = false;
          }
        }
        else if(merchantoption == 5)
        {
          keepshopping = false;
          continue;
        }
        }
      }
      if(pauseoption==4)
      {
        return;
      }
      }
      }
      }

  public static void EastStoryline1()
  {
    if(def > 0)
    {
    String inv = "investigate";
    String snk = "sneak";
    Scanner es1 = new Scanner(System.in);
    Print pY1=new Print("East Storyline Part 1");
    pY1.pY("East Storyline Part 1", true);
    Print p1=new Print("You have been walking for a while when you finally see a man cloaked completely in black near a small cottage.Do you go investigate, or do you sneak up to them to get a better view? (type investigate, or sneak)");
    p1.p();
    String invsnk = es1.next();
    if(invsnk.equals(inv) || invsnk.equals("Investigate"))
    {
      Print p2=new Print("You decide to go and investigate.");
      p2.p();
      if(getRandomNumberInRange(1,10) <= 5)
      {
        monsterencounter("Oh no! It's a slightly-larger-than-normal Rat!", 7, 10, 3, 3, 10, 5, 0, 0, 0, 0, true, 1);
      } 
        else
        {
          Print p3=new Print("The figure in black stands there and points to a bowl of food on a table inside the cottage. He waits there as if he expects you to say something.");
          p3.p();
          boolean magicwordsaid = false;
          while(magicwordsaid == false)
          {
            String magicword = es1.next();
            if(magicword.equals("please") || magicword.equals("Please"))
            {
              Print p4=new Print("The figure in black seems pleased and lets you have the food and water. Then you prepare to depart. Who or what was this figure? you ask yourself.");
              p4.p();
              manInBlackStatus="friend";
              magicwordsaid = true;
            }
            else if(magicword.equals("alakazam") || magicword.equals("Alakazam"))
            {
              Print p5=new Print("The figure in black jumps at you and knocks you out.When you awake you are outside somewhere with no food or water. You decide to continue, just don't forget:PEOPLE MAY TURN AGAINST YOU FOR DECISIONS YOU MAKE.");
              p5.p();
              manInBlackStatus="foe";
              magicwordsaid = true;
            }
            else
            {
              Print p6=new Print("Hint: a word you use to ask someone for something politley(or you could say alakazam, zap this figure and go if you want.");
              p6.p();
            }
          }
        }
    }
    if(invsnk.equals(snk) || invsnk.equals("Sneak"))
    {
      Print p7=new Print("You decide to play it safe and sneak around until you can better view.");
      p7.p();
      int snkenc = (int)(Math.random()*10);
      if(snkenc <= spd)
      {
        Print p8=new Print("You sneak up to the cottage unnoticed. You then steal the food off the table without the black figure seeing you.");
        p8.p();
        manInBlackStatus="neutral";
      }
      else
      {
        String minustwohealth = new String("-2 health");
        Print p9=new Print("You try to sneak up to the cottage, but you trip and break your knee. " + minustwohealth);
        p9.p();
        def = def-2;
        Print p10=new Print("Despite the pain, you manage to limp over to the cottage. You then steal the food off the table without the black figure seeing you.");
        p10.p();
        manInBlackStatus="neutral";
      }
      if(getRandomNumberInRange(1,10)<=5)
      {
        if(snkenc <= spd)
        {
          monsterencounter("Oh no! It's a slightly-larger-than-normal Rat! However, you take it by surprise and deal some extra damage.", 7, 10, 3, 3, 10, 5, 3, 0, 0, 0, true, 1);
        }
        else
        {
          monsterencounter("Oh no! It's a slightly-larger-than-normal Rat!", 7, 10, 3, 3, 10, 5, 0, 0, 0, 0, true, 1);
        }
      }
      else
      {
        Print p11=new Print("The figure in black stands there and points to a bowl of food on a table inside the cottage. He waits there as if he expects you to say something.");
        p11.p();
        boolean magicwordsaid = false;
        while(magicwordsaid == false)
        {
          String magicword = es1.next();
          if(magicword.equals("please") || magicword.equals("Please"))
          {
            Print p12=new Print("The figure in black seems pleased and lets you have the food and water. Then you prepare to depart. Who or what was this figure? you ask yourself.");
            p12.p();
            manInBlackStatus="friend";
            magicwordsaid = true;
          }
          else if(magicword.equals("alakazam") || magicword.equals("Alakazam"))
          {
            Print p13=new Print("The figure in black jumps at you and knocks you out.When you awake you are outside somewhere with no food or water. You decide to continue, just don't forget:PEOPLE MAY TURN AGAINST YOU FOR DECISIONS YOU MAKE.");
            p13.p();
            manInBlackStatus="foe";
            magicwordsaid = true;
          }
          else
          {
            Print p14=new Print("Hint: a word you use to ask someone for something politley(or you could say alakazam, zap this figure and go if you want.");
            p14.p();
          }
        }
      }
    }
    if(invsnk.equals("rats"))
    {
      monsterencounter("Oh no! It's a slightly-larger-than-normal Rat!", 7, 10, 3, 3, 10, 5, 0, 0, 0, 0, true, 1);
    }
    if(invsnk.equals("friendly"))
    {
      Print p15=new Print("The figure in black stands there and points to a bowl of food on a table inside the cottage. He waits there as if he expects you to say something.");
      p15.p();
        boolean magicwordsaid = false;
        while(magicwordsaid == false)
        {
          String magicword = es1.next();
          if(magicword.equals("please") || magicword.equals("Please"))
          {
            Print p16=new Print("The figure in black seems pleased and lets you have the food and water. Then you prepare to depart. Who or what was this figure? you ask yourself.");
            p16.p();
            manInBlackStatus="friend";
            magicwordsaid = true;
          }
          else if(magicword.equals("alakazam") || magicword.equals("Alakazam"))
          {
            Print p17=new Print("The figure in black jumps at you and knocks you out.When you awake you are outside somewhere with no food or water. You decide to continue, just don't forget:PEOPLE MAY TURN AGAINST YOU FOR DECISIONS YOU MAKE.");
            p17.p();
            manInBlackStatus="foe";
            magicwordsaid = true;
          }
          else
          {
            Print p18=new Print("Hint: a word you use to ask someone for something politley(or you could say alakazam, zap this figure and go if you want.");
            p18.p();
          }
        }
    }
    if (def>0)
    {
    Print p19=new Print("You head forward on your journey to recover your memories.");
    p19.p();
    }
  }
  else
  {
    return;
  }
  }
  public static void EastStoryline2()
  {
    Scanner es2 = new Scanner(System.in);
    if(def>0)
    {
    Print pY1=new Print("East Storyline Part 2");
    pY1.pY("East Storyline Part 2", true);
    Print p1=new Print("You keep walking for miles and miles until you finally reach an area near a volcano.");
    p1.p();
    Print p2=new Print("Before you can get closer however, a gaint Demon appeared and began summoning Skeletons. Do you wait or jump to avoid the incoming attacks?");
    p2.p();
    String waitorjump = es2.next();
    if(waitorjump.equals("wait") || waitorjump.equals("Wait"))
    {
      Print p3=new Print("You wait, hoping for some divine intervention.");
      p3.p();
      if(Class.equals("Sorcerer"))
      {
        Print p4=new Print("Your prayers are answered, and at the last second you're beamed a bit away from all the monsters.");
        p4.p();
      }
      else
      {
      Print p5=new Print("...but the gods don't deem you holy, and you're promptly crushed.");
      p5.p();
      def = 0;
      return;
      //Die();
      }
    }
    else if(waitorjump.equals("jump") || waitorjump.equals("Jump"))
    {
      Print p6=new Print("You jump to the side and barely avoid a few attacks ");
      p6.p();
      if(spd >= 4)
      {
        Print p7=new Print("You switfly dodge more incoming attacks ");
        p7.p();
      }
      else
      {
        Print p8=new Print("You get hit by one of the Skeletons.-3 health.");
        p8.p();
        def = def-3;
        if(def<=0)
        {
          return;
        }
      }
    }
    else
    {
      Print p9=new Print("Frozen in fear, you don't do anything.");
      p9.p();
      //Die();
      def = 0;
    }
    if(def<=0)
    {
     return;
    }
    int luckydrop = getRandomNumberInRange(1,2);
    monsterencounter("A skeleton runs towards you!", 10, 15, 5, 4, 11, 3, 0, 0, 0, 0, true, luckydrop);
    if(def<=0)
    {
      return;
    }
    int luckydrop2 = getRandomNumberInRange(1,2);
    monsterencounter("As you start making your way towards the volcano, another skeleton jumps you!", 10, 15, 5, 4, 11, 3, 0, 0, 0, 0, true, luckydrop2);
    if(def<=0)
    {
      return;
    }
    bossencounter1("Suddenly, you hear a piercing screch of impending death. It is the demon!", 20, 25, 8, 6, 12, 3, 3, 1);
    if(def<=0)
    {
      return;
    }
    Print p10=new Print("Do you want to test out your new skill?");
    p10.p();
    String testskill = es2.next();
    if(testskill.equals("yes")||testskill.equals("Yes"))
    {
      
      Print p100=new Print("You decide to test out your new skill on a nearby training dummy!");
      p100.p();
      Print pY101=new Print("Attack Damage: "+(atk-4));
      pY101.pY("attack Damage: "+(atk-4),true);
      Print p110=new Print("Description: This attack calls out a beam of energy from somehwere. Where does it come from? I'm afraid I can't tell you as of now");
      p110.p();
      
    }
    
    Print p11=new Print("You did it!");
    p11.p();
    Print p12=new Print("You start to journey forward once again");
    p12.p();
  }
  else
  {
    return;
  }
  }
  public static void EastStoryline3()
  {
    Scanner es3 = new Scanner(System.in);
    if(def>0)
    {
      
      Print pY1=new Print("East Storyline Part 3");
      pY1.pY("East Storyline Part 3", true);
      Print p1=new Print("You finally arrived in the first village you've seen since you awoke.What you expected was a happy, lively, and fun village full of wonders.Instead, as you got closer and realized the village was very run down.No one was to be seen in te streets. You called out but no one answered. You walk down the street slowly to the only house that doesn't look like it's been abandoned. You call out once more. Then you see a window slam shut on the buildings second story.");
      p1.p();
      monsterencounter("You are attacked by a small biird with all black feathers!", 7, 10, 3, 3, 10, 5, 0, 0, 0, 0, true, 1);
      Print p2=new Print("You enter the building slowly where you find a senile old man laying on the floor in one of the rooms on the second story. You ponder what could've happened before you came here.What do you do? Offer the man a hand?(y/n)");
      p2.p();
      String helpyesorno=es3.next();
      if (helpyesorno.equals("y"))
      {
        Print p106=new Print("You decide to help the poor old man out of good will. You give him some of your water.The old man nods as a sign o thanks.You ask him why he does nt speak.He opens his mouth to reveal a tongue that has been completely cut off.It seems as if you had just avoided something terrible.");
        p106.p();
        Print p112=new Print("The old man waves his hand to tell you to follow him to a small pond behind the village.He then pulls out two fishing rods, and you realize how lonely he must be with no one else around.");
        p112.p();
        monsterencounter("You are attacked by a fish jumping out of the water!", 7, 10, 3, 3, 10, 5, 0, 0, 0, 0, true, 1);
        Print p113=new Print("You continue your Journey");
        p113.p();
        
      }
      else
      {
        Print p105=new Print("Have you no shame at all?");
        p105.p();
        friendorFoeDilemma("The old man jumps up and bites you on the neck, your draw your weaponry", 60, 80, 2, 0, 3, 2, 3, 1);
        
        if (shi==0)
        {
          Print p107=new Print("You haved saved him!!!You contnue your journey with your newly aquired fishing rods.");
          p107.p();
          luck++;
          oldManSaved=true;
        }
        else
        {
          Print p108=new Print("The old man is dead.But is death truly the end?You continue your journey on with your newly aquired fishing rods.");
          p108.p();
          luck--;
          oldManSaved=false;
        }

      }
    }
    else
    {
      return;
    }
  }


  

  //main
  public static void main(String[] args) 
  {
    Scanner keyboard = new Scanner(System.in);
    TitleScreen ts1=new TitleScreen("idk what name", "_");
    ts1.Load();
    while(playagain==true)
    {
      boolean correctName = false;
      String character = new String();
      while(correctName == false)
      {
        Print p1=new Print("Pick a character: Thief, Swordsman, or Sorcerer");
        p1.p();
        character = keyboard.next();
        if(character.equals("Thief")||character.equals("Swordsman")||character.equals("Sorcerer")||character.equals("thief")||character.equals("swordsman")||character.equals("sorcerer")){
          correctName = true;
        }
      }
      CharacterChoice(character);
      Print p2=new Print("Do you want to read the rules?");
      p2.p();
      String rules = keyboard.next();
      if(rules.equals("yes") || rules.equals("Yes"))
      {
        Print p3=new Print("");
        p3.p();
        Print p4=new Print("BATTLES");
        p4.p();
        Print p5=new Print("");
        p5.p();
        Print p6=new Print("During battle, you may attack, dodge, or use a skill. If you are a sorcerer, you may also use magic. Dodging gives you a chance to avoid the enemies attack, and also deal damage, depending on your speed. Entering anything other than these options will result in skipping your turn. Magic will instantly kill the enemy. You can only use magic once throughout the entire game, and you can't use it on bosses. You unlock skills by killing bosses, but you can't use skills against bosses.");
        p6.p();
        Print p7=new Print("");
        p7.p();
      }
      Print p8=new Print("You wake on the edge of a cliff.Your fingers all scraped up.You have no idea how they got this way or where the scar on your left cheek came from.How did you get here? You do not know, nor do you seem to remember.Who are you?Why are you here?Fear not for all shall be revealed to thee.You may Travel east or west from here, make your decision.");
      p8.p();
      String ew1 = keyboard.next();
      String ew = EastWest(ew1);
      if(ew.equals("east"))
      {
        while(true)
        {
        EastStoryline1();
        if(def<=0){return;}
        quickbreak("You drop your weapons and lie down");
        EastStoryline2();
        if(def<=0){return;}
        quickbreak("Now that you've had a chance to catch your breath, you lie down.");
        EastStoryline3();
        Fishing fishy=new Fishing(4,luck);
        fishy.getFish();
        if(def>0)
        {
        Print p9=new Print("This is the end of this tale, for now.");
        p9.p();
        }
        break;
        }
      }
      else if(ew.equals("west"))
      {
        Print p10=new Print("Did you really think there was another path? Folish mortal I pity thee. To end your quest so prematurely seems almost foolish. But alas, you made the wrong choice.You didn't vene relearn your name or who I am.Farewell, until the next life.");
        p10.p();
      }
      else
      {
        Print p11=new Print("You took too long to respond. For this you must recieve divine punishment. Never to truly know a thing.Farewall once again.");
        p11.p();
      }
      Die();
    }
  }
}

