package ui;

import static utilz.Constants.UI.UrmButtons.URM_SIZE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import gamestates.Gamestate;
import gamestates.Playing;
import main.Geme;
import utilz.LoadSave;

public class GameOverOverlay {
    private Playing playing;
    private BufferedImage img;
    private int imgX,imgY,imgW,imgH;
    private UrmButton menu,play;

    public GameOverOverlay(Playing playing)
    {
        this.playing=playing;
        createImg();
        createButtons();
    }
    private void createButtons() {
        int menuX=(int)(335*Geme.SCALE);
        int playX=(int)(440*Geme.SCALE);
        int y=(int)(195*Geme.SCALE);
        play=new UrmButton(playX, y, URM_SIZE, URM_SIZE, 0);
        menu=new UrmButton(menuX, y, URM_SIZE, URM_SIZE, 2);
    }
    private void createImg() {
        img=LoadSave.GetSpriteAtlas(LoadSave.DEATH_SCREEN);
        imgW = (int) (img.getWidth() * Geme.SCALE);
        imgH = (int) (img.getHeight() * Geme.SCALE);
        imgX = Geme.GAME_WIDTH / 2 - imgW / 2;
        imgY = (int) (100 * Geme.SCALE);

    }
    public void draw(Graphics g)
    {
        g.setColor(new Color(0,0,0,200));
        g.fillRect(0, 0, Geme.GAME_WIDTH, Geme.GAME_HEIGHT);

        g.drawImage(img, imgX, imgY, imgW, imgH, null);

        menu.draw(g);
        play.draw(g);


    }

    public void update()
    {
        menu.update();
        play.update();
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            playing.resetAll();
            Gamestate.state=Gamestate.MENU;
        }
    }
    private boolean isIn(UrmButton b,MouseEvent e)
    {
        return b.getBounds().contains(e.getX(),e.getY());
    }
    public void mouseMoved(MouseEvent e)
    {
        play.setMouseOver(false);
        menu.setMouseOver(false);

        if(isIn(menu, e))
            menu.setMouseOver(true);
        else if(isIn(play, e))
            play.setMouseOver(true);
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
        else if(isIn(play, e))
            if(play.isMousePressed())
                playing.resetAll();
        menu.resetBools();
        play.resetBools();
    }
    public void mousePressed(MouseEvent e)
    {
        if(isIn(menu, e))
            menu.setMousePressed(true);
        else if(isIn(play, e))
            play.setMousePressed(true);
    }
}
