package com.magafin.no_mans_delight.common.block;

import com.magafin.no_mans_delight.register.BlockReg;
import com.farcr.nomansland.common.registry.items.NMLItems;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public enum OrangeFruit {

    ORANGE_FRUIT(BlockReg.ORANGE_FRUIT, BlockReg.ORANGE_FRUIT_LEAVES, Blocks.JUNGLE_LEAVES.defaultBlockState().getBlockHolder(), 3, com.magafin.no_mans_delight.register.ItemReg.ORANGE, new VoxelShape[]{
            Block.box(5.5, 11, 6.5, 10.5, 15, 11.5),
            Block.box(5.5, 11, 6.5, 10.5, 15, 11.5),
            Block.box(5, 10, 6, 11, 15, 12),
            Block.box(5, 10, 6, 11, 15, 12),
            Block.box(5, 10, 6, 11, 15, 12)
    });

    private final Holder<Block> fruit;
    private final Holder<Block> fruitLeaves;
    private final Holder<Block> leaves;
    private final int growthSpeed;
    private final Holder<Item> fruitDrops;
    private final VoxelShape[] shapesByAge;

    OrangeFruit(Holder<Block> fruit, Holder<Block> fruitLeaves, Holder<Block> leaves, int growthSpeed, Holder<Item> fruitDrops, VoxelShape[] shapesByAge) {
        this.fruit = fruit;
        this.fruitLeaves = fruitLeaves;
        this.leaves = leaves;
        this.growthSpeed = growthSpeed;
        this.fruitDrops = fruitDrops;
        this.shapesByAge = shapesByAge;
    }

    public Holder<Block> getFruitBlock() {
        return fruit;
    }
    public Holder<Block> getFruitLeaves() {
        return fruitLeaves;
    }
    public Holder<Block> getLeaves() {
        return leaves;
    }
    public int getGrowthSpeed() {
        return growthSpeed;
    }
    public Holder<Item> getFruitDrops() {
        return fruitDrops;
    }
    public VoxelShape[] getShapesByAge() {
        return shapesByAge;
    }
}