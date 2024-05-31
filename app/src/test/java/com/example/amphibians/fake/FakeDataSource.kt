package com.example.amphibians.fake

import com.example.amphibians.data.Amphibian
import kotlinx.serialization.SerialName

object FakeDataSource {
    const val nameOne = "Great Basin Spadefoot"
    const val nameTwo = "California Giant Salamander"
    const val nameThree = "Blue Jeans Frog"
    const val typeOne = "Toad"
    const val typeTwo = "Salamander"
    const val typeThree = "Frog"
    const val descriptionOne = "This toad spends most of its life underground."
    const val descriptionTwo = "This salamander can be found in Northern California."
    const val descriptionThree =
        "This little amphibian is identifiable by its bright red body \" +\n" +
                "                    \"and blueish-purple arms and legs."
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    const val imgThree = "url.3"

    val amphibiansList = listOf(
        Amphibian(
            name = "Great Basin Spadefoot",
            type = "Toad",
            description = "This toad spends most of its life underground.",
            imgSrc = ""
        ),
        Amphibian(
            name = "California Giant Salamander",
            type = "Salamander",
            description = "This salamander can be found in Northern California.",
            imgSrc = ""
        ),
        Amphibian(
            name = "Blue Jeans Frog",
            type = "Frog",
            description = "This little amphibian is identifiable by its bright red body " +
                    "and blueish-purple arms and legs.",
            imgSrc = ""
        )
    )
}