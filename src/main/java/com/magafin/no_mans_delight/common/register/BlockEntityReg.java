package com.magafin.no_mans_delight.common.register;

import com.magafin.no_mans_delight.common.blockentity.OldGobletBlockEntity;
import com.magafin.no_mans_delight.register.BlockReg;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.magafin.no_mans_delight.No_mans_delight.MODID;

public class BlockEntityReg {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static final Supplier<BlockEntityType<OldGobletBlockEntity>> CHEFS_TROPHY =
            BLOCK_ENTITIES.register("old_goblet", () ->
                    BlockEntityType.Builder.of(OldGobletBlockEntity::new, BlockReg.OLD_GOBLET.get()).build(null));

}
