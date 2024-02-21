
package fr.hyridiumdev.seridium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fr.hyridiumdev.seridium.itemgroup.SeridiumtabItemGroup;
import fr.hyridiumdev.seridium.SeridiumModElements;

@SeridiumModElements.ModElement.Tag
public class PrismaItem extends SeridiumModElements.ModElement {
	@ObjectHolder("seridium:prisma")
	public static final Item block = null;

	public PrismaItem(SeridiumModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SeridiumtabItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("prisma");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
