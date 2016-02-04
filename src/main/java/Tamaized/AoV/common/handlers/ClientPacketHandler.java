package Tamaized.AoV.common.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import Tamaized.AoV.AoV;
import Tamaized.AoV.core.AoVCoreClient;
import Tamaized.AoV.core.AoVData;
import Tamaized.AoV.core.skills.AoVSkill;
import Tamaized.AoV.gui.client.AoVSkillsGUI;

public class ClientPacketHandler{
	
	public static final int TYPE_COREDATA = 0;
	public static final int TYPE_UPDATE_DIVINEPOWER = 1;
	public static final int TYPE_SKILL_CHECK_CANOBTAIN = 2;
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onClientPacket(ClientCustomPacketEvent event) {
		try {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ByteBufInputStream bbis = new ByteBufInputStream(event.packet.payload());
			processPacketOnClient(event.packet.payload(), Side.CLIENT);
			bbis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void processPacketOnClient(ByteBuf parBB, Side parSide) throws IOException{
		World theWorld = Minecraft.getMinecraft().theWorld;
		if (parSide == Side.CLIENT){
			ByteBufInputStream bbis = new ByteBufInputStream(parBB);
			int pktType = bbis.readInt();
			switch(pktType){
				case TYPE_COREDATA:
					String encodedPacket = bbis.readUTF();
					if(AoV.clientAoVCore == null) AoV.clientAoVCore = new AoVCoreClient();
					AoV.clientAoVCore.setPlayer(null, AoVData.fromPacket(encodedPacket));
					break;
				case TYPE_UPDATE_DIVINEPOWER: //We assume clientAoVCore is not null, if it is then something is seriously wrong
					AoV.clientAoVCore.getPlayer(null).setCurrentDivinePower(bbis.readInt());
					AoV.clientAoVCore.getPlayer(null).setMaxDivinePower(bbis.readInt());
					break;
				case TYPE_SKILL_CHECK_CANOBTAIN:
					System.out.println("Packet recieved for TYPE_SKILL_CHECK_CANOBTAIN");
					boolean flag = bbis.readBoolean();
					String skill = bbis.readUTF();
					System.out.println(flag+" : "+skill+" : "+AoVSkillsGUI.instance);
					if(AoVSkillsGUI.instance != null) AoVSkillsGUI.spooler.put(skill, flag);
					AoVSkillsGUI.doRefresh = true;
					break;
				default:
					break;
			}
			bbis.close();   
		}
	}
}


