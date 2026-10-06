package com.example.data

enum class KhamCategory(
    val titleKham: String,
    val titleNepali: String,
    val titleEnglish: String,
    val iconName: String
) {
    GREETINGS(
        titleKham = "झोर्ले र शिष्टाचार",
        titleNepali = "अभिवादन र शिष्टाचार",
        titleEnglish = "Greetings & Basics",
        iconName = "waving_hand"
    ),
    NUMBERS(
        titleKham = "गन्ती र संख्या",
        titleNepali = "संख्या र गणना",
        titleEnglish = "Numbers & Counting",
        iconName = "pin"
    ),
    FAMILY(
        titleKham = "झिमका मान्छे र परिवार",
        titleNepali = "परिवार र नातागोता",
        titleEnglish = "Family & Relations",
        iconName = "groups"
    ),
    FOOD(
        titleKham = "झ्या र खानपान",
        titleNepali = "खाना र परिकार",
        titleEnglish = "Food & Traditional Dining",
        iconName = "restaurant"
    ),
    NATURE(
        titleKham = "सा, नाम र जनावर",
        titleNepali = "प्रकृति र वन्यजन्तु",
        titleEnglish = "Nature & Wildlife",
        iconName = "forest"
    ),
    CONVERSATION(
        titleKham = "दैनिक खाम् कुरा",
        titleNepali = "दैनिक कुराकानी",
        titleEnglish = "Daily Conversations",
        iconName = "forum"
    ),
    VERBS(
        titleKham = "काम र क्रियापद",
        titleNepali = "काम र क्रियापदहरू",
        titleEnglish = "Verbs & Actions",
        iconName = "directions_run"
    ),
    BODY(
        titleKham = "जिउ र अङ्ग",
        titleNepali = "शरीरका अङ्गहरू",
        titleEnglish = "Body Parts",
        iconName = "accessibility"
    ),
    TIME(
        titleKham = "दिन, बार र समय",
        titleNepali = "समय, बार र ऋतु",
        titleEnglish = "Time & Seasons",
        iconName = "schedule"
    ),
    CULTURE(
        titleKham = "भुमे र परम्परा",
        titleNepali = "संस्कृति र परम्परा",
        titleEnglish = "Culture & Heritage",
        iconName = "celebration"
    )
}

data class KhamItem(
    val id: String,
    val khamDevanagari: String,
    val khamRoman: String,
    val nepali: String,
    val english: String,
    val category: KhamCategory,
    val exampleKham: String = "",
    val exampleNepali: String = "",
    val exampleEnglish: String = "",
    val phoneticGuide: String = "",
    val culturalContext: String = ""
)

data class CultureArticle(
    val id: String,
    val titleKham: String,
    val titleNepali: String,
    val titleEnglish: String,
    val tag: String,
    val summaryNepali: String,
    val summaryEnglish: String,
    val contentSections: List<Pair<String, String>>, // Title to paragraph
    val keyFacts: List<String>
)

enum class LanguageDisplayMode(val label: String) {
    TRILINGUAL("Trilingual (Kham + नेपाली + Eng)"),
    KHAM_NEPALI("Kham + नेपाली"),
    KHAM_ENGLISH("Kham + English")
}

data class QuizQuestion(
    val id: String,
    val questionPrompt: String,
    val promptSubtext: String,
    val correctAnswer: String,
    val options: List<String>,
    val explanation: String,
    val audioDevanagari: String = ""
)

data class UserStats(
    val streakDays: Int = 3,
    val wordsMastered: Int = 18,
    val totalQuizzesTaken: Int = 12,
    val practiceScore: Int = 340,
    val bookmarkedIds: Set<String> = emptySet(),
    val masteredIds: Set<String> = emptySet()
)
