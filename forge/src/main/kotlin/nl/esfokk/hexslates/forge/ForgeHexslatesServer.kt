package nl.esfokk.hexslates.forge

import nl.esfokk.hexslates.Hexslates
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeHexslatesServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        Hexslates.initServer()
    }
}
