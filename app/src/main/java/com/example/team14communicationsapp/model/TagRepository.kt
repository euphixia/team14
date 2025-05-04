package com.example.team14communicationsapp.model

import javax.inject.Inject

class TagRepository @Inject constructor() {

    fun getAllCategories(): Map<String, List<String>> =
        mapOf(
            "Clubs" to listOf(
                "Taekwondo",
                "App Dev",
                "CU Figure Skating",
                "URMC",
                "Paleontology Club"
            ),
            "Reason for Wanting to Connect" to listOf("Study Partner", "Friend", "Romantic"),
            "Hobbies/Interests" to listOf("Fitness", "Crochet"),
            "Current Classes" to listOf("Math 1910", "PSYCH 1101"),
            "Pre-Professional Track" to listOf("pre-med", "pre-law", "pre-dental"),
            "Nationality" to listOf("Uruguayan, French"),
            "Language" to listOf("Mandarin", "Polish")
        )
}

