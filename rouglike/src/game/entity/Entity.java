package game.entity;

import game.Position;

public abstract class Entity {
    protected String name;
    protected int hp;
    protected Position position;

    public Entity(String name, int hp, Position position) {
        this.name = name;
        this.hp = hp;
        this.position = position;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int attack() {
        return 5;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " 受到 " + damage + " 点伤害");
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
