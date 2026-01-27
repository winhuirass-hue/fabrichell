package com.example;

import com.example.block.HolyHellPortalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block HOLY_HELL_PORTAL = new HolyHellPortalBlock(Block.Settings.of(Material.METAL).noCollision().strength(-1.0F, 3600000.0F));

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(ExampleMod.MOD_ID, "holy_hell_portal"), HOLY_HELL_PORTAL);
        Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, "holy_hell_portal"), new BlockItem(HOLY_HELL_PORTAL, new Item.Settings()));
    }
}