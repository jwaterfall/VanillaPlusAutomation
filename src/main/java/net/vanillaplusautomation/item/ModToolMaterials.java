package net.vanillaplusautomation.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterials implements ToolMaterial {
    RUBY(MiningLevels.IRON, 750, 7.0F, 2.0F, 12, Ingredient.ofItems(ModItems.RUBY)),
    SAPPHIRE(MiningLevels.IRON, 750, 7.0F, 2.0F, 12, Ingredient.ofItems(ModItems.SAPPHIRE)),
    PERIDOT(MiningLevels.IRON, 750, 7.0F, 2.0F, 12, Ingredient.ofItems(ModItems.PERIDOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
            int enchantability, Ingredient repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
