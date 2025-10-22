package nl.esfokk.hexslates.networking

import dev.architectury.networking.NetworkChannel
import nl.esfokk.hexslates.Hexslates
import nl.esfokk.hexslates.networking.msg.HexslatesMessageCompanion

object HexslatesNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Hexslates.id("networking_channel"))

    fun init() {
        for (subclass in HexslatesMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
