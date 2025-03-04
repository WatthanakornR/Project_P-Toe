package main;

import entity.Entity;
import object.SuperObject;
import javafx.scene.shape.Rectangle;

public class CollisionChecker {
    private GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftX = entity.worldX + (int) entity.solidArea.getX();
        int entityRightX = entity.worldX + (int) entity.solidArea.getX() + (int) entity.solidArea.getWidth();
        int entityTopY = entity.worldY + (int) entity.solidArea.getY();
        int entityBottomY = entity.worldY + (int) entity.solidArea.getY() + (int) entity.solidArea.getHeight();

        int leftCol = entityLeftX / gp.TILE_SIZE;
        int rightCol = entityRightX / gp.TILE_SIZE;
        int topRow = entityTopY / gp.TILE_SIZE;
        int bottomRow = entityBottomY / gp.TILE_SIZE;

        int tileNum1 = 0, tileNum2 = 0;

        switch (entity.direction) {
            case "up":
                topRow = Math.max((entityTopY - entity.speed) / gp.TILE_SIZE, 0);
                tileNum1 = gp.tileM.mapTileNum[leftCol][topRow];
                tileNum2 = gp.tileM.mapTileNum[rightCol][topRow];
                break;
            case "down":
                bottomRow = Math.min((entityBottomY + entity.speed) / gp.TILE_SIZE, gp.tileM.mapTileNum[0].length - 1);
                tileNum1 = gp.tileM.mapTileNum[leftCol][bottomRow];
                tileNum2 = gp.tileM.mapTileNum[rightCol][bottomRow];
                break;
            case "left":
                leftCol = Math.max((entityLeftX - entity.speed) / gp.TILE_SIZE, 0);
                tileNum1 = gp.tileM.mapTileNum[leftCol][topRow];
                tileNum2 = gp.tileM.mapTileNum[leftCol][bottomRow];
                break;
            case "right":
                rightCol = Math.min((entityRightX + entity.speed) / gp.TILE_SIZE, gp.tileM.mapTileNum.length - 1);
                tileNum1 = gp.tileM.mapTileNum[rightCol][topRow];
                tileNum2 = gp.tileM.mapTileNum[rightCol][bottomRow];
                break;
            default:
                return;
        }

        if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
            entity.collisionOn = true;
        }
    }

    public int checkObject(Entity entity, boolean player) {
        int index = -1;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] == null) continue;

            // Set object positions
            entity.solidArea.setX(entity.worldX + entity.solidAreaDefaultX);
            entity.solidArea.setY(entity.worldY + entity.solidAreaDefaultY);
            gp.obj[i].solidArea.setX(gp.obj[i].worldX + gp.obj[i].solidAreaDefaultX);
            gp.obj[i].solidArea.setY(gp.obj[i].worldY + gp.obj[i].solidAreaDefaultY);

            // Move entity solid area based on direction
            switch (entity.direction) {
                case "up": entity.solidArea.setY(entity.solidArea.getY() - entity.speed); break;
                case "down": entity.solidArea.setY(entity.solidArea.getY() + entity.speed); break;
                case "left": entity.solidArea.setX(entity.solidArea.getX() - entity.speed); break;
                case "right": entity.solidArea.setX(entity.solidArea.getX() + entity.speed); break;
            }

            // Check for intersection
            if (entity.solidArea.intersects(gp.obj[i].solidArea.getBoundsInLocal())) {
                if (gp.obj[i].collision) entity.collisionOn = true;
                if (player) index = i;
            }

            // Reset positions
            entity.solidArea.setX(entity.solidAreaDefaultX);
            entity.solidArea.setY(entity.solidAreaDefaultY);
            gp.obj[i].solidArea.setX(gp.obj[i].solidAreaDefaultX);
            gp.obj[i].solidArea.setY(gp.obj[i].solidAreaDefaultY);
        }
        return index;
    }
}
