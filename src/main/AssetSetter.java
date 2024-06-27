package src.main;

import src.object.OBJ_Boots;
import src.object.OBJ_Chest;
import src.object.OBJ_Door;
import src.object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 24 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 15 * gp.tileSize;
        gp.obj[1].worldY = 45 * gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 40 * gp.tileSize;
        gp.obj[2].worldY = 18 * gp.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 45 * gp.tileSize;
        gp.obj[3].worldY = 8 * gp.tileSize;

        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 32 * gp.tileSize;
        gp.obj[4].worldY = 16 * gp.tileSize;

        gp.obj[5] = new OBJ_Chest();
        gp.obj[5].worldX = 32 * gp.tileSize;
        gp.obj[5].worldY = 14 * gp.tileSize;

        gp.obj[6] = new OBJ_Boots();
        gp.obj[6].worldX = 45 * gp.tileSize;
        gp.obj[6].worldY = 6 * gp.tileSize;
    }
}