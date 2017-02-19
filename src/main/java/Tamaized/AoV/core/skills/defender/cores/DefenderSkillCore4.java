package Tamaized.AoV.core.skills.defender.cores;

import java.util.ArrayList;
import java.util.List;

import Tamaized.AoV.AoV;
import Tamaized.AoV.core.abilities.AbilityBase;
import Tamaized.AoV.core.skills.AoVSkill;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class DefenderSkillCore4 extends AoVSkill {

	private static final ResourceLocation icon = new ResourceLocation(AoV.modid, "textures/skills/test.png");

	private static final List<AbilityBase> spells = new ArrayList<AbilityBase>();

	static {

	}

	public DefenderSkillCore4() {
		super(spells,

				TextFormatting.AQUA + "Defender Core 4",

				TextFormatting.RED + "Requires: Defender Core 3",

				TextFormatting.RED + "Requires: Level 12",

				"",

				TextFormatting.YELLOW + "You are now able to block all angles with your shield, not just in front of you."

		);
	}

	@Override
	public String getName() {
		return "DefenderSkillCore4";
	}

	@Override
	protected Buffs setupBuffs() {
		return new Buffs(0, 0, 0, 0, false);
	}

	@Override
	public ResourceLocation getIcon() {
		return icon;
	}

	@Override
	public boolean isClassCore() {
		return false;
	}

	@Override
	public AoVSkill getParent() {
		return AoVSkill.defender_core_3;
	}

	@Override
	public int getCost() {
		return 1;
	}

	@Override
	public int getLevel() {
		return 12;
	}

	@Override
	public int getSpentPoints() {
		return 0;
	}

}
