
package fr.hyridiumdev.seridium.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.hyridiumdev.seridium.block.SeridiumBlockBlock;
import fr.hyridiumdev.seridium.SeridiumModElements;

@SeridiumModElements.ModElement.Tag
public class SeridiumtabItemGroup extends SeridiumModElements.ModElement {
	public SeridiumtabItemGroup(SeridiumModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabseridiumtab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SeridiumBlockBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
