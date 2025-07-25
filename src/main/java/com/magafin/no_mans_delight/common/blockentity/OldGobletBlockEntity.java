package com.magafin.no_mans_delight.common.blockentity;

import com.magafin.no_mans_delight.common.register.BlockEntityReg;
import net.minecraft.core.BlockPos;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OldGobletBlockEntity extends BlockEntity {

    public OldGobletBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityReg.CHEFS_TROPHY.get(), pos, state);
    }
}
