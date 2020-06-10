package com.diraven.tbcrp;

import net.minecraft.util.math.BlockPos;

public class Utils {

    public static String BlockPosToString(BlockPos blockPos) {
        return String.join(
                " ",
                String.valueOf(blockPos.getX()),
                String.valueOf(blockPos.getY()),
                String.valueOf(blockPos.getZ())
        );
    }
    public static BlockPos StringToBlockPos(String pos) {
        String[] result = pos.split(" ");
        return new BlockPos(
                Integer.parseInt(result[0]),
                Integer.parseInt(result[1]),
                Integer.parseInt(result[2])
        );
    }
}
