package tamaized.aov.client.sound;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tamaized.aov.registry.SoundEvents;

@SideOnly(Side.CLIENT)
public class EntityMovingSound extends MovingSound {

	private final Entity entity;
	private float distance = 0.0F;

	public EntityMovingSound(SoundEvent sound, SoundCategory category, Entity e, boolean loop, int delay, float volume, float pitch) {
		super(sound, category);
		entity = e;
		repeat = loop;
		repeatDelay = delay;
		this.volume = volume;
		this.pitch = pitch;
	}

	@Override
	public void update() {
		if (entity == null || this.entity.isDead) {
			this.donePlaying = true;
		} else {
			this.xPosF = (float) this.entity.posX;
			this.yPosF = (float) this.entity.posY;
			this.zPosF = (float) this.entity.posZ;
			// float f = MathHelper.sqrt(this.entity.motionX * this.entity.motionX + this.entity.motionZ * this.entity.motionZ);
			//
			// if ((double) f >= 0.01D) {
			// this.distance = MathHelper.clamp(this.distance + 0.0025F, 0.0F, 1.0F);
			// this.volume = 0.0F + MathHelper.clamp(f, 0.0F, 0.5F) * 0.7F;
			// } else {
			// this.distance = 0.0F;
			// this.volume = 0.0F;
			// }
		}
	}
}
