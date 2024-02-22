package top.xinstudio.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import top.xinstudio.ElytraSynthesisMod;

public class ModItemGroup {
    public static final ItemGroup SILVER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ElytraSynthesisMod.MOD_ID, "elytra"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.elytra"))
                    .icon(() -> new ItemStack(ModItems.FULL_ELYTRA)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ELYTRA_FRAGMENT);
                        entries.add(ModItems.FULL_ELYTRA);
                    }).build());

    public static void registerModItemGroup(){
        ElytraSynthesisMod.LOGGER.debug("注册mod项目组:"+ ElytraSynthesisMod.MOD_ID);
    }
}
