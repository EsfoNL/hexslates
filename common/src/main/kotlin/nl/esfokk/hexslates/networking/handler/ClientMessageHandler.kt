package nl.esfokk.hexslates.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import nl.esfokk.hexslates.config.HexslatesServerConfig
import nl.esfokk.hexslates.networking.msg.*

fun HexslatesMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HexslatesServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
