package net.mccreators.animod.item.client;

import net.mccreators.animod.item.custom.AmethystArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class AmethystArmorRenderer extends GeoArmorRenderer<AmethystArmorItem> {
    public AmethystArmorRenderer() {
        super(new AmethystArmorModel());
    }
}
