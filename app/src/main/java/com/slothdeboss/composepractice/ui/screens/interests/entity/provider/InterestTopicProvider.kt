package com.slothdeboss.composepractice.ui.screens.interests.entity.provider

import com.slothdeboss.composepractice.ui.screens.interests.entity.InterestTopic

object InterestTopicProvider {

    fun provideTopics(): List<InterestTopic> {
        return listOf(
            InterestTopic(name = "MVVM"),
            InterestTopic(name = "MVI"),
            InterestTopic(name = "Jetpack compose"),
            InterestTopic(name = "RxJava/RxKotlin"),
            InterestTopic(name = "Kotlin coroutines"),
            InterestTopic(name = "Room"),
            InterestTopic(name = "Realm"),
            InterestTopic(name = "Retrofit"),
            InterestTopic(name = "Ktor"),
            InterestTopic(name = "WorkManager"),
            InterestTopic(name = "Navigation component"),
            InterestTopic(name = "Android View"),
            InterestTopic(name = "Data binding"),
            InterestTopic(name = "Dagger/Hilt"),
            InterestTopic(name = "Koin"),
        )
    }
}