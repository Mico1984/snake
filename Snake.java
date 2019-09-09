import ou.*;
import java.util.*;
/**
 * partial class Snake - TMA02 Q1.
 * 
 * @author (M250 module team) 
 * @version (1.0)
 */
public class Snake
{
   private Circle head; // provided
   //Added instance variables
   private Circle body;
   private Circle tail;
   private  int xPos;
   private  int yPos;
   private OUColour colour;
   private Random r;
   private int HomeXPos;
   private int HomeYPos;
  
   /**
    * Constructor for objects of class Snake
    */
   public Snake(int startX, int startY, Circle aHead, Circle aBody, Circle aTail)
   {
      // initialise instance variables
      head = aHead; // provided
      head.setXPos(startX); // provided
      head.setYPos(startY); // provided
      head.setDiameter(10); // provided
      //Added initialisation
      head.setColour(OUColour.RED);
      body = aBody;
      body.setXPos(startX);
      body.setYPos(startY);
      body.setDiameter(8);
      body.setColour(OUColour.RED);
      tail = aTail;
      tail.setXPos(startX);
      tail.setYPos(startY);
      tail.setDiameter(6);
      tail.setColour(OUColour.RED);
      colour = OUColour.RED;
      xPos = startX;
      yPos = startY;
     startX = 20;
     startY = 20;
     Random r = new Random();
     HomeXPos = 125;
     HomeYPos = 175;
   }
     /*Instance methods*/
   /**
    * sets the colour of head, body and tail all to the argument colour.
    */
  public void setColour(OUColour colour)
   { 
      head.setColour(colour); // provided
      body.setColour(colour);
      tail.setColour(colour);
      colour = OUColour.RED;
}
/**
 * heper method to return  the colour 
 */
public OUColour getColour ()
{
   return colour;
}
  /**
   * Sets the xPos of the receiver to the value of the argument.
   */
   private void setXpos(int newPos)
   {
      xPos = newPos;
   }
      
   /**
    * helper method to return x position of head
    */
   private int getHeadXPos() // provided
   {
      return head.getXPos();
   }
   /**
    * Sets the yPos of the receiver to the value of the argument.
    */
   private void setYPos(int newPos)
   {
     yPos = newPos;
   }
   /**
   * helper method to return y position of head
   */
   private int getHeadYPos()
   {
   return head.getYPos();
   }
   /**
    * helper method to return x position of body
    */
   private int getBodyXPos()
   {
      return body.getXPos();
   }
   /**
    * helper method to return y position of the body
    */
   private int getBodyYPos()
   {
      return body.getYPos();
      }
  
   /**
    * provided
    * return true if the argument represents a valid x-position for a head
    */
   private boolean checkX(int anXPos) // check room to make move
   {
      if ((anXPos >= 0) && (anXPos <= (250 - head.getDiameter()))) // constants only happen in Unit 7
      {
         return true;
      }
      else
      {
         return false;
      }
      //alternative one-line version
      // return ((anXPos >= 0) && (anXPos <= (250 - head.getDiameter())));
   }
/**
 * return true if the argument represents a valid y-position for a head
 */
private boolean checkY(int anYPos)
{
   if ((anYPos >=0) && (anYPos <= (350 - head.getDiameter())))
   {
      return true;
   }
   else
   {
      return false;
   }
}
   /**
    * provided, but won't compile til earlier parts are completed.
    * once you have completed the methods you are asked to write in
    * parts c and d you can uncomment the body of the method.
    * 
    * if the new position is valid, move the snake so that its head is in the given position
    * move the body to where the head was, and the tail to where the body was.
    * Delay after each move.
    * otherwise
    * leave position unchanged
    * output appropriate message
    */
   private void moveTo(int newHeadX, int newHeadY) // provided
   {
      int oldHeadX = getHeadXPos(); 
      int oldHeadY = getHeadYPos();
      int oldBodyX = getBodyXPos();
      int oldBodyY = getBodyYPos();
      if (checkX(newHeadX) && checkY(newHeadY))
      {
       head.setXPos(newHeadX);
       head.setYPos(newHeadY);
       delay(100);
       body.setXPos(oldHeadX);
       body.setYPos(oldHeadY);
       delay(100);            
       tail.setXPos(oldBodyX);
       tail.setYPos(oldBodyY);
       delay(100);            
      }
       else
      {
         System.out.println("Snake cannot cross boundary!");
      }      
   }
   /**
    * This method calculate the new position of the head, 
    * one head diameter to the right of where it currently is,
    * and then move the snake to that position if possible.
    */  
   public void right() 
     {
     int newHeadX = getHeadXPos() + head.getDiameter();
     int newHeadY = getHeadYPos();
     int oldHeadX = getHeadXPos();
     int oldHeadY = getHeadYPos();
     int oldBodyX = getHeadXPos() - body.getDiameter();
     int oldBodyY = getHeadYPos();
     
     if (checkX(newHeadX) && checkY(newHeadY))
      {
       head.setXPos(newHeadX);
       head.setYPos(newHeadY);
       delay(100);
       body.setXPos(oldHeadX);
       body.setYPos(oldHeadY);
       delay(100);            
       tail.setXPos(oldBodyX);
       tail.setYPos(oldBodyY);
       delay(100);            
      }
       else
      {
         System.out.println("Snake cannot cross boundary!");
   }
}
/**
    * This method calculate the new position of the head, 
    * one head diameter to the left of where it currently is,
    * and then move the snake to that position if possible.
    */  
   public void left()
   {
      int newHeadX = getHeadXPos() - head.getDiameter();
      int newHeadY = getHeadYPos();
      int oldHeadX = getHeadXPos();
      int oldHeadY = getHeadYPos();
      int oldBodyX = getHeadXPos() + body.getDiameter();
      int oldBodyY = getHeadYPos(); 
      
       if (checkX(newHeadX) && checkY(newHeadY))
      {
       head.setXPos(newHeadX);
       head.setYPos(newHeadY);
       delay(100);
       body.setXPos(oldHeadX);
       body.setYPos(oldHeadY);
       delay(100);            
       tail.setXPos(oldBodyX);
       tail.setYPos(oldBodyY);
       delay(100);            
      }
       else
      {
         System.out.println("Snake cannot cross boundary!");
   }
  }
  /**
    * This method calculate the new position of the head, 
    * one head diameter to the up of where it currently is,
    * and then move the snake to that position if possible.
    */  
     public void up()
     {
        int newHeadX = getHeadXPos();
        int newHeadY = getHeadYPos() - head.getDiameter();
        int oldHeadX = getHeadXPos();
        int oldHeadY = getHeadYPos();
        int oldBodyX = getHeadXPos();
        int oldBodyY = getHeadYPos() + body.getDiameter();
       if (checkX(newHeadX) && checkY(newHeadY))
      {
       head.setXPos(newHeadX);
       head.setYPos(newHeadY);
       delay(100);
       body.setXPos(oldHeadX);
       body.setYPos(oldHeadY);
       delay(100);            
       tail.setXPos(oldBodyX);
       tail.setYPos(oldBodyY);
       delay(100);            
      }
       else
      {
         System.out.println("Snake cannot cross boundary!");
   }
  }
  /**
    * This method calculate the new position of the head, 
    * one head diameter to the down of where it currently is,
    * and then move the snake to that position if possible.
    */  
   public void down()
   {
   int newHeadX = getHeadXPos();
   int newHeadY = getHeadYPos() + head.getDiameter();
   int oldHeadX = getHeadXPos();
   int oldHeadY = getHeadYPos();
   int oldBodyX = getHeadXPos();
   int oldBodyY = getHeadYPos() - body.getDiameter();
   
   if (checkX(newHeadX) && checkY(newHeadY))
      {
       head.setXPos(newHeadX);
       head.setYPos(newHeadY);
       delay(100);
       body.setXPos(oldHeadX);
       body.setYPos(oldHeadY);
       delay(100);            
       tail.setXPos(oldBodyX);
       tail.setYPos(oldBodyY);
       delay(100);            
      }
       else
      {
         System.out.println("Snake cannot cross boundary!");
   }
  }

   /**
    * provided
    * Causes execution to pause by time number of milliseconds
    * You can use this method without needing to understand how it works
    */
   public void delay(int time)
   {
      try
      {
         Thread.sleep(time); 
      }
      catch (Exception e)
      {
         System.out.println(e);
      } 
   }

   /**
    * provided
    * return a random integer between 1 and 4 inclusive
    * You can use this method without needing to understand how it works
    */
   public int randomInteger() 
   {
      java.util.Random r = new java.util.Random();
      return r.nextInt(4) + 1;
   }
  /**
   * This method makes the snake move 100 random steps, 
   * each of which is randomly right, left, up or down
   *  At each step randomInteger() is used to get an integer from 1 to 4 
   */
   public void randomWalk()
 {
  int i = 0;

  while (i <100)
   {
    i++;
   int randomNumber = randomInteger();
   if (randomNumber == 1)
   
    {
       right();
      }
      else if (randomNumber ==2)
      {
         left();
      }
      else if (randomNumber ==3)
      {
         up();
      }
      else if (randomNumber ==4)
      {
         down();
      }
   } 
 
}
/**
 * This method moves the snake horizontally
 * one step at a time until the x position of the head is within one head diameter of 125,
 * and then vertically one step at a time until the y position of the head is within one
 * head diameter of 175.
 */
public void home()
{
   int homeXPos = 125;
  int  homeYPos = 175;
 while((getHeadXPos() > 125)|| (getHeadXPos() < 125) && (getHeadYPos() > 175) || (getHeadYPos() < 175))
      if (getHeadXPos() > 125 + head.getDiameter())
   {
      left();
   }
   else if (getHeadXPos() < 125 - head.getDiameter())
   {
      right(); 
   }
   else if (getHeadXPos() == 125 - head.getDiameter())
   {
      head.setXPos(homeXPos);
   }
   else if(getHeadYPos() > 175 - head.getDiameter())
   {
      up();
   }
   else if (getHeadYPos() < 175 - head.getDiameter())
   {
      down();   
   }
   else if (getHeadYPos() == 175 - head.getDiameter())
   {
     head.setYPos(homeYPos);
   }
}
}







      
 
   
   
      
  

