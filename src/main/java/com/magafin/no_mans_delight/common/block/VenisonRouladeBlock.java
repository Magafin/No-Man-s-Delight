package com.magafin.no_mans_delight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;


import java.util.function.Supplier;

import static net.minecraft.world.item.Items.BOWL;

public class VenisonRouladeBlock extends FeastBlock {
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    protected static final VoxelShape ROAST_SHAPE;

    public VenisonRouladeBlock(BlockBehaviour.Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
            super(properties, servingItem, hasLeftovers);

    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
            return (Integer)state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : ROAST_SHAPE;
    }

    static {
            ROAST_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4.0, 2.0, 4.0, 12.0, 10.0, 12.0), BooleanOp.OR);
    }
}
