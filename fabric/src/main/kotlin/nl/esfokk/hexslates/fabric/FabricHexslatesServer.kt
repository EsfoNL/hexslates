package nl.esfokk.hexslates.fabric

import nl.esfokk.hexslates.Hexslates
import net.fabricmc.api.DedicatedServerModInitializer

object FabricHexslatesServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        Hexslates.initServer()
    }
}
