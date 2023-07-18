package net.mccreators.animod.datagen;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.block.ModBlocks;
import net.mccreators.animod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.PLACEHOLDER.get(), RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.PLACEHOLDER_BLOCK.get());

         ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMALL_PLACEHOLDER.get())
                 .requires(ModItems.PLACEHOLDER.get())
                 .unlockedBy("has_placeholder", inventoryTrigger(ItemPredicate.Builder.item()
                         .of(ModItems.PLACEHOLDER.get()).build()))
                 .save(consumer);

        // ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLACEHOLDER.get())
        //         .define('B', ModItems.SMALL_PLACEHOLDER.get())
        //         .pattern("BBB")
        //         .pattern("BBB")
        //         .pattern("BBB")
        //         .unlockedBy("has_small_placehoder", inventoryTrigger(ItemPredicate.Builder.item()
        //                 .of(ModItems.SMALL_PLACEHOLDER.get()).build()))
        //         .save(consumer);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
                                                  RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
                                                  String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, new ResourceLocation(AniMod.MOD_ID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_)
                .pattern("###").pattern("###").pattern("###").group(p_248641_)
                .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(AniMod.MOD_ID, p_250475_));
    }
}
