package levels;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Crabby;
import main.Geme;
import objects.Cannon;
import objects.GameContainer;
import objects.Potion;
import utilz.HelpMethods;

import static utilz.HelpMethods.GetLevelData;
import static utilz.HelpMethods.GetCrabs;
import static utilz.HelpMethods.GetPlayerSpawn;
import objects.Spike;


public class Level {

    private BufferedImage img;
    private int[][] lvlData;
    private ArrayList<Crabby> crabs;
    private ArrayList<Potion> potions;
    private ArrayList<GameContainer> containers;
    private ArrayList<Cannon> cannons;
    private ArrayList<Spike> spikes;

    private int lvlTilesWide;
    private int maxTilesOffset;
    private int maxLvlOffsetx;
    private Point playerSpawn;
    public Level(BufferedImage img)
    {
        this.img=img;
        createLevelData();
        createEnemies();
        createPotions();
        createContainers();
        createSpikes();
        createCannons();
        calcLvlOffsets();
        calcPlayerSpawn();

    }
    private void createCannons() {
        cannons=HelpMethods.GetCannon(img);

    }
}