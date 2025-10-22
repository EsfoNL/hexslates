package nl.esfokk.hexslates.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import nl.esfokk.hexslates.Hexslates
import nl.esfokk.hexslates.networking.HexslatesNetworking
import nl.esfokk.hexslates.networking.handler.applyOnClient
import nl.esfokk.hexslates.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HexslatesMessage

sealed interface HexslatesMessageC2S : HexslatesMessage {
    fun sendToServer() {
        HexslatesNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexslatesMessageS2C : HexslatesMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexslatesNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexslatesNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexslatesMessageCompanion<T : HexslatesMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Hexslates.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HexslatesMessageC2S -> msg.applyOnServer(ctx)
                    else -> Hexslates.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Hexslates.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexslatesMessageS2C -> msg.applyOnClient(ctx)
                    else -> Hexslates.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
