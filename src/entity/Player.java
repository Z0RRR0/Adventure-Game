package src.entity;

import java.awt.Color;
// import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
// import java.nio.Buffer;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.text.Utilities;

import src.main.GamePanel;
import src.main.KeyHandler;
import src.main.UtilityTool;

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    // public int hasKey = 0;
    int standCounter = 0;

    // int counter2 = 0;

    public Player(GamePanel gp, KeyHandler keyH) {

            this.gp = gp;
            this.keyH = keyH;

            screenX = gp.screenWidth/2 - (gp.tileSize/2);
            screenY = gp.screenHeight/2 - (gp.tileSize/2);

            solidArea = new Rectangle();
            solidArea.x = 8;
            solidArea.y = 16;
            solidAreaDefaultX = solidArea.x;
            soildAreaDefaultY = solidArea.y;
            solidArea.width = 32;
            solidArea.height = 32;

            setDefaultValues();
            getPlayerImage();
    }
    public void setDefaultValues() {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21; 
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {

        up1 = setup("boy_up_1");
        up2 = setup("boy_up_2");
        down1 = setup("boy_down_1");
        down2 = setup("boy_down_2");
        left1 = setup("boy_left_1");
        left2 = setup("boy_left_2");
        right1 = setup("boy_right_1");
        right2 = setup("boy_right_2");
    }

    public BufferedImage setup(String imageName) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/player/" + imageName + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    public void update() {

        if(keyH.upPressed == true || keyH.downPressed == true || 
        keyH.leftPressed == true || keyH.rightPressed == true) {

            if(keyH.upPressed == true) {
                direction = "up";                
            }
            else if(keyH.downPressed == true) {
                direction = "down";                
            }
            else if(keyH.leftPressed == true) {
                direction = "left";              
            }
            else if(keyH.rightPressed == true) {
                direction = "right";    
            }

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISON
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
    
            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false) {

                switch(direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 12) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if(spriteNum ==2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else {
            standCounter++;

            if(standCounter == 20) {
                spriteNum = 1;
                standCounter = 0;
            }
            
        }
    }
    public void pickUpObject(int i) {

        if(i != 999) {

        }
    }

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch(direction) {
        case "up":
            if(spriteNum == 1) {
                image = up1;
            }
            if(spriteNum == 2) {
                image = up2;
            }
            break;
        case "down":
            if(spriteNum == 1) {
                image = down1;
            }
            if(spriteNum == 2) {
                image = down2;
            }
            break;
        case "left":
            if(spriteNum == 1) {
                image = left1;
            }
            if(spriteNum == 2) {
                image = left2;
            }
            break;
        case "right":
            if(spriteNum == 1) {
                image = right1;
            }
            if(spriteNum == 2) {
                image = right2;
            }
            break;
        }
        g2.drawImage(image, screenX, screenY,null);
        // g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}












