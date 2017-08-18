package tamaized.aov.common.core.skills.caster.tier4;

import tamaized.aov.common.core.abilities.AbilityBase;
import tamaized.aov.common.core.skills.AoVSkill;
import tamaized.aov.common.core.skills.SkillIcons;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.List;

public class CasterSkillT4S5 extends AoVSkill {

	private static final List<AbilityBase> spells = new ArrayList<AbilityBase>();

	static {

	}

	public CasterSkillT4S5() {
		super(spells,

				TextFormatting.AQUA + "Selective Focus",

				TextFormatting.RED + "Requires: 12 Points Spent in Tree",

				"",

				TextFormatting.DARK_PURPLE + "Your Spells no longer",

				TextFormatting.DARK_PURPLE + "affect Monsters if they",

				TextFormatting.DARK_PURPLE + "benefit from the Spell",

				TextFormatting.DARK_PURPLE + "or Friendly Players/Creatures",

				TextFormatting.DARK_PURPLE + "if they would be harmed by the spell."

		);
	}

	@Override
	public String getName() {
		return "CasterSkillT4S5";
	}

	@Override
	protected Buffs setupBuffs() {
		return new Buffs(0, 0, 0, 0, true);
	}

	@Override
	public ResourceLocation getIcon() {
		return SkillIcons.selectiveFocus;
	}

	@Override
	public boolean isClassCore() {
		return false;
	}

	@Override
	public AoVSkill getParent() {
		return AoVSkill.caster_core_1;
	}

	@Override
	public int getCost() {
		return 1;
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public int getSpentPoints() {
		return 12;
	}

}