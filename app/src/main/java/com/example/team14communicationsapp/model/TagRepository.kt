package com.example.team14communicationsapp.model

object TagRepository {
    // TODO get functions that actually work with the database
    // TODO functionality to add new options to each category (so sending new info to the database)
    val categories: List<String> = listOf(
        "Clubs",
        "Reason for Wanting to Connect",
        "Hobbies/Interests",
        "Current Classes",
        "Pre-Professional Track",
        "Nationality",
        "Language"
    )

    val categoriesMap: Map<String, List<String>> = mapOf(
        "Clubs" to listOf("Taekwondo", "App Dev", "CU Figure Skating", "URMC", "Paleontology Club"),
        "Reason for Wanting to Connect" to listOf("Study Partner", "Friend", "Romantic"),
        "Hobbies/Interests" to listOf("Fitness", "Crochet"),
        "Current Classes" to listOf("Math 1910", "PSYCH 1101"),
        "Pre-Professional Track" to listOf("pre-med", "pre-law", "pre-dental"),
        "Nationality" to listOf("Uruguayan, French"),
        "Language" to listOf("Mandarin", "Polish")
    )
}

