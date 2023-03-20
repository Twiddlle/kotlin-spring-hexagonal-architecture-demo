package com.twiddle.playground.hexagonkotlinspring.config

import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils
import java.net.URL
import java.util.*

@Component()
class EnvLoader {

    private final val envFileUrl: URL = ResourceUtils.getURL("classpath:.env")
    final val envProps = Properties()

    init {
        envProps.load(envFileUrl.openStream())
    }
}
