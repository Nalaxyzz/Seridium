package fr.hyridiumdev.seridium.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import java.util.Map;

import fr.hyridiumdev.seridium.item.SmeltPickaxeSeridiumItem;
import fr.hyridiumdev.seridium.SeridiumMod;

public class SmeltprocedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SeridiumMod.LOGGER.warn("Failed to load dependency world for procedure Smeltprocedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SeridiumMod.LOGGER.warn("Failed to load dependency x for procedure Smeltprocedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SeridiumMod.LOGGER.warn("Failed to load dependency y for procedure Smeltprocedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SeridiumMod.LOGGER.warn("Failed to load dependency z for procedure Smeltprocedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean removeBlock = false;
		if (SmeltPickaxeSeridiumItem.block.canHarvestBlock((world.getBlockState(new BlockPos(x, y, z)))) == true) {
			if (!(((world instanceof World && ((World) world).getRecipeManager()
					.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
							((World) world))
					.isPresent())
							? ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), (World) world)
									.get().getRecipeOutput().copy()
							: ItemStack.EMPTY)
					.getItem() == Blocks.AIR.asItem())) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				removeBlock = (true);
			} else {
				removeBlock = (false);
			}
			if (removeBlock == true) {
				world.destroyBlock(new BlockPos(x, y, z), false);
			} else {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z), false);
				}
			}
		}
	}
}
