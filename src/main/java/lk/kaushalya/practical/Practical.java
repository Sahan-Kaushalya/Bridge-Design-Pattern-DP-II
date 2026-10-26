package lk.kaushalya.practical;

/**
 * Practical 03
 * Bridge Pattern
 *
 * You have to develop an action game which has different types of weapons (Ex: Pistol, Shotgun, Sniper,
 * etc.) and soldier types (Ex: Infantry, Commando, Ranger, etc.). A soldier can hold only one weapon at a
 * time. But they can run, take any types of weapon and shoot. Develop the game by using the bridge design
 * pattern to display the following actions,
 *
 * Ranger:
 * - Running
 * - Taking the Sniper
 * - Shoot
 * - Drop the Sniper
 * - Taking Pistol
 * - Shoot
 *
 * Commando:
 * - Running
 * - Taking the Shotgun
 * - Shoot
 * - Drop the Shotgun
 * - Taking Sniper
 * - Shoot
 */

interface  Weapon {
    void shoot();
    void drop();
    void take();
}

abstract class Soldier{
    protected  Weapon weapon;

    public Soldier(Weapon weapon) {
        this.weapon = weapon;
    }

    public  void run() {
        System.out.println("Soldier is running...");
    }
    public abstract  void shoot();
    public abstract  void dropWeapon(Weapon weapon);
    public abstract  void takeWeapon(Weapon weapon);
}

class Sniper implements Weapon{

    public void shoot() {
        System.out.println("Sniper is shooting...");
    }

    public void drop() {
        System.out.println("Sniper is dropped");
    }

    public void take() {
        System.out.println("Sniper is taken");
    }
}

class Shotgun implements Weapon{

    public void shoot() {
        System.out.println("Shotgun is shooting...");
    }

    public void drop() {
        System.out.println("Shotgun is dropped");
    }

    public void take() {
        System.out.println("Shotgun is taken");
    }
}

class Pistol implements Weapon{

    public void shoot() {
        System.out.println("Pistol is shooting...");
    }

    public void drop() {
        System.out.println("Pistol is dropped");
    }

    public void take() {
        System.out.println("Pistol is taken");
    }
}

class Ranger extends Soldier {

    public Ranger(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void run() {
        System.out.println("Ranger is running...");
    }

    @Override
    public void shoot() {
        System.out.println("Ranger is shooting...");
        weapon.shoot();
    }

    @Override
    public void dropWeapon(Weapon weapon) {
        System.out.println("Ranger is dropping the weapon...");
        weapon.drop();
    }

    @Override
    public void takeWeapon(Weapon weapon) {
        System.out.println("Ranger is taking the weapon...");
        this.weapon =weapon;
        weapon.take();
    }
}

class Commando extends Soldier {
    public Commando(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void run() {
        System.out.println("Commando is running...");
    }

    @Override
    public void shoot() {
        System.out.println("Commando is shooting...");
        weapon.shoot();
    }

    @Override
    public void dropWeapon(Weapon weapon) {
        System.out.println("Commando is dropping the weapon...");
        weapon.drop();
    }

    @Override
    public void takeWeapon(Weapon weapon) {
        System.out.println("Commando is taking the weapon...");
        this.weapon =weapon;
        weapon.take();
    }
}

public class Practical {
    public static void main(String[] args) {
        Weapon sniper = new Sniper();
        Weapon shotgun = new Shotgun();
        Weapon pistol = new Pistol();

        Soldier ranger = new Ranger(sniper);
        ranger.run();
        ranger.takeWeapon(sniper);
        ranger.shoot();
        ranger.dropWeapon(sniper);
        ranger.takeWeapon(pistol);
        ranger.shoot();

        System.out.println();

        Soldier commando = new Commando(shotgun);
        commando.run();
        commando.takeWeapon(shotgun);
        commando.shoot();
        commando.dropWeapon(shotgun);
        commando.takeWeapon(sniper);
        commando.shoot();
    }
}
