package com.magafin.no_mans_delight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

public class ChocolateCakeBlock extends PieBlock {
    public static final DirectionProperty FACING;
    public static final IntegerProperty BITES;
    protected static final VoxelShape SHAPE;

    public ChocolateCakeBlock(Properties properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    static  {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        BITES = IntegerProperty.create("bites", 0, 3);
        SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
    }
}
