package game;

import game.entity.Player;
import game.entity.Monster;

import java.util.Random;

public class Map {
    private int width;
    private int height;
    private Player player;
    private Monster monster;
    private Random random = new Random();

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void placePlayer(Player player) {
        this.player = player;
    }

    public void spawnMonster() {
        monster = new Monster("Slime", 15,
                new Position(random.nextInt(width), random.nextInt(height)));
    }

    public void movePlayer(String input) {
        Position p = player.getPosition();

        switch (input) {
            case "W": p.y--; break;
            case "S": p.y++; break;
            case "A": p.x--; break;
            case "D": p.x++; break;
        }

        p.x = Math.max(0, Math.min(width - 1, p.x));
        p.y = Math.max(0, Math.min(height - 1, p.y));
    }

    public Monster getMonsterAtPlayer() {
        if (monster != null && monster.getPosition().equals(player.getPosition())) {
            return monster;
        }
        return null;
    }

    public void removeMonster(Monster m) {
        monster = null;
        spawnMonster();
    }

    public void print() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Position pos = new Position(x, y);
                if (player.getPosition().equals(pos)) {
                    System.out.print("P ");
                } else if (monster != null && monster.getPosition().equals(pos)) {
                    System.out.print("M ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("HP: " + player.getHp());
    }
}
