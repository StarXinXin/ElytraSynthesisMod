package top.xinstudio.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import top.xinstudio.ElytraSynthesisMod;

public class ModItems {
    //需添加的物品
    //加入鞘翅碎片与完整鞘翅
    public static final Item ELYTRA_FRAGMENT = registerItem("elytra_fragment", new Item(new FabricItemSettings()));
    public static final Item FULL_ELYTRA = registerItem("full_elytra",  new ElytraItem(new Item.Settings().maxDamage(432).rarity(Rarity.UNCOMMON)));
    // 注册
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ElytraSynthesisMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ElytraSynthesisMod.LOGGER.info("注册Mod项目 " + ElytraSynthesisMod.MOD_ID);
    }


}
