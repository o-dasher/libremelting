package com.dasher.meltinglight.Assets.FontAssets;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.Assets.GameAssetDescriptor;
import com.dasher.meltinglight.MeltingLight;

public class FontPack extends AssetPack<BitmapFont> {
    public FontPack(MeltingLight game) {
        super(game);
    }

    @Override
    public String dir() {
        return "Fonts";
    }

    @Override
    public Class<BitmapFont> assetType() {
        return BitmapFont.class;
    }

    public final GameAssetDescriptor<BitmapFont> mainFont = createDescriptor("arial-main", getFileExtensions().fnt);
}
