package net.builderdog.ancient_aether.attachments;

import net.builderdog.ancient_aether.AncientAether;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class AncientAetherDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, AncientAether.MODID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<AncientAetherPlayerAttachment>> ANCIENT_AETHER_PLAYER = ATTACHMENTS.register("aether_player", () -> AttachmentType.builder(AncientAetherPlayerAttachment::new).build());

    public static void registerPackets(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(AncientAether.MODID).versioned("1.0.0").optional();

        registrar.playBidirectional(AncientAetherPlayerSyncPacket.TYPE, AncientAetherPlayerSyncPacket.STREAM_CODEC, AncientAetherPlayerSyncPacket::execute);
    }
}
