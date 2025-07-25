package com.magafin.no_mans_delight.common.block;

import com.magafin.no_mans_delight.common.register.DamageReg;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.Random;
import java.util.function.Supplier;

import static com.magafin.no_mans_delight.No_mans_delight.MODID;

public class PickledBrainsBlock extends FeastBlock {
    protected static final VoxelShape SHAPES = Block.box(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
    public static final IntegerProperty HUNGER=IntegerProperty.create("hunger",0,12);
    public PickledBrainsBlock(BlockBehaviour.Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
        this.registerDefaultState(this.defaultBlockState().setValue(HUNGER,0));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HUNGER);
        super.createBlockStateDefinition(builder);
    }

    public int getMaxServings() {
        return 3;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES;
    }
    @Override
    protected ItemInteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        if(super.takeServing(level, pos, state, player, hand).result().consumesAction()){
            BrainDamage(player,1,pos);
            return ItemInteractionResult.SUCCESS;
        }
        if(state.getValue(SERVINGS)<3){
            if(player.getItemInHand(hand).is(Tags.Items.FOODS_RAW_MEAT)){
                BlockState newState;
                if(state.getValue(HUNGER)+player.getItemInHand(hand).getFoodProperties(player).nutrition()<10){
                    newState =state.setValue(HUNGER,state.getValue(HUNGER)+player.getItemInHand(hand).getFoodProperties(player).nutrition());
                }
                else{
                    int HungerLevel=0;
                    int nutrition=player.getItemInHand(hand).getFoodProperties(player).nutrition();
                    while(state.getValue(HUNGER)+nutrition>10){
                        HungerLevel++;
                        nutrition=nutrition-5;
                    }
                    while (state.getValue(SERVINGS)+HungerLevel>3){
                        HungerLevel--;
                    }
                    newState =state.setValue(HUNGER,state.getValue(HUNGER)+nutrition).setValue(SERVINGS,state.getValue(SERVINGS)+HungerLevel);
                }
                level.setBlock(pos,newState,UPDATE_ALL);
                player.getItemInHand(hand).shrink(1);
                return ItemInteractionResult.CONSUME;
            }
        }
        return ItemInteractionResult.FAIL;
    }
    public void BrainDamage(LivingEntity entity, float amount,BlockPos pos){
        entity.level().playLocalSound(pos, SoundEvents.ZOMBIE_AMBIENT, SoundSource.BLOCKS,0.8f,1.2f,true);
        entity.hurt(DamageReg.getSimpleDamageSource(entity.level(),DamageReg.ZOMBIE_HEAD,pos), amount);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        level.playLocalSound(pos, SoundEvents.ZOMBIE_AMBIENT, SoundSource.BLOCKS,0.8f,1.2f,true);
        super.onPlace(state, level, pos, oldState, movedByPiston);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        level.playLocalSound(pos, SoundEvents.ZOMBIE_HURT, SoundSource.BLOCKS,0.8f,1.2f,true);
        super.fallOn(level, state, pos, entity, fallDistance);
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        level.playLocalSound(hit.getBlockPos(), SoundEvents.ZOMBIE_HURT, SoundSource.BLOCKS,0.8f,1.2f,true);
        super.onProjectileHit(level, state, hit, projectile);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        level.playLocalSound(pos, SoundEvents.ZOMBIE_DEATH, SoundSource.BLOCKS,0.8f,1.2f,true);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.playLocalSound(pos, SoundEvents.ZOMBIE_AMBIENT, SoundSource.BLOCKS,0.8f,1.2f,true);
        super.randomTick(state, level, pos, random);
    }


}
