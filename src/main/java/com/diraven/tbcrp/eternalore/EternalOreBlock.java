package com.diraven.tbcrp.eternalore;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class EternalOreBlock extends Block {
    public EternalOreBlock(Properties properties) {
        super(properties);
    }

    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        worldIn.setBlockState(pos, state, 1);
    }
}
