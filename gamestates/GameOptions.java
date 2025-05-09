package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Geme;
import ui.AudioOptions;
import ui.PauseButton;
import ui.UrmButton;
import utilz.LoadSave;
import static utilz.Constants.UI.UrmButtons.*;


public class GameOptions extends State implements Statemethods {

    private AudioOptions audiooptions;
    private BufferedImage backgroundImg,optionsBackgroundImg;
    private int bgX, bgY, bgW, bgH;
    private UrmButton menuB;
    public GameOptions(Geme geme) {
        super(geme);
        loadImgs();
        loadButton();
        audiooptions=geme.getAudiooptions();

    }

    private void loadButton() {
        int menuX = (int) (387 * Geme.SCALE);
        int menuY = (int) (325 * Geme.SCALE);

        menuB = new UrmButton(menuX, menuY, URM_SIZE, URM_SIZE, 2);
    }

    private void loadImgs() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND_IMG);
        optionsBackgroundImg = LoadSave.GetSpriteAtlas(LoadSave.OPTIONS_MENU);

        bgW = (int) (optionsBackgroundImg.getWidth() * Geme.SCALE);
        bgH = (int) (optionsBackgroundImg.getHeight() * Geme.SCALE);
        bgX = Geme.GAME_WIDTH / 2 - bgW / 2;
        bgY = (int) (33 * Geme.SCALE);
    }

    @Override
    public void update() {
        menuB.update();
        audiooptions.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, Geme.GAME_WIDTH, Geme.GAME_HEIGHT, null);
        g.drawImage(optionsBackgroundImg, bgX, bgY, bgW, bgH, null);

        menuB.draw(g);
        audiooptions.draw(g);

    }

    public void mouseDragged(MouseEvent e) {
        audiooptions.mouseDragged(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isIn(e,menuB)) {
            menuB.setMousePressed(true);
        } else
            audiooptions.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isIn(e, menuB)) {
            if (menuB.isMousePressed())
                Gamestate.state = Gamestate.MENU;
        } else
            audiooptions.mouseReleased(e);

        menuB.resetBools();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        menuB.setMouseOver(false);

        if (isIn(e, menuB))
            menuB.setMouseOver(true);
        else
            audiooptions.mouseMoved(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            Gamestate.state = Gamestate.MENU;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    private boolean isIn(MouseEvent e,PauseButton b)
    {
        return b.getBounds().contains(e.getX(),e.getY());
    }

}