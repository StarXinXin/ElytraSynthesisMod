package top.xinstudio.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import top.xinstudio.ElytraSynthesisMod;
import top.xinstudio.registry.ModItems;

public class FullElytraItem extends ArmorItem {
    public FullElytraItem(ArmorMaterial material, EquipmentSlot.Type slotType, Item.Settings settings) {
        super(material, convertSlotType(slotType), settings);
    }

    private static EquipmentSlot convertSlotType(EquipmentSlot.Type slotType) {
        switch (slotType) {
            slot HEAD:
                return EquipmentSlot.HEAD;
            case CHEST:
                return EquipmentSlot.CHEST;
            case LEGS:
                return EquipmentSlot.LEGS;
            case FEET:
                return EquipmentSlot.FEET;
            default:
                throw new IllegalArgumentException("Invalid slot type: " + slotType);
        }
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // 如果佩戴者为玩家且正在使用鞘翅滑翔，则降低耐久度
        if (entity instanceof PlayerEntity && ((PlayerEntity) entity).isUsingRiptide()) {
            stack.damage(1, (LivingEntity) entity, (livingEntity) -> {
                ((PlayerEntity) livingEntity).sendEquipmentBreakStatus(EquipmentSlot.CHEST);
            });
        }
    }


    // 自定义材料，你可以根据需要调整
    public static class ElytraArmorMaterial implements net.minecraft.item.ArmorMaterial {
        public static final ElytraArmorMaterial FULL_ELYTRA = new ElytraArmorMaterial();

        @Override
        public int getDurability(Type type) {
            return 432;
        }

        @Override
        public int getProtection(Type type) {
            return 0;
        }

        @Override
        public int getEnchantability() {
            return 0; // 附魔值
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC; // 装备时的音效
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.ELYTRA_FRAGMENT); // 修复材料
        }


        @Override
        public String getName() {
            return ElytraSynthesisMod.MOD_ID + ":full_elytra"; // 材料名称
        }

        @Override
        public float getToughness() {
            return 0; // 韧性
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    }
}
