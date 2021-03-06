package tamaized.aov.common.core.skills.defender.cores;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import tamaized.aov.common.core.abilities.AbilityBase;
import tamaized.aov.common.core.skills.AoVSkill;
import tamaized.aov.common.core.skills.SkillIcons;

import java.util.List;

public class DefenderSkillCore1 extends AoVSkill {

	private static final List<AbilityBase> spells = Lists.newArrayList();

	private static final int COST = 1;
	private static final int LEVEL = 0;
	private static final int SPENT = 0;
	private static final int CHARGES = 1;
	private static final int SPELLPOWER = 0;
	private static final int DODGE = 5;
	private static final int DOUBLESTRIKE = 0;
	private static final boolean SELECTIVE_FOCUS = false;

	static {

	}

	public DefenderSkillCore1() {
		super(spells,

				new TextComponentTranslation("aov.skill.defender.core.1.name"),

				new TextComponentTranslation("aov.skill.global.core"),

				new TextComponentTranslation(""),

				new TextComponentTranslation("aov.skill.global.charge", CHARGES),

				new TextComponentTranslation("aov.skill.global.dodge", DODGE)


		);
	}

	@Deprecated
	public String getName() {
		return "DefenderSkillCore1";
	}

	@Override
	public int getCharges() {
		return CHARGES;
	}

	@Override
	public int getSpellPower() {
		return SPELLPOWER;
	}

	@Override
	public int getDodge() {
		return DODGE;
	}

	@Override
	public int getDoubleStrike() {
		return DOUBLESTRIKE;
	}

	@Override
	public boolean grantsSelectiveFocus() {
		return SELECTIVE_FOCUS;
	}

	@Override
	public ResourceLocation getIcon() {
		return SkillIcons.dodge;
	}

	@Override
	public boolean isClassCore() {
		return true;
	}

	@Override
	public AoVSkill getParent() {
		return null;
	}

	@Override
	public int getCost() {
		return COST;
	}

	@Override
	public int getLevel() {
		return LEVEL;
	}

	@Override
	public int getSpentPoints() {
		return SPENT;
	}

}
