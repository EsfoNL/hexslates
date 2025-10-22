package nl.esfokk.hexslates.fabric

import nl.esfokk.hexslates.Hexslates
import net.fabricmc.api.ModInitializer

object FabricHexslates : ModInitializer {
    override fun onInitialize() {
        Hexslates.init()
    }
}
