import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MyCat is your own cat. Get it to do things by writing code in its act method.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyCat extends Cat
{
    /**
     * Act - do whatever the MyCat wants to do.
     */
    public void act()
    {
        // pace(5);
        //why do the two walkLeft method calls have numberSteps?
        //DOY: **must backtrack** => but the walkRight method call has   2 * numberSteps ( * is the symbol for multiplication)
        checkForKeyPress();
        checkForPizza();
    }   

    public void orderOutForPizza()
    {
        World myWorldAssistant = getWorld(); // need a world object to call world methods

        int worldWidth = myWorldAssistant.getWidth();
        int worldHeight = myWorldAssistant.getHeight();
        myWorldAssistant.addObject( new Pizza(), 
            Greenfoot.getRandomNumber(worldWidth),
            Greenfoot.getRandomNumber(worldHeight));
    }

    public void pace(int numberSteps)
    {

    }

    public void checkForPizza()
    {
        if ( isTouching(Pizza.class) )
        {
            removeTouching(Pizza.class);
            eat();
            orderOutForPizza();

        }
    }

    public void jumpUpAndDown()
    {
        int amount = getImage().getHeight();    // height of the jump is 1/2 height of cat image height
        setLocation(getX(),getY() - amount);
        checkForPizza();
        wait(10);
        setLocation(getX(),getY() + amount);
    }

    public void checkForKeyPress() // NOTE if key is held down the action continues for left and right arrow keys
    {
        if ( Greenfoot.isKeyDown("left") ) 
        {
            walkLeft(2);
        }
        if ( Greenfoot.isKeyDown("right") ) 
        {
            walkRight(2);
        }
        if ( Greenfoot.isKeyDown("up")) 
        {
            jumpUpAndDown();
        }
    }

}
