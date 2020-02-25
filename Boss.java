import java.util.*;

public class Boss extends Characters
{
    private int healChance;
    /**
     * Constructor for objects of class Boss
     */
    public Boss(double hp, double dmg, double acc, int spcl, int chance)
    {
        super(hp,dmg,acc,spcl);
        healChance= chance;
    }

    public void specialAttack(){
        System.out.println("Boss is trying to perform a special attack");
        System.out.println("He uses his super strength to throw his spear at you!");
    }
    
    public void getName(){
        System.out.println("Final Boss");
    }

    public int getHeadshot()
    {
        // damage +500 if 40% chance hit as boss
        int GotorNot=0;
        Random rand = new Random();
        int checkTemp=rand.nextInt(100) + 1;
        if (checkTemp<=40){GotorNot=1;}
        return GotorNot;
    }
}