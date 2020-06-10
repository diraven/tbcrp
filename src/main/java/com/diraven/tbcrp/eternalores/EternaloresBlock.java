package com.diraven.tbcrp.eternalores;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class EternaloresBlock extends Block {
    int cooldownSeconds;

    public EternaloresBlock(Properties properties) {
        super(properties);
        this.cooldownSeconds = 0;
    }
    public EternaloresBlock(Properties properties, int cooldownSeconds) {
        super(properties);
        this.cooldownSeconds = cooldownSeconds;
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        worldIn.setBlockState(pos, state, 1);
    }
}
