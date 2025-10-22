@file:JvmName("HexslatesAbstractions")

package nl.esfokk.hexslates

import dev.architectury.injectables.annotations.ExpectPlatform
import nl.esfokk.hexslates.registry.HexslatesRegistrar

fun initRegistries(vararg registries: HexslatesRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexslatesRegistrar<T>) {
    throw AssertionError()
}
