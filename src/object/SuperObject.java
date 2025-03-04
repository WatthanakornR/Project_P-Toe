package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import main.GamePanel;

public class SuperObject {
    public Image image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(GraphicsContext gc, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.TILE_SIZE > gp.player.worldX - gp.player.screenX &&
            worldX - gp.TILE_SIZE < gp.player.worldX + gp.player.screenX &&
            worldY + gp.TILE_SIZE > gp.player.worldY - gp.player.screenY &&
            worldY - gp.TILE_SIZE < gp.player.worldY + gp.player.screenY) {

            gc.drawImage(image, screenX, screenY, gp.TILE_SIZE, gp.TILE_SIZE);
        }
    }
}
