package com.magafin.no_mans_delight.common.block;

import com.magafin.no_mans_delight.common.blockentity.OldGobletBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModEffects;

import javax.annotation.Nullable;
import java.util.List;

public class OldGobletBlock extends BaseEntityBlock {

    public static final IntegerProperty EFFIGIES = IntegerProperty.create("effigies", 1, 4);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected static final VoxelShape Z_ONE_AABB = Block.box(5.5, 0, 5.5, 10.5, 8, 10.5);
    protected static final VoxelShape Z_TWO_AABB = Block.box(2, 0, 5.5, 14, 8, 10.5);
    protected static final VoxelShape Z_FULL_AABB = Block.box(2, 0, 2, 14, 8, 14);
    protected static final VoxelShape X_ONE_AABB = Block.box(5.5, 0, 5.5, 10.5, 8, 10.5);
    protected static final VoxelShape X_TWO_AABB = Block.box(5.5, 0, 2, 10.5, 8, 14);
    protected static final VoxelShape X_FULL_AABB = Block.box(2, 0, 2, 14, 8, 14);


    public OldGobletBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(EFFIGIES, 1));


    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(OldGobletBlock::new);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockEntity blockEntity = context.getLevel().getBlockEntity(context.getClickedPos());
        BlockState state;
        if (blockEntity != null) {
            state = blockEntity.getBlockState();
        } else {
            state = context.getLevel().getBlockState(context.getClickedPos());
        }

        if (state.is(this)) {
            return state.setValue(EFFIGIES, Math.min(4, state.getValue(EFFIGIES) + 1));
        }

        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int range = getRange(state);
        AABB area = new AABB(
                pos.getX() - 2*range,
                pos.getY() - 2*range,
                pos.getZ() - 2*range,
                pos.getX() + 2*range,
                pos.getY() + 2*range,
                pos.getZ() + 2*range
        );

        List<Player> players = level.getEntitiesOfClass(Player.class, area);
        for (Player player : players) {
            if (player.getHealth() < player.getMaxHealth()) {
                player.addEffect(new MobEffectInstance(
                        ModEffects.COMFORT,
                        80,
                        0,
                        false,
                        false,
                        false
                ));
            }
        }


        level.scheduleTick(pos, this, 60);
        super.tick(state, level, pos, random);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!level.isClientSide) {
            level.scheduleTick(pos, this, 20);
        }
        super.onPlace(state, level, pos, oldState, movedByPiston);
    }

    public static int getRange(BlockState state) {
        int i = state.getValue(EFFIGIES);
        return 1+i;
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return !state.getCollisionShape(level, pos).getFaceShape(Direction.UP).isEmpty() || state.isFaceSturdy(level, pos, Direction.UP);
    }

    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(EFFIGIES)) {
            default -> switch (state.getValue(FACING)) {
                default -> Z_ONE_AABB;
                case EAST, WEST -> X_ONE_AABB;
            };
            case 2 -> switch (state.getValue(FACING)) {
                default -> Z_TWO_AABB;
                case EAST, WEST -> X_TWO_AABB;
            };
            case 3, 4 -> switch (state.getValue(FACING)) {
                default -> Z_FULL_AABB;
                case EAST, WEST -> X_FULL_AABB;
            };
        };
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, EFFIGIES);
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand().is(this.asItem()) && state.getValue(EFFIGIES) < 4 || super.canBeReplaced(state, useContext);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OldGobletBlockEntity(pos, state);
    }

}

