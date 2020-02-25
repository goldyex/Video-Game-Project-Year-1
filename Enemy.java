import java.util.Random;

public class Enemy extends Characters
{
    // instance variables - replace the example below with your own
    //????????????????? Need something special 

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(double hp, double dmg, double acc, int spcl)
    {
        super(hp,dmg,acc,spcl);
        
    }
    
    public void specialAttack(){
        System.out.println("Enemy does not have a special attack");
    }

    public int getHeadshot()
    {
        // damage +200 if 20% chance hit
        int GotorNot=0;
        Random rand = new Random();
        int checkTemp=rand.nextInt(100) + 1;
        if (checkTemp<=20){GotorNot=1;}
        return GotorNot;
    }
}