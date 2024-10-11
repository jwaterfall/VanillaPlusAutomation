package net.vanillaplusautomation.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.vanillaplusautomation.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class OreScannerItem extends Item {
    private Integer range;
    private Integer cooldown;

    public OreScannerItem(Settings settings, Integer range, Integer cooldown) {
        super(settings);
        this.range = range;
        this.cooldown = cooldown;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = Objects.requireNonNull(context.getPlayer());
            boolean foundBlock = false;

            for (int i = 0; i <= range; i++) {
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                if (isValuableBlock(blockBelow)) {
                    outputCoordinates(blockBelow, positionClicked.add(0, -i, 0), player);
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(Text.literal("No ores found below!"), false);
            }

            player.getItemCooldownManager().set(this, cooldown);
        }

        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    private boolean isValuableBlock(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.IRON_ORE || block == Blocks.GOLD_ORE
                || block == Blocks.REDSTONE_ORE || block == Blocks.LAPIS_ORE || block == Blocks.DIAMOND_ORE
                || block == Blocks.EMERALD_ORE || block == Blocks.NETHER_QUARTZ_ORE || block == Blocks.NETHER_GOLD_ORE || block == ModBlocks.RUBY_ORE
                || block == ModBlocks.SAPPHIRE_ORE || block == ModBlocks.PERIDOT_ORE
                || block == ModBlocks.ELECTROTINE_ORE || block == Blocks.DEEPSLATE_COAL_ORE || block == Blocks.DEEPSLATE_IRON_ORE || block == Blocks.DEEPSLATE_GOLD_ORE
                || block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE
                || block == Blocks.DEEPSLATE_EMERALD_ORE || block == ModBlocks.DEEPSLATE_RUBY_ORE
                || block == ModBlocks.DEEPSLATE_SAPPHIRE_ORE || block == ModBlocks.DEEPSLATE_PERIDOT_ORE
                || block == ModBlocks.DEEPSLATE_ELECTROTINE_ORE;
    }

    private void outputCoordinates(Block blockFound, BlockPos pos, PlayerEntity player) {
        player.sendMessage(Text.literal("Found " + blockFound.asItem().getName().getString() + " at(" + pos.getX()
                + ", " + pos.getY() + ", " + pos.getZ() + ")"), false);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Right-click a block to find ores below!"));
            tooltip.add(Text.literal("Range: " + range + " blocks").formatted(Formatting.AQUA));
            tooltip.add(Text.literal("Cooldown: " + cooldown + " ticks").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Hold shift for more info...").formatted(Formatting.AQUA));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
