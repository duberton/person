package com.duberton

import com.duberton.adapter.input.web.PersonRoute
import com.duberton.adapter.input.web.config.apiConfig
import com.duberton.adapter.output.mongodb.config.mongoConfig
import io.javalin.Javalin
import org.koin.core.KoinProperties
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject

class App : KoinComponent {

    private val personRoute: PersonRoute by inject()

    fun bootstrap() {
        val app = Javalin.create().start()
        startKoin(
            listOf(apiConfig, mongoConfig), KoinProperties(
                useEnvironmentProperties = false,
                useKoinPropertiesFile = true
            )
        )
        personRoute.handlers(app)
    }
}

fun main() {
    App().bootstrap()
}