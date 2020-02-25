public class Tech extends Assassins
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Tech
     */
    public Tech()
    {
        super(550,150,75,2,1,10);
        //ouble hp, double dmg, double acc, int spcl, int strg, int evade
    }
    
    /**
     * Imported data file Constructor for objects of class Tech
     */
    public Tech(double hp, double dmg, double acc, double spcl, double storage, double evadechance)
    {
        super(hp,dmg,acc,spcl,storage,evadechance);
        //ouble hp, double dmg, double acc, int spcl, int strg, int evade
    }

    public double droneUse(){
        double dmg = getDmg()+70;
        return dmg; 
    }
}