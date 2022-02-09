import java.util.List;
import java.util.Random;

/**
 * A model of a seahorse.
 * Seahorse age, move, breed, and die, as they are preys.
 * 
 * @author David J. Barnes and Michael Kölling, edited by...
 * @version 2016.03.18 / 2022.03.02
 */
public class Seahorse extends Animal implements Prey
{
    // The age at which a seahorse can start to breed.
    private static final int BREEDING_AGE = 3;
    // The age to which a seahorse can live.
    private static final int MAX_AGE = 6;
    // The likelihood of a seahorse breeding.
    private static final double BREEDING_PROBABILITY = 0.15;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 3;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    // Individual characteristics (instance fields).
    
    // The seahorse's age.
    private int age;

    /**
     * Create a new seahorse. A seahorse may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the seahorse will have a random age.
     * @param The initial age of the seahorse (set to zero in Animal class).
     * @param field The field currently occupied.
     * @param location The location within the field.
     * @param canBreed determines whether an animal can breed or not.
     */
    public Seahorse(boolean randomAge, int age, Field field, Location location, boolean canBreed)
    {
        super(age, field, location, canBreed);
        if(randomAge) {
            age = rand.nextInt(MAX_AGE);
        }
    }
    
    /**
     * This is what the seahorse does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newSeahorses A list to return newly born seahorses.
     */
    public void act(List<Animal> newSeahorses)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newSeahorses);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    /**
     * Check whether or not this rabbit is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newRabbits A list to return newly born rabbits.
     */
    private void giveBirth(List<Animal> newSeahorses)
    {
        // New seahorses are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Seahorse young = new Seahorse(false, 0, field, loc, false);
            newSeahorses.add(young);
        }
    }
        
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }
}

