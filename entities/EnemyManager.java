package entities;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {
    private Playing playing;
    private BufferedImage[][] crabbyArr;
    private ArrayList<Spider> crabbies=new ArrayList<>();
    public EnemyManager(Playing playing)
    {
        this.playing=playing;
        loadEnemyImgs();
    }
    public void LoadEnemies(Level level) {
        spiders= level.getSpiders();
    }
    public void update(int[][] lvlData,Player player)
    {
        boolean isAnyActive=false;
        for(Spider c:crabbies)
            if(c.isActive())
            {
                c.update(lvlData, player);
                isAnyActive=true;
            }
        if(!isAnyActive)
            playing.setLevelCompleted(true);
    }
    public void draw(Graphics g,int xLvlOffset)
    {
        drawSpiders(g,xLvlOffset);

    }
    private void drawSpiders(Graphics g,int xLvlOffset) {
        for(Spider c:spiders)
            if(c.isActive())
            {
                g.drawImage(spiderArr[c.getEnemyState()][c.getAniIndex()],
                        (int)(c.getHitbox().x-SPIDER_DRAWOFFSET_X)-xLvlOffset+c.flipX(),
                        (int) (c.getHitbox().y-SPIDER_DRAWOFFSET_Y), SPIDER_WIDTH*c.flipW(), SPIDER_HEIGHT, null);
                //c.drawHitbox(g, xLvlOffset);
                //c.drawAttackBox(g, xLvlOffset);
            }
    }

    public void checkEnemyHit(Rectangle2D.Float attackBox) {
        for(Spider c:crabbies)
            if(c.getCurrentHealth()>0)
                if(c.isActive())
                    if(attackBox.intersects(c.getHitbox()))
                    {
                        c.hurt(10);
                        return;
                    }
    }

    private void loadEnemyImgs() {
        spiderArr=new BufferedImage[5][9];
        BufferedImage temp=LoadSave.GetSpriteAtlas(LoadSave.SPIDER_SPRITE);
        for(int j=0;j<crabbyArr.length;j++)
            for(int i=0;i<crabbyArr[j].length;i++)
                crabbyArr[j][i]=temp.getSubimage(i*SPIDER_WIDTH_DEFAULT, j*SPIDER_HEIGHT_DEFAULT, SPIDER_WIDTH_DEFAULT, SPIDER_HEIGHT_DEFAULT);

    }
    public void resetAllEnemies() {
        for(Spider c:spiders)
            c.resetEnemy();

    }

}
