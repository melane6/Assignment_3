import java.util.Random;
import java.util.List;

/**
 * A simple model of an Octopus.
 * Octopuses age,move, eat starfish and die.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Octopus extends Animal 
                    implements Predator
{
    // instance variables - replace the example below with your own
    private int foodLevel; //move to predator interface
    private int STARFISH_FOOD_VALUE; //also move to predator interface
    private Random rand= Randomizer.getRandom(); //should have one in animal class?

    /**
     * Constructor for objects of class Octopus
     */
    public Octopus(int randomAge, Field field, Location location,boolean canBreed)
    {
        super(randomAge,field,location,canBreed);
        foodLevel= STARFISH_FOOD_VALUE;
        
    }

    /**
     * This is what the octopus does most of the time: it hunts 
     * for starfish. In the process, it might breed, die of hunger
     * or old age.
     * 
     *
     * @param  newOctopuses  A list to return the new Octopus
     */
    public void act(List<Animal> newOctopuses)
    {
        // whatever the OCTOPUS WOULD DO
        // so eat Starfish, increment Age, move 
        //increment hunger(create a method predator interface)
        super.incrementAge();
    }
}
