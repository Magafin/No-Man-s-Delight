package com.magafin.no_mans_delight.register;

import com.magafin.no_mans_delight.food_values.FoodValues;
import net.minecraft.client.renderer.item.ItemProperties;
import com.magafin.no_mans_delight.register.BlockReg;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.function.Supplier;

import static com.magafin.no_mans_delight.No_mans_delight.MODID;
import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class ItemReg {
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }
    public static Item.Properties bigFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).stacksTo(32);
    }
    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> HORSE_SOUP = ITEMS.register("horse_soup", registryName ->
            new ConsumableItem(bowlFoodItem(FoodValues.HORSE_SOUP).stacksTo(16), true));
    public static final DeferredItem<Item> MUSHROOMS_WITH_TOMATO = ITEMS.register("mushrooms_with_tomato", registryName ->
            new ConsumableItem(bowlFoodItem(FoodValues.MUSHROOMS_WITH_TOMATO).stacksTo(16), true));
    public static final DeferredItem<Item> SWEET_FROG_LEGS = ITEMS.register("sweet_frog_legs", registryName ->
            new ConsumableItem(bowlFoodItem(FoodValues.SWEET_FROG_LEGS).stacksTo(16), true));
    public static final DeferredItem<Item> VENISON_TART = ITEMS.register("venison_tart", registryName ->
            new ConsumableItem(bowlFoodItem(FoodValues.VENISON_TART).stacksTo(16), true));
    public static final DeferredItem<Item> SHROOMBURGER = ITEMS.register("shroomburger", registryName ->
            new ConsumableItem(foodItem(FoodValues.SHROOMBURGER), false));
    public static final DeferredItem<Item> HORSE_LOIN = ITEMS.register("horse_loin", registryName ->
            new ConsumableItem(foodItem(FoodValues.HORSE_LOIN), false));
    public static final DeferredItem<Item> COOKED_HORSE_LOIN = ITEMS.register("cooked_horse_loin", registryName ->
            new ConsumableItem(foodItem(FoodValues.COOKED_HORSE_LOIN), false));
    public static final DeferredItem<Item> VENISON_MEDALLIONS = ITEMS.register("venison_medallions", registryName ->
            new ConsumableItem(foodItem(FoodValues.VENISON_MEDALLIONS), false));
    public static final DeferredItem<Item> COOKED_VENISON_MEDALLIONS = ITEMS.register("cooked_venison_medallions", registryName ->
            new ConsumableItem(foodItem(FoodValues.COOKED_VENISON_MEDALLIONS), false));
    public static final DeferredItem<Item> VENISON_ROULADE = ITEMS.register("plated_venison_roulade", registryName ->
            new ConsumableItem(foodItem(FoodValues.VENISON_ROULADE).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final DeferredItem<Item> VENISON_ROULADE_BLOCK_ITEM = ITEMS.register("venison_roulade_block",()->
            new BlockItem(BlockReg.VENISON_ROULADE_BLOCK.get(), basicItem().stacksTo(1)));
    public static final DeferredItem<Item> NO_MANS_POT = ITEMS.register("no_mans_pot", registryName ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> STUFFED_SHELF_MUSHROOM = ITEMS.register("stuffed_shelf_mushroom", registryName ->
            new ConsumableItem(foodItem(FoodValues.STUFFED_SHELF_MUSHROOM).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final DeferredItem<Item> STUFFED_SHELF_MUSHROOM_BLOCK_ITEM = ITEMS.register("stuffed_shelf_mushroom_block",()->
            new BlockItem(BlockReg.STUFFED_SHELF_MUSHROOM_BLOCK.get(), basicItem().stacksTo(1)));
    public static final DeferredItem<Item> VENISON_MUSCLE = ITEMS.register("venison_muscle", registryName ->
            new ConsumableItem(foodItem(FoodValues.VENISON_MUSCLE), false));
    public static final DeferredItem<Item> COOKED_VENISON_MUSCLE = ITEMS.register("cooked_venison_muscle", registryName ->
            new ConsumableItem(foodItem(FoodValues.COOKED_VENISON_MUSCLE), false));
    public static final DeferredItem<Item> WALNUT_COOKIE = ITEMS.register("walnut_cookie", registryName ->
            new ConsumableItem(foodItem(FoodValues.WALNUT_COOKIE), false));
    public static final DeferredItem<Item> BILLHOOK_BASS_SLICE = ITEMS.register("billhook_bass_slice", registryName ->
            new ConsumableItem(foodItem(FoodValues.BILLHOOK_BASS_SLICE), false));
    public static final DeferredItem<Item> COOKED_BILLHOOK_BASS_SLICE = ITEMS.register("cooked_billhook_bass_slice", registryName ->
            new ConsumableItem(foodItem(FoodValues.COOKED_BILLHOOK_BASS_SLICE), false));
    public static final DeferredItem<Item> BILLHOOK_BASS_ROLL = ITEMS.register("billhook_bass_roll", registryName ->
            new ConsumableItem(foodItem(FoodValues.BILLHOOK_BASS_ROLL), false));
    public static final DeferredItem<Item> PICKLED_BRAINS = ITEMS.register("plated_pickled_brains", registryName ->
            new ConsumableItem(foodItem(FoodValues.PICKLED_BRAINS).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final DeferredItem<Item> PICKLED_BRAINS_ITEM = ITEMS.register("pickled_brains_block",()->
            new BlockItem(BlockReg.PICKLED_BRAINS.get(), basicItem().stacksTo(1)));
    public static final DeferredItem<Item> BOILED_CAVE_WEEDS = ITEMS.register("boiled_cave_weeds", registryName ->
            new ConsumableItem(bowlFoodItem(FoodValues.BOILED_CAVE_WEEDS).stacksTo(16), true));
    public static final DeferredItem<Item> RIVER_MEAL = ITEMS.register("river_meal", registryName ->
            new ConsumableItem(bowlFoodItem(FoodValues.RIVER_MEAL).stacksTo(16), true));
    public static final DeferredItem<Item> OLD_GOBLET = ITEMS.register("old_goblet",()->
            new BlockItem(BlockReg.OLD_GOBLET.get(), basicItem().stacksTo(64)));
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange", registryName ->
            new ConsumableItem(foodItem(FoodValues.ORANGE), false));
    public static final DeferredItem<Item> ORANGE_FRUIT_LEAVES = ITEMS.register("orange_fruit_leaves",()->
            new BlockItem(BlockReg.ORANGE_FRUIT_LEAVES.get(), basicItem()));
    public static final DeferredItem<Item> CHOCO_GLAZED_ORANGE = ITEMS.register("choco_glazed_orange", registryName ->
            new ConsumableItem(foodItem(FoodValues.CHOCO_GLAZED_ORANGE), false));
    public static final DeferredItem<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new DrinkableItem(drinkItem().food(FoodValues.ORANGE_JUICE), true, false));
    public static final DeferredItem<Item> ORANGE_CRATE_ITEM = ITEMS.register("orange_crate",()->
            new BlockItem(BlockReg.ORANGE_CRATE.get(), basicItem()));
    public static final DeferredItem<Item> CHOCOLATE_CAKE_SLICE = ITEMS.register("chocolate_cake_slice", registryName ->
            new ConsumableItem(foodItem(FoodValues.CHOCOLATE_CAKE_SLICE), false));
    public static final DeferredItem<Item> CHOCOLATE_CAKE_ITEM = ITEMS.register("chocolate_cake",()->
            new BlockItem(BlockReg.CHOCOLATE_CAKE.get(), basicItem().stacksTo(1)));
    public static final DeferredItem<Item> CHOCOLATE_TART = ITEMS.register("chocolate_tart", registryName ->
            new ConsumableItem(foodItem(FoodValues.CHOCOLATE_TART), false));
    public static final DeferredItem<Item> HORSE_SOUP_POT_ITEM = ITEMS.register("horse_soup_pot",()->
            new BlockItem(BlockReg.HORSE_SOUP_POT.get(), basicItem().stacksTo(1)));
    public static final DeferredItem<Item> KOZINAK = ITEMS.register("kozinak", registryName ->
            new ConsumableItem(foodItem(FoodValues.KOZINAK), true));
    public static final DeferredItem<Item> HORSE_WRAP = ITEMS.register("horse_wrap", registryName ->
            new ConsumableItem(bigFoodItem(FoodValues.HORSE_WRAP), false));
}


