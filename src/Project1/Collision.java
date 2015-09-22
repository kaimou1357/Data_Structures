package Project1;

/**
 * This class models a simple Collision object used later in CollisionList to process data.
 */
public class Collision implements Comparable<Collision>{
    private int zipCode;
    private int cyclistsHurt;
    private int injury;
    private int fatality;
    private int cInjury;
    private int cFatality;

    private String vehicleType;


    public Collision(int zipcode, int cyclistInjury, int cyclistFatality, int injury, int fatality, String vehicle){
        this.zipCode = zipcode;
        this.cyclistsHurt = cyclistInjury + cyclistFatality;
        this.vehicleType = vehicle;
        this.injury = injury;
        this.fatality = fatality;
        cInjury = cyclistInjury;
        cFatality = cyclistFatality;
    }


    /**
     * Returns the number of injuries and fatalities.
     * @return
     */
    public int getInjuryAndFatalities(){
        return injury+fatality;
    }

    /**
     * Used to break ties.
     * @return
     */
    public int getFatality(){
        return fatality;
    }

    /**
     * Used to break ties.
     * @return
     */
    public int getInjury(){
        return injury;
    }

    /**
     * Used to break ties.
     * @return
     */
    public int  getCyclistInjury(){
        return cInjury;
    }

    /**
     * Used to break ties.
     * @return
     */
    public int getCyclistFatality(){
        return cFatality;
    }


    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * Compares to another Collision as to whether or not the number of injuries is greater or less.
     */
    @Override
    public int compareTo(Collision c){
        return Integer.compare(injury+fatality, c.getInjuryAndFatalities());
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
