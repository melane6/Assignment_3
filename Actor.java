
/**
 * Abstract class Actor - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
interface Actor
{
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    // The actor's activenesss 
    private boolean active;
    //
    private boolean canBreed;
    
        public Actor(Field field, Location location,boolean canBreed) {
            this.field = field;
            this.active= true;
            this.canBreed= canBreed;
            setLocation(location);
        }
        
        /**
         * Indicate that the animal is no longer alive.
         * It is removed from the field.
         */
        protected void setDead()
        {
            active = false;
            if(location != null) {
                field.clear(location);
                location = null;
                field = null;
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
        
        /**
         * Returns if the animal can breed
         * @return true if animal breed otherwise return false
         */
        protected boolean canBreed()
        {
            return canBreed;
        }
        
}
