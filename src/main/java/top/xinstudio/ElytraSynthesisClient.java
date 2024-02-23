package top.xinstudio;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import top.xinstudio.registry.ModItems;

public class ElytraSynthesisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


    }


    //注册鞘翅物品模型
    public static void registerModelPredicates() {
        FabricModelPredicateProviderRegistry.register(ModItems.FULL_ELYTRA, new Identifier(ElytraSynthesisMod.MOD_ID, "full_elytra"), ((stack, world, entity, seed) ->
                stack.getItem() == ModItems.FULL_ELYTRA && isUsable(stack) ? 0.0F : 1.0F));
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamage() < stack.getMaxDamage() - 1;
    }
}