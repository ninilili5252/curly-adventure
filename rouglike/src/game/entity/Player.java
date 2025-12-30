package game.entity;

import game.Position;

public class Player extends Entity {

    public Player(String name, int hp, Position position) {
        super(name, hp, position);
    }

    @Override
    public int attack() {
        return 8;
    }

    public int getHp() {
        return hp;
    }
}
