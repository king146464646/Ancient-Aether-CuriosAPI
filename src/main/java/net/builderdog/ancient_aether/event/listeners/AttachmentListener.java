package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.event.hooks.AttachmentHooks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class AttachmentListener {

    public static void listen(IEventBus bus) {
        bus.addListener(AttachmentListener::onPlayerUpdate);
    }

    public static void onPlayerUpdate(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            AttachmentHooks.update(livingEntity);
        }
    }
}