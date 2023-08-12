package net.mccreators.animod.datagen;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.block.ModBlocks;
import net.mccreators.animod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        nineBlockStorageRecipesWithCustomPacking(consumer, RecipeCategory.MISC, ModItems.SMALL_PLACEHOLDER.get(),
                RecipeCategory.MISC, ModItems.PLACEHOLDER.get(),
                "placeholder_from_small_placeholders", "placeholder");

        nineBlockStorageRecipesWithCustomPacking(consumer, RecipeCategory.MISC, ModItems.PLACEHOLDER.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLACEHOLDER_BLOCK.get(),
                "placeholder_block_from_placeholders", "placeholder_block");

         ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMALL_PLACEHOLDER.get(), 9)
                 .requires(ModItems.PLACEHOLDER.get())
                 .unlockedBy("has_placeholder", inventoryTrigger(ItemPredicate.Builder.item()
                         .of(ModItems.PLACEHOLDER.get()).build()))
                 .save(consumer);

         ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WIP_PLANKS.get(), 4)
                 .requires(ModBlocks.WIP_LOG.get())
                 .unlockedBy("has_wip_log", has(ItemTags.LOGS))
                 .save(consumer);
        woodFromLogs(consumer, ModBlocks.WIP_WOOD.get(), ModBlocks.WIP_LOG.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
                .define('#', ModBlocks.WIP_PLANKS.get())
                .pattern("#")
                .pattern("#").group("sticks")
                .unlockedBy("has_wip_planks", has(ItemTags.PLANKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PLACEHOLDER_STAFF.get())
                .define('#', Items.STICK).define('X', ModBlocks.PLACEHOLDER_BLOCK.get()).define('Y', Items.DIAMOND)
                .pattern("YXY")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_placeholder", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.PLACEHOLDER.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AMETHYST_HELMET.get())
                .define('#', Items.AMETHYST_SHARD)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_amethyst_shard", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.AMETHYST_SHARD).build()))
                        .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AMETHYST_CHESPLATE.get())
                .define('#', Items.AMETHYST_SHARD)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_amethyst_shard", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.AMETHYST_SHARD).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AMETHYST_LEGGINGS.get())
                .define('#', Items.AMETHYST_SHARD)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_amethyst_shard", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.AMETHYST_SHARD).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AMETHYST_BOOTS.get())
                .define('#', Items.AMETHYST_SHARD)
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_amethyst_shard", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.AMETHYST_SHARD).build()))
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

    private void planksFromLog(Consumer<FinishedRecipe> consumer, Block p259052, Block block, int p259471) {
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
                                                  RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String group,
                                                  String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, new ResourceLocation(AniMod.MOD_ID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_)
                .pattern("###").pattern("###").pattern("###").group(group)
                .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(AniMod.MOD_ID, p_250475_));
    }
}
