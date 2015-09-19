package Project1;

/**
 * This class models a simple Collision object used later in CollisionList to process data.
 */
public class Collision implements Comparable<Collision>{
    private int zipCode;
    private int cyclistsHurt;
    private int injuryAndFatalities;
    private String vehicleType;


    public Collision(int zipcode, int cyclists, int injuryAndFatalities, String vehicle){
        this.zipCode = zipcode;
        this.cyclistsHurt = cyclists;
        this.vehicleType = vehicle;
        this.injuryAndFatalities = injuryAndFatalities;
    }


    /**
     * Returns the number of injuries and fatalities.
     * @return
     */
    public int getInjuryAndFatalities(){
        return injuryAndFatalities;
    }


    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * Compares to another Collision as to whether or not the number of injuries is greater or less.
     */
    @Override
    public int compareTo(Collision c){
        return Integer.compare(injuryAndFatalities, c.getInjuryAndFatalities());
    }

    /**
     * Returns the vehicle types associated with the accident.
     * @return
     */
    public String getVehicleType(){
        return vehicleType;
    }

    /**
     * Returns the zip code associated with the accident.
     * @return
     */
    public int getZipCode(){
        return zipCode;
    }

    /**
     * Returns the number of cyclists injured or fatally injured.
     * @return
     */
    public int getCyclistsInjured(){
        return cyclistsHurt;
    }



}
