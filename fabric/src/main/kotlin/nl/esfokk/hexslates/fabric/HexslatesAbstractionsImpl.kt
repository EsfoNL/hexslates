@file:JvmName("HexslatesAbstractionsImpl")

package nl.esfokk.hexslates.fabric

import nl.esfokk.hexslates.registry.HexslatesRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexslatesRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
