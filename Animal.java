import java.util.List;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public abstract class Animal implements Actor
{
    // The Animal's age.
    private boolean alive;
    private int age;
    //The animal's breeding age
    private int breedingAge; 
    // The maximum age of the animal can live up to
    private int MAX_AGE;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    // The actor's activenesss 
    //

    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(int age, Field field, Location location, boolean canBreed)
    {
        // Whether the animal is alive or not.
        this.field = field;
        alive = true;
        age=0;
        setLocation(location);
    }
    
    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    abstract public void act(List<Animal> newAnimals);

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    /**
     * Return the animal's age.
     * @return The animal's age.
     */
    protected int getAge()
    {
        return age;
    }
    
    /**
     * Set the animal's age.
     * @param The animal's age.
     */
    protected void setAge(int animalAge)
    {
        age = animalAge;
    }
    
    /**
     * Returns if the animal can breed
     * @return true if animal breed otherwise return false
     */
    protected boolean canBreed()
    {
        return age>=breedingAge;
    }
    
    /**
     *Increace the animal's age
     *This should result in the animal's death
     */
    protected void incrementAge()
    {
      age++;
        if(age > MAX_AGE) {
            setDead();
        }  
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }

    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
}
