package scenes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StageButton {
    public String stageName;
    private int x, y, width, height;
    private Image stageBox;
    private Font font;
    private boolean isLocked;
    private boolean isHovered;

    public StageButton(String stageName, int x, int y, int width, int height, Image stageBox, Font font, boolean isLocked) {
        this.stageName = stageName;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.stageBox = stageBox;
        this.font = font != null ? font : Font.font("Arial", 20);
        this.isLocked = isLocked;
        this.isHovered = false;
    }

    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setHovered(boolean hovered) {
        this.isHovered = hovered;
    }

    public boolean isHovered() {
        return isHovered;
    }

    public boolean contains(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    public void draw(GraphicsContext gc, Image chestImage, Image keyImage) {
        // Change background color when hovered
        if (isHovered) {
            gc.setFill(Color.rgb(255, 255, 255, 0.4)); // White transparent
            gc.fillRect(x, y, width, height);
        }

        // Draw button background
        if (stageBox != null) {
            gc.drawImage(stageBox, x, y, width, height);
        }

        // Set font
        gc.setFont(font);

        // Calculate text position
        Text text = new Text(stageName);
        text.setFont(font);
        double textWidth = text.getLayoutBounds().getWidth();
        double textHeight = text.getLayoutBounds().getHeight();
        double textX = x + (width - textWidth) / 2;
        double textY = y + (height + textHeight) / 2 - 5;

        // If stage is locked, show chest image
        if (isLocked && chestImage != null) {
            double chestSize = 50;
            double chestX = x + (width - chestSize) / 2;
            double chestY = y + (height - chestSize) / 2;
            gc.drawImage(chestImage, chestX, chestY, chestSize, chestSize);

            // If key image exists, display it on chest
            if (keyImage != null) {
                double keySize = 30;
                double keyX = chestX + chestSize - keySize / 2;
                double keyY = chestY - keySize / 2;
                gc.drawImage(keyImage, keyX, keyY, keySize, keySize);
            }
        }

        // If not locked, display stage name (change text color when hovered)
        if (!isLocked) {
            gc.setFill(isHovered ? Color.BLUE : Color.BLACK);
            gc.fillText(stageName, textX, textY);
        }
    }
}
