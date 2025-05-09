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
    private void createSpikes() {
        spikes=HelpMethods.GetSpikes(img);
    }
    private void createContainers() {
        containers=HelpMethods.GetContainer(img);

    }
    private void createPotions() {
        potions=HelpMethods.GetPotions(img);

    }
    private void calcPlayerSpawn() {
        playerSpawn=GetPlayerSpawn(img);

    }
    private void calcLvlOffsets() {

        lvlTilesWide=img.getWidth();
        maxTilesOffset=lvlTilesWide-Geme.TILES_IN_WIDTH;
        maxLvlOffsetx=Geme.TILES_SIZE*maxTilesOffset;
    }
    private void createEnemies() {
        crabs=GetCrabs(img);

    }
    private void createLevelData() {

        lvlData=GetLevelData(img);
    }
    public int getSpriteIndex(int x,int y)
    {
        return lvlData[y][x];
    }

    public int[][] getLevelData()
    {
        return lvlData;
    }
    public int getLvlOffset()
    {
        return maxLvlOffsetx;
    }
    public ArrayList<Crabby> getCrabs()
    {
        return crabs;
    }
    public Point getPlayerSpawn()
    {
        return playerSpawn;
    }
    public ArrayList<Potion> getPotions() {
        return potions;
    }
    public ArrayList<GameContainer> getContainers() {
        return containers;
    }
    public ArrayList<Spike> getSpikes() {
        return spikes;
    }
    public ArrayList<Cannon> getCannons() {
        return cannons;
    }
}
