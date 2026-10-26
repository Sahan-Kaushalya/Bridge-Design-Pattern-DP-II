package lk.kaushalya.practical;

/**
 * Practical 03
 * Bridge Pattern
 * <p>
 * You have to develop an action game which has different types of weapons (Ex: Pistol, Shotgun, Sniper,
 * etc.) and soldier types (Ex: Infantry, Commando, Ranger, etc.). A soldier can hold only one weapon at a
 * time. But they can run, take any types of weapon and shoot. Develop the game by using the bridge design
 * pattern to display the following actions,
 * <p>
 * Ranger:
 * - Running
 * - Taking the Sniper
 * - Shoot
 * - Drop the Sniper
 * - Taking Pistol
 * - Shoot
 * <p>
 * Commando:
 * - Running
 * - Taking the Shotgun
 * - Shoot
 * - Drop the Shotgun
 * - Taking Sniper
 * - Shoot
 */

interface Weapon {
    void shoot();

    void drop();

    void take();
}

abstract class Soldier {
    protected Weapon weapon;

    public Soldier(Weapon weapon) {
        this.weapon = weapon;
    }

    public void run() {
        System.out.println("Running");
    }

    public void takeWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.weapon.take();
    }

    public void dropWeapon() {
        if (this.weapon != null) {
            this.weapon.drop();
            this.weapon = null;
        }
    }

    public void shoot() {
        if (this.weapon != null) {
            this.weapon.shoot();
        }
    }

    public abstract void performAction();
}

class Sniper implements Weapon {
    public void take() {
        System.out.println("Taking the Sniper");
    }

    public void shoot() {
        System.out.println("Shoot");
    }

    public void drop() {
        System.out.println("Drop the Sniper");
    }
}

class Shotgun implements Weapon {
    public void take() {
        System.out.println("Taking the Shotgun");
    }

    public void shoot() {
        System.out.println("Shoot");
    }

    public void drop() {
        System.out.println("Drop the Shotgun");
    }
}

class Pistol implements Weapon {
    public void take() {
        System.out.println("Taking Pistol");
    }

    public void shoot() {
        System.out.println("Shoot");
    }

    public void drop() {
        System.out.println("Drop the Pistol");
    }
}

class Ranger extends Soldier {

    public Ranger(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void performAction() {
        System.out.println("Ranger is performing action");
    }


}

class Commando extends Soldier {
    public Commando(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void performAction() {
        System.out.println("Commando is performing action");
    }

}

public class Practical {
    public static void main(String[] args) {
        Weapon sniper = new Sniper();
        Weapon shotgun = new Shotgun();
        Weapon pistol = new Pistol();

        Soldier ranger = new Ranger(sniper);
        ranger.performAction();
        ranger.run();
        ranger.takeWeapon(sniper);
        ranger.shoot();
        ranger.dropWeapon();
        ranger.takeWeapon(pistol);
        ranger.shoot();

        System.out.println();

        Soldier commando = new Commando(shotgun);
        commando.performAction();
        commando.run();
        commando.takeWeapon(shotgun);
        commando.shoot();
        commando.dropWeapon();
        commando.takeWeapon(sniper);
        commando.shoot();
    }
}
