package nl.esfokk.hexslates

import nl.esfokk.hexslates.config.HexslatesClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexslatesClient {
    fun init() {
        HexslatesClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(HexslatesClientConfig.GlobalConfig::class.java, parent).get()
    }
}
