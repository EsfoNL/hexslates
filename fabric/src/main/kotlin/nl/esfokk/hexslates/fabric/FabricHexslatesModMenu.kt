package nl.esfokk.hexslates.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import nl.esfokk.hexslates.HexslatesClient

object FabricHexslatesModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexslatesClient::getConfigScreen)
}
