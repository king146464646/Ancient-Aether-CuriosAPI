package net.builderdog.ancient_aether.attachments;

import com.aetherteam.nitrogen.attachment.INBTSynchable;
import com.aetherteam.nitrogen.network.packet.SyncEntityPacket;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import oshi.util.tuples.Quartet;

import java.util.function.Supplier;

public class AncientAetherPlayerSyncPacket extends SyncEntityPacket<AncientAetherPlayerAttachment> {
    public static final Type<AncientAetherPlayerSyncPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, "sync_ancient_aether_player_attachment"));

    public static final StreamCodec<RegistryFriendlyByteBuf, AncientAetherPlayerSyncPacket> STREAM_CODEC = CustomPacketPayload.codec(
        AncientAetherPlayerSyncPacket::write,
        AncientAetherPlayerSyncPacket::decode);

    public AncientAetherPlayerSyncPacket(Quartet<Integer, String, INBTSynchable.Type, Object> values) {
        super(values);
    }

    public AncientAetherPlayerSyncPacket(int playerID, String key, INBTSynchable.Type type, Object value) {
        super(playerID, key, type, value);
    }

    @Override
    public Type<AncientAetherPlayerSyncPacket> type() {
        return TYPE;
    }

    public static AncientAetherPlayerSyncPacket decode(RegistryFriendlyByteBuf buf) {
        return new AncientAetherPlayerSyncPacket(SyncEntityPacket.decodeEntityValues(buf));
    }

    @Override
    public Supplier<AttachmentType<AncientAetherPlayerAttachment>> getAttachment() {
        return AncientAetherDataAttachments.ANCIENT_AETHER_PLAYER;
    }

    public static void execute(AncientAetherPlayerSyncPacket payload, IPayloadContext context) {
        SyncEntityPacket.execute(payload, context.player());
    }
}
