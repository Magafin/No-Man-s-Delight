package com.magafin.no_mans_delight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.function.Supplier;

public class StuffedShelfMushroomBlock extends FeastBlock {
    protected static final VoxelShape[] SHAPES;

    public StuffedShelfMushroomBlock(BlockBehaviour.Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);

    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[(Integer)state.getValue(SERVINGS)];
    }

    static {
        SHAPES = new VoxelShape[]{Block.box(2.0, 0.0, 2.0, 14.0, 1.0, 14.0), Block.box(2.0, 0.0, 2.0, 14.0, 2.0, 14.0), Block.box(2.0, 0.0, 2.0, 14.0, 4.0, 14.0), Block.box(2.0, 0.0, 2.0, 14.0, 6.0, 14.0), Block.box(2.0, 0.0, 2.0, 14.0, 8.0, 14.0)};
    }
}

