@file:JvmName("HexslatesAbstractionsImpl")

package nl.esfokk.hexslates.forge

import nl.esfokk.hexslates.registry.HexslatesRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexslatesRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
