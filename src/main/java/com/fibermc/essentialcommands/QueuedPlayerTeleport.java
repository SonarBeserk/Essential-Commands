package com.fibermc.essentialcommands;

import com.fibermc.essentialcommands.access.ServerPlayerEntityAccess;
import com.fibermc.essentialcommands.types.MinecraftLocation;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class QueuedPlayerTeleport extends QueuedTeleport {

    private final ServerPlayerEntity targetPlayer;

    public QueuedPlayerTeleport(PlayerData playerData, ServerPlayerEntity targetPlayer, Text destName) {
        super(playerData, destName);
        this.targetPlayer = targetPlayer;
    }

    public QueuedPlayerTeleport(PlayerData playerData, ServerPlayerEntity targetPlayer, Text destName, int delay) {
        super(playerData, destName, delay);
        this.targetPlayer = targetPlayer;
    }

    public QueuedPlayerTeleport(ServerPlayerEntity teleportingPlayer, ServerPlayerEntity destinationPlayer) {
        super(((ServerPlayerEntityAccess) teleportingPlayer).getEcPlayerData(), destinationPlayer.getDisplayName());
        this.targetPlayer = destinationPlayer;
    }

    public MinecraftLocation getDest() {
        return new MinecraftLocation(targetPlayer);
    }
}
