package org.dp.components.tiles;

import org.dp.assets.AssetFactory;
import org.dp.assets.FontLib;
import org.dp.assets.MapAssets;
import org.dp.utils.Vector2i;

import java.awt.*;

public class PlaceTileComponent extends TileComponent{
    private boolean isInitialized = false;
    private Vector2i titleRelativePos = null;
    private String title="123";
    private String Price;
    private Font font = ((FontLib)AssetFactory.getAsset("fontLib")).placePriceFont;
    private Image img = ((MapAssets) AssetFactory.getAsset("mapAssets")).placeTile;

    private int ascent;
    public PlaceTileComponent(Vector2i p, int price,String title) {
        super(p);
        Price = "$ " + price;
        this.title= title;
    }

    @Override
    public void drawMe(Graphics graphics) {
        Vector2i p = getAbsPosition();
        Vector2i hitBox = getHitBoxSize();
        graphics.drawImage(img, p.x,p.y, 100,100,null);
        graphics.setColor(Color.black);
        graphics.setFont(font);
        if(!isInitialized){
            int titleWidth = graphics.getFontMetrics().stringWidth(title);
            int titleHeight = graphics.getFontMetrics().getHeight();
            titleRelativePos = new Vector2i(-titleWidth / 2, -titleHeight / 2);
            ascent = graphics.getFontMetrics().getAscent();
            isInitialized = true;
        }
        graphics.drawString(Price, p.x + hitBox.x/3 + 10 + titleRelativePos.x, p.y + 70 + titleRelativePos.y + ascent);
        graphics.drawString(title, p.x + hitBox.x/3 + 10 + titleRelativePos.x, p.y + 20 + titleRelativePos.y + ascent);
    }
}
