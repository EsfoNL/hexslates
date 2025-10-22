package nl.esfokk.hexslates.forge

import dev.architectury.platform.forge.EventBuses
import nl.esfokk.hexslates.Hexslates
import nl.esfokk.hexslates.forge.datagen.ForgeHexslatesDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hexslates.MODID)
class ForgeHexslates {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hexslates.MODID, this)
            addListener(ForgeHexslatesClient::init)
            addListener(ForgeHexslatesDatagen::init)
            addListener(ForgeHexslatesServer::init)
        }
        Hexslates.init()
    }
}
