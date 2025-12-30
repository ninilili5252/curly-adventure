package game.entity;

import game.Position;

public class Monster extends Entity {

    public Monster(String name, int hp, Position position) {
        super(name, hp, position);
    }

    @Override
    public int attack() {
        return 4;
    }
}
