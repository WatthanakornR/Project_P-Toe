package entity;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Entity {
    public int worldX, worldY;
    public int speed;
    
    public Image up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public Entity() {
        // Default solidArea size
        this.solidArea = new Rectangle(0, 0, 48, 48);
    }
}
