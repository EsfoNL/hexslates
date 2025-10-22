package nl.esfokk.hexslates

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import nl.esfokk.hexslates.config.HexslatesServerConfig
import nl.esfokk.hexslates.networking.HexslatesNetworking
import nl.esfokk.hexslates.registry.HexslatesActions

object Hexslates {
    const val MODID = "hexslates"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexslatesServerConfig.init()
        initRegistries(
            HexslatesActions,
        )
        HexslatesNetworking.init()
    }

    fun initServer() {
        HexslatesServerConfig.initServer()
    }
}
