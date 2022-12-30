package cc.abbie.carpetskyadditionsemi;

import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiWorldInteractionRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;

public class EmiPlugin implements dev.emi.emi.api.EmiPlugin {
    public static final String MODID = "csaemi";

    @Override
    public void register(EmiRegistry registry) {
        // Thick Potions Convert Stone into Deepslate
        registry.addRecipe(EmiWorldInteractionRecipe.builder()
                .id(new ResourceLocation(MODID, "thick"))
                .leftInput(EmiStack.of(Items.STONE))
                .rightInput(EmiStack.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.THICK)), false)
                .output(EmiStack.of(Items.DEEPSLATE))
                .build());

        // Saplings Die on Sand
        registry.addRecipe(EmiWorldInteractionRecipe.builder()
                .id(new ResourceLocation(MODID, "die"))
                .leftInput(EmiIngredient.of(ItemTags.SAPLINGS))
                .rightInput(EmiIngredient.of(ItemTags.SAND), true)
                .output(EmiStack.of(Items.DEAD_BUSH))
                .build());

        // Anvils Compact Coal into Diamonds
        registry.addRecipe(EmiWorldInteractionRecipe.builder()
                .id(new ResourceLocation(MODID, "compact"))
                .leftInput(EmiStack.of(Items.COAL_BLOCK, 64))
                .rightInput(EmiStack.of(Items.ANVIL), true)
                .output(EmiStack.of(Items.DIAMOND))
                .build());
    }
}