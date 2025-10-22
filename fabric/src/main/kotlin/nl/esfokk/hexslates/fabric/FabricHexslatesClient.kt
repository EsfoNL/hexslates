package nl.esfokk.hexslates.fabric

import nl.esfokk.hexslates.HexslatesClient
import net.fabricmc.api.ClientModInitializer

object FabricHexslatesClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexslatesClient.init()
    }
}
