package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import gamestates.Gamestate;
import gamestates.Playing;
import main.Geme;
import utilz.LoadSave;
import static utilz.Constants.UI.UrmButtons.*;

public class LevelCompletedOverlay {
    private Playing playing;
    private UrmButton menu,next;
    private BufferedImage img;
    private int bgX,bgY,bgW,bgH;

    public LevelCompletedOverlay(Playing playing)
    {
        this.playing=playing;
        initImage();
        initButtons();
    }

    private void initButtons() {
        int menuX=(int)(330*Geme.SCALE);
        int nextX=(int)(445*Geme.SCALE);
        int y=(int)(195*Geme.SCALE);
        next=new UrmButton(nextX, y, URM_SIZE, URM_SIZE, 0);
        menu=new UrmButton(menuX, y, URM_SIZE, URM_SIZE, 2);
    }

    private void initImage() {
        img=LoadSave.GetSpriteAtlas(LoadSave.COMPLETED_IMG);
        bgW=(int)(img.getWidth() * Geme.SCALE);
        bgH=(int)(img.getHeight() * Geme.SCALE);
        bgX=Geme.GAME_WIDTH/2-bgW/2;
        bgY=(int)(75* Geme.SCALE);

    }
    public void update()
    {
        next.update();
        menu.update();
    }
    public void draw(Graphics g)
    {
        g.drawImage(img, bgX, bgY, bgW, bgH, null);
        next.draw(g);
        menu.draw(g);
    }

    private boolean isIn(UrmButton b,MouseEvent e)
    {
        return b.getBounds().contains(e.getX(),e.getY());
    }
    public void mouseMoved(MouseEvent e)
    {
        next.setMouseOver(false);
        menu.setMouseOver(false);

        if(isIn(menu, e))
            menu.setMouseOver(true);
        else if(isIn(next, e))
            next.setMouseOver(true);
    }
    public void mouseReleased(MouseEvent e)
    {
        if(isIn(menu, e))
        {
            if(menu.isMousePressed())
            {
                playing.resetAll();
                Gamestate.state=Gamestate.MENU;

            }
        }
        else if(isIn(next, e))
            if(next.isMousePressed())
                playing.loadNextLevel();

        menu.resetBools();
        next.resetBools();
    }
    public void mousePressed(MouseEvent e)
    {
        if(isIn(menu, e))
            menu.setMousePressed(true);
        else if(isIn(next, e))
            next.setMousePressed(true);
    }
}
