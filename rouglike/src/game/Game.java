package game;

import game.entity.Player;
import game.entity.Monster;

import java.util.Scanner;

public class Game {
    private Map map;
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        map = new Map(10, 10);
        player = new Player("Hero", 30, new Position(1, 1));
        map.placePlayer(player);
        map.spawnMonster();
    }

    public void start() {
        System.out.println("=== Roguelike 游戏开始 ===");

        while (player.isAlive()) {
            map.print();
            System.out.print("移动 (WASD)：");
            String input = scanner.nextLine().toUpperCase();

            map.movePlayer(input);

            Monster monster = map.getMonsterAtPlayer();
            if (monster != null) {
                battle(monster);
            }
        }

        System.out.println("游戏结束！");
    }

    private void battle(Monster monster) {
        System.out.println("遭遇怪物：" + monster.getName());

        while (player.isAlive() && monster.isAlive()) {
            monster.takeDamage(player.attack());
            if (monster.isAlive()) {
                player.takeDamage(monster.attack());
            }
        }

        if (!monster.isAlive()) {
            System.out.println("你击败了怪物！");
            map.removeMonster(monster);
        }
    }
}
