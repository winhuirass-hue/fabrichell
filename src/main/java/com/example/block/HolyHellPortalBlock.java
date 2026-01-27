package com.example.block;

import com.example.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.text.Text;

public class HolyHellPortalBlock extends Block {
    public HolyHellPortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world.isClient) return;
        if (!(entity instanceof ServerPlayerEntity)) return;

        ServerPlayerEntity player = (ServerPlayerEntity) entity;
        ServerWorld destWorld = player.getServer().getWorld(ModDimensions.HOLY_HELL);
        if (destWorld == null) {
            player.sendMessage(Text.of("Holy Hell dimension is not available (missing datapack)"), false);
            return;
        }

        BlockPos spawn = destWorld.getSpawnPos();
        // Teleport player to the destination world's spawn position
        player.teleport(destWorld, spawn.getX() + 0.5, spawn.getY() + 1.0, spawn.getZ() + 0.5, player.getYaw(), player.getPitch());
        // Note: proper portal cooldown / collision handling is more involved; this is a minimal skeleton.
    }
}