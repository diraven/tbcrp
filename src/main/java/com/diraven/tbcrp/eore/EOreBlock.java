package com.diraven.tbcrp.eore;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

public class EOreBlock extends Block {
    int cooldownSeconds;

    public EOreBlock(Properties properties) {
        super(properties);
        this.cooldownSeconds = 0;
    }

    public EOreBlock(Properties properties, int cooldownSeconds) {
        super(properties);
        this.cooldownSeconds = cooldownSeconds;
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        if (!worldIn.isRemote()) {
            EOreData eternaloresWorldSaveData = ((ServerWorld) worldIn.getWorld()).getSavedData().getOrCreate(EOreData::new, EOreData.ID);
            eternaloresWorldSaveData.scheduleBlockRespawn(pos, (EOreBlock) state.getBlock());
        }
    }
}
