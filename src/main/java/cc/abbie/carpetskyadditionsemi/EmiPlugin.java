package cc.abbie.carpetskyadditionsemi;

import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiWorldInteractionRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class EmiPlugin implements dev.emi.emi.api.EmiPlugin {
    public static final String MODID = "csaemi";

    @Override
    public void register(EmiRegistry registry) {
        // Thick Potions Convert Stone into Deepslate
        registry.addRecipe(EmiWorldInteractionRecipe.builder()
                .id(new Identifier(MODID, "thick"))
                .leftInput(EmiStack.of(Items.STONE))
                .rightInput(EmiStack.of(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.THICK)), false)
                .output(EmiStack.of(Items.DEEPSLATE))
                .build());

        // Saplings Die on Sand
        registry.addRecipe(EmiWorldInteractionRecipe.builder()
                .id(new Identifier(MODID, "die"))
                .leftInput(EmiIngredient.of(ItemTags.SAPLINGS))
                .rightInput(EmiIngredient.of(ItemTags.SAND), true)
                .output(EmiStack.of(Items.DEAD_BUSH))
                .build());

        // Anvils Compact Coal into Diamonds
        registry.addRecipe(EmiWorldInteractionRecipe.builder()
                .id(new Identifier(MODID, "compact"))
                .leftInput(EmiStack.of(Items.COAL_BLOCK, 64))
                .rightInput(EmiStack.of(Items.ANVIL), true)
                .output(EmiStack.of(Items.DIAMOND))
                .build());
    }
}