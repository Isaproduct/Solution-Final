package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gamestates.Gamestate;
import main.Geme;
import utilz.LoadSave;

public class LevelManager {

    private Geme geme;
    private BufferedImage[] levelSprite;
    private ArrayList<Level> levels;
    private int lvlIndex = 0;

    public LevelManager(Geme geme) {
        this.geme = geme;
        importOutsideSprites();
        levels = new ArrayList<>();
        buildAllLevels();
    }
}