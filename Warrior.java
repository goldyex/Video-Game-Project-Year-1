
public class Warrior extends Assassins
{
    // instance variables - replace the example below with your own
    

    /**
     * Default Constructor for objects of class Warrior
     */
    public Warrior()
    {
        super(7000,200,95,1,2,5);
        //ouble hp, double dmg, double acc, int spcl, int strg, int evade
    }
    
    /**
     * Imported data file Constructor for objects of class Warrior
     */
    public Warrior(double hp, double dmg, double acc, double spcl, double storage, double evadechance)
    {
        super(hp,dmg,acc,spcl,storage,evadechance);
        //ouble hp, double dmg, double acc, int spcl, int strg, int evade
    }


}