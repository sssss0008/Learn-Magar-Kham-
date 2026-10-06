package com.example.data

object KhamRepository {

    val allVocabulary: List<KhamItem> = listOf(
        // === GREETINGS & BASICS ===
        KhamItem(
            id = "greet_1",
            khamDevanagari = "झोर्ले",
            khamRoman = "Jhorle",
            nepali = "नमस्ते / नमस्कार",
            english = "Hello / Greetings",
            category = KhamCategory.GREETINGS,
            exampleKham = "झोर्ले आबा, कथा लेओ?",
            exampleNepali = "नमस्ते बुबा, कस्तो हुनुहुन्छ?",
            exampleEnglish = "Hello father, how are you?",
            phoneticGuide = "Pronounced 'Jhor-lay' with high-rising tone",
            culturalContext = "Traditional respectful greeting across Magar communities."
        ),
        KhamItem(
            id = "greet_2",
            khamDevanagari = "कथा लेओ?",
            khamRoman = "Katha leo?",
            nepali = "कस्तो छ? / सन्चै हुनुहुन्छ?",
            english = "How are you?",
            category = KhamCategory.GREETINGS,
            exampleKham = "नाङ कथा लेओ?",
            exampleNepali = "तिमीलाई कस्तो छ?",
            exampleEnglish = "How are you doing?",
            phoneticGuide = "Short 'leo' with slight glottal inflection",
            culturalContext = "Standard everyday check-in between friends and elders."
        ),
        KhamItem(
            id = "greet_3",
            khamDevanagari = "छ्यु ले",
            khamRoman = "Chhyu le",
            nepali = "सन्चै छु / राम्रो छ",
            english = "I am fine / Good",
            category = KhamCategory.GREETINGS,
            exampleKham = "ङा छ्यु ले, नाङ नि?",
            exampleNepali = "म सन्चै छु, तिमी नि?",
            exampleEnglish = "I am fine, and you?",
            phoneticGuide = "Aspirated 'Chhyu' with crisp 'le'",
            culturalContext = "Used positively to signal wellness and peace."
        ),
        KhamItem(
            id = "greet_4",
            khamDevanagari = "ना मिन कथा रो?",
            khamRoman = "Na min katha ro?",
            nepali = "तपाईंको / तिम्रो नाम के हो?",
            english = "What is your name?",
            category = KhamCategory.GREETINGS,
            exampleKham = "झोर्ले, ना मिन कथा रो?",
            exampleNepali = "नमस्ते, तपाईंको नाम के हो?",
            exampleEnglish = "Hello, what is your name?",
            phoneticGuide = "'min' means name, 'ro' is the question particle",
            culturalContext = "Polite opening inquiry in Magar Kham country."
        ),
        KhamItem(
            id = "greet_5",
            khamDevanagari = "ङा मिन ... रो",
            khamRoman = "Nga min ... ro",
            nepali = "मेरो नाम ... हो",
            english = "My name is ...",
            category = KhamCategory.GREETINGS,
            exampleKham = "ङा मिन अविष्कार रो।",
            exampleNepali = "मेरो नाम अविष्कार हो।",
            exampleEnglish = "My name is Awiskar.",
            phoneticGuide = "'Nga' is nasal velar ng sound like in 'sing'",
            culturalContext = "Standard self-introduction in Kham Pang."
        ),
        KhamItem(
            id = "greet_6",
            khamDevanagari = "धन्यबाद् / छ्यु मा छ्यु",
            khamRoman = "Dhanyabad / Chhyu ma chhyu",
            nepali = "धेरै धेरै धन्यवाद",
            english = "Thank you very much",
            category = KhamCategory.GREETINGS,
            exampleKham = "नाङलाई धेरै छ्यु मा छ्यु!",
            exampleNepali = "तपाईंलाई धेरै धेरै धन्यवाद!",
            exampleEnglish = "Thank you very much to you!",
            phoneticGuide = "Expressive praise meaning 'good and benevolent'",
            culturalContext = "Expression of profound hospitality."
        ),
        KhamItem(
            id = "greet_7",
            khamDevanagari = "हुरा / ग्या हुरा",
            khamRoman = "Hura / Gya hura",
            nepali = "यहाँ आउनुहोस्",
            english = "Come here",
            category = KhamCategory.GREETINGS,
            exampleKham = "झिमका हुरा, झ्या छो।",
            exampleNepali = "घरमा आउनुहोस्, खाना खानुहोस्।",
            exampleEnglish = "Come to the house, eat food.",
            phoneticGuide = "'Gya' = here, 'Hura' = imperative come",
            culturalContext = "Hearty invitation into a Magar home."
        ),
        KhamItem(
            id = "greet_8",
            khamDevanagari = "खुजा / च्हुसा",
            khamRoman = "Khuza / Chhusa",
            nepali = "बस्नुहोस् / बस्नु",
            english = "Sit down / Please sit",
            category = KhamCategory.GREETINGS,
            exampleKham = "राडीखा खुजा।",
            exampleNepali = "राडी (ऊनी गुन्द्री) मा बस्नुहोस्।",
            exampleEnglish = "Please sit on the traditional wool carpet.",
            phoneticGuide = "Soft 'z' tone in Northern Kham dialect",
            culturalContext = "Guests are always seated on handwoven Radhi wool rugs."
        ),

        // === NUMBERS & COUNTING ===
        KhamItem(
            id = "num_1",
            khamDevanagari = "तुप (इक)",
            khamRoman = "Tup (Ik)",
            nepali = "एक (१)",
            english = "One (1)",
            category = KhamCategory.NUMBERS,
            exampleKham = "तुप मान्छे",
            exampleNepali = "एक जना मान्छे",
            exampleEnglish = "One person",
            phoneticGuide = "Short closed 'Tup'",
            culturalContext = "Counting unit 1 in native Kham."
        ),
        KhamItem(
            id = "num_2",
            khamDevanagari = "नेः",
            khamRoman = "Neh",
            nepali = "दुई (२)",
            english = "Two (2)",
            category = KhamCategory.NUMBERS,
            exampleKham = "नेः झिम",
            exampleNepali = "दुईवटा घर",
            exampleEnglish = "Two houses",
            phoneticGuide = "Lax vowel with breathy aspiration",
            culturalContext = "Unit 2."
        ),
        KhamItem(
            id = "num_3",
            khamDevanagari = "सोम",
            khamRoman = "Som",
            nepali = "तीन (३)",
            english = "Three (3)",
            category = KhamCategory.NUMBERS,
            exampleKham = "सोम भाइ",
            exampleNepali = "तीन भाइ",
            exampleEnglish = "Three brothers",
            phoneticGuide = "Clear 'Som'",
            culturalContext = "Cognate with Proto-Tibeto-Burman *g-sum."
        ),
        KhamItem(
            id = "num_4",
            khamDevanagari = "ब्जि / झि",
            khamRoman = "Bzi / Zhi",
            nepali = "चार (४)",
            english = "Four (4)",
            category = KhamCategory.NUMBERS,
            exampleKham = "ब्जि दिशा",
            exampleNepali = "चार दिशा",
            exampleEnglish = "Four directions",
            phoneticGuide = "Voiced sibilant 'bzi'",
            culturalContext = "Sacred number in shamanic four-direction chants."
        ),
        KhamItem(
            id = "num_5",
            khamDevanagari = "प्ङा / पुर्ङा",
            khamRoman = "Pnga / Purnga",
            nepali = "पाँच (५)",
            english = "Five (5)",
            category = KhamCategory.NUMBERS,
            exampleKham = "प्ङा औंला",
            exampleNepali = "पाँच औंला",
            exampleEnglish = "Five fingers",
            phoneticGuide = "Initial 'p' blended into velar 'nga'",
            culturalContext = "Proto-Tibeto-Burman cognate *l-ŋa."
        ),
        KhamItem(
            id = "num_6",
            khamDevanagari = "तुः",
            khamRoman = "Tuh",
            nepali = "छ (६)",
            english = "Six (6)",
            category = KhamCategory.NUMBERS,
            exampleKham = "तुः महिना",
            exampleNepali = "छ महिना",
            exampleEnglish = "Six months",
            phoneticGuide = "Short glottal 'Tuh'",
            culturalContext = "Unit 6."
        ),
        KhamItem(
            id = "num_7",
            khamDevanagari = "न्हेस्",
            khamRoman = "Nhes",
            nepali = "सात (७)",
            english = "Seven (7)",
            category = KhamCategory.NUMBERS,
            exampleKham = "न्हेस् दिन",
            exampleNepali = "सात दिन (एक हप्ता)",
            exampleEnglish = "Seven days (one week)",
            phoneticGuide = "Nasalized 'Nhes'",
            culturalContext = "Unit 7."
        ),
        KhamItem(
            id = "num_8",
            khamDevanagari = "ब्जे / ज्ह्यात",
            khamRoman = "Bze / Jhyat",
            nepali = "आठ (८)",
            english = "Eight (8)",
            category = KhamCategory.NUMBERS,
            exampleKham = "ब्जे वर्ष",
            exampleNepali = "आठ वर्ष",
            exampleEnglish = "Eight years",
            phoneticGuide = "Voiced 'Bze'",
            culturalContext = "Unit 8."
        ),
        KhamItem(
            id = "num_9",
            khamDevanagari = "कु",
            khamRoman = "Ku",
            nepali = "नौ (९)",
            english = "Nine (9)",
            category = KhamCategory.NUMBERS,
            exampleKham = "कु डाँडा",
            exampleNepali = "नौ डाँडा",
            exampleEnglish = "Nine ridges",
            phoneticGuide = "High pitch 'Ku'",
            culturalContext = "Unit 9."
        ),
        KhamItem(
            id = "num_10",
            khamDevanagari = "छि",
            khamRoman = "Chhi",
            nepali = "दश (१०)",
            english = "Ten (10)",
            category = KhamCategory.NUMBERS,
            exampleKham = "छि रुपैयाँ",
            exampleNepali = "दश रुपैयाँ",
            exampleEnglish = "Ten rupees",
            phoneticGuide = "Crisp aspirated 'Chhi'",
            culturalContext = "Base unit 10 in traditional base-10/20 Kham numbering."
        ),

        // === FAMILY & RELATIONS ===
        KhamItem(
            id = "fam_1",
            khamDevanagari = "आबा / बाबु",
            khamRoman = "Aba / Babu",
            nepali = "बुबा / पिता",
            english = "Father",
            category = KhamCategory.FAMILY,
            exampleKham = "ङा आबा खेतका बाके।",
            exampleNepali = "मेरो बुबा खेतमा जानुभयो।",
            exampleEnglish = "My father went to the farm.",
            phoneticGuide = "Gentle 'Aba'",
            culturalContext = "Household head and lineage custodian."
        ),
        KhamItem(
            id = "fam_2",
            khamDevanagari = "आमा / माँ",
            khamRoman = "Aama / Maa",
            nepali = "आमा / माता",
            english = "Mother",
            category = KhamCategory.FAMILY,
            exampleKham = "आमाले झ्या रन्के।",
            exampleNepali = "आमाले खाना पकाउनुभयो।",
            exampleEnglish = "Mother cooked the food.",
            phoneticGuide = "Resonant 'Aama'",
            culturalContext = "Central pillar of warmth and Kham domestic crafts."
        ),
        KhamItem(
            id = "fam_3",
            khamDevanagari = "आख्यो",
            khamRoman = "Aakhyo",
            nepali = "दाजु / ठूलो दाजु",
            english = "Elder Brother",
            category = KhamCategory.FAMILY,
            exampleKham = "ङा आख्यो पोखराखा ले।",
            exampleNepali = "मेरो दाजु पोखरामा हुनुहुन्छ।",
            exampleEnglish = "My elder brother is in Pokhara.",
            phoneticGuide = "Glided 'khy' sound",
            culturalContext = "Respected brother figure in joint households."
        ),
        KhamItem(
            id = "fam_4",
            khamDevanagari = "आनता",
            khamRoman = "Aanata",
            nepali = "दिदी / ठूली दिदी",
            english = "Elder Sister",
            category = KhamCategory.FAMILY,
            exampleKham = "आनता घालेक चोके।",
            exampleNepali = "दिदीले घालेक लगाउनुभयो।",
            exampleEnglish = "Elder sister wore the traditional Ghalek.",
            phoneticGuide = "Soft 'ta'",
            culturalContext = "Elder sister who often guides traditional folk songs."
        ),
        KhamItem(
            id = "fam_5",
            khamDevanagari = "झ्य / भाइ",
            khamRoman = "Jhya / Bhai",
            nepali = "भाइ / कान्छो भाइ",
            english = "Younger Brother",
            category = KhamCategory.FAMILY,
            exampleKham = "झ्य स्कुलका बान्या।",
            exampleNepali = "भाइ विद्यालय जाँदैछ।",
            exampleEnglish = "Younger brother is going to school.",
            phoneticGuide = "Short 'Jhya'",
            culturalContext = "Younger brother."
        ),
        KhamItem(
            id = "fam_6",
            khamDevanagari = "बोहिन / आपिल",
            khamRoman = "Bohin / Aapil",
            nepali = "बहिनी / कान्छी बहिनी",
            english = "Younger Sister",
            category = KhamCategory.FAMILY,
            exampleKham = "आपिलले मेन्धो टिप्के।",
            exampleNepali = "बहिनीले फूल टिपिन्।",
            exampleEnglish = "Younger sister plucked flowers.",
            phoneticGuide = "Melodic 'Aapil'",
            culturalContext = "Younger sister."
        ),
        KhamItem(
            id = "fam_7",
            khamDevanagari = "आजे",
            khamRoman = "Aaje",
            nepali = "हजुरबुबा / बाजे",
            english = "Grandfather",
            category = KhamCategory.FAMILY,
            exampleKham = "आजेले पुराना कथा सुनाइके।",
            exampleNepali = "हजुरबुबाले पुराना कथा सुनाउनुभयो।",
            exampleEnglish = "Grandfather shared ancestral stories.",
            phoneticGuide = "Soft 'je'",
            culturalContext = "Keeper of Kham oral legends and village genealogies."
        ),
        KhamItem(
            id = "fam_8",
            khamDevanagari = "आयी",
            khamRoman = "Aayi",
            nepali = "हजुरआमा / बज्यै",
            english = "Grandmother",
            category = KhamCategory.FAMILY,
            exampleKham = "आयीले राडी बुनिन्या।",
            exampleNepali = "हजुरआमाले राडी बुन्दै हुनुहुन्छ।",
            exampleEnglish = "Grandmother is weaving a sheep-wool blanket.",
            phoneticGuide = "Long 'Aayi'",
            culturalContext = "Master weaver of authentic Radhi-Pakhi sheep wool."
        ),

        // === FOOD & TRADITIONAL DINING ===
        KhamItem(
            id = "food_1",
            khamDevanagari = "झ्या",
            khamRoman = "Zhya",
            nepali = "भात / खाना",
            english = "Rice / Meal / Food",
            category = KhamCategory.FOOD,
            exampleKham = "झ्या छो!",
            exampleNepali = "खाना खानुहोस्!",
            exampleEnglish = "Eat your meal!",
            phoneticGuide = "Voiced sibilant 'Zh' + 'ya'",
            culturalContext = "Core staple term in everyday Kham life."
        ),
        KhamItem(
            id = "food_2",
            khamDevanagari = "ति",
            khamRoman = "Ti",
            nepali = "पानी / पिउने पानी",
            english = "Water",
            category = KhamCategory.FOOD,
            exampleKham = "ङालाई ति थुनु मन ले।",
            exampleNepali = "मलाई पानी पिउन मन छ।",
            exampleEnglish = "I want to drink water.",
            phoneticGuide = "Crisp high 'Ti'",
            culturalContext = "Mountain spring water, pure and revered."
        ),
        KhamItem(
            id = "food_3",
            khamDevanagari = "सिए / स्या",
            khamRoman = "Sie / Sya",
            nepali = "मासु / परिकार",
            english = "Meat",
            category = KhamCategory.FOOD,
            exampleKham = "सिम स्या (भेडाको मासु)",
            exampleNepali = "भेडाको मासु",
            exampleEnglish = "Mutton (sheep meat)",
            phoneticGuide = "'Sie' in Gamale, 'Sya' in Western Kham",
            culturalContext = "Served during festive feasts like Bhume Parva."
        ),
        KhamItem(
            id = "food_4",
            khamDevanagari = "खेन् / ढिँडो",
            khamRoman = "Khen / Dhindo",
            nepali = "ढिँडो (कोदो/फापरको)",
            english = "Millet / Buckwheat Porridge (Dhindo)",
            category = KhamCategory.FOOD,
            exampleKham = "खोदोलु खेन् साह्रै च्हुले।",
            exampleNepali = "कोदोको ढिँडो साह्रै मिठो छ।",
            exampleEnglish = "Millet porridge is extremely delicious.",
            phoneticGuide = "Deep throat 'Khen'",
            culturalContext = "The hearty daily mountain fuel of Kham farmers."
        ),
        KhamItem(
            id = "food_5",
            khamDevanagari = "न्हु / दुध",
            khamRoman = "Nhu / Dudh",
            nepali = "दुध",
            english = "Milk",
            category = KhamCategory.FOOD,
            exampleKham = "गाइ न्हु थुनु च्हु।",
            exampleNepali = "गाईको दुध पिउन राम्रो हुन्छ।",
            exampleEnglish = "Cow milk is good to drink.",
            phoneticGuide = "Nasal aspirate 'Nhu'",
            culturalContext = "Fresh milk from alpine pastures (Kharka)."
        ),
        KhamItem(
            id = "food_6",
            khamDevanagari = "काङ्",
            khamRoman = "Kang",
            nepali = "दाल / सुप",
            english = "Lentil Soup / Broth",
            category = KhamCategory.FOOD,
            exampleKham = "काङ् र झ्या मिसाइके छो।",
            exampleNepali = "दाल र भात मिसाएर खानुहोस्।",
            exampleEnglish = "Mix lentil soup with rice and eat.",
            phoneticGuide = "Nasal 'Kang'",
            culturalContext = "Simmered mountain beans (Simi and Bodi)."
        ),

        // === NATURE & SURROUNDINGS ===
        KhamItem(
            id = "nat_1",
            khamDevanagari = "तिनाम",
            khamRoman = "Tinam",
            nepali = "घाम / सूर्य",
            english = "Sun / Daylight",
            category = KhamCategory.NATURE,
            exampleKham = "तिनाम जर्के, उज्यालो भए।",
            exampleNepali = "घाम लाग्यो, उज्यालो भयो।",
            exampleEnglish = "The sun has risen, it has become bright.",
            phoneticGuide = "Rhythmic 'Ti-nam'",
            culturalContext = "Revered morning sun rising over Dhaulagiri range."
        ),
        KhamItem(
            id = "nat_2",
            khamDevanagari = "ल्हा",
            khamRoman = "Lha",
            nepali = "जून / चन्द्रमा",
            english = "Moon",
            category = KhamCategory.NATURE,
            exampleKham = "राति ल्हा चमक्यो।",
            exampleNepali = "राति जून चम्कियो।",
            exampleEnglish = "The moon shone at night.",
            phoneticGuide = "Voiceless lateral fricative 'Lh'",
            culturalContext = "Full moon guides traditional nightly village dances."
        ),
        KhamItem(
            id = "nat_3",
            khamDevanagari = "नाम",
            khamRoman = "Nam",
            nepali = "आकाश / बादल / मौसम",
            english = "Sky / Weather",
            category = KhamCategory.NATURE,
            exampleKham = "नाम सफा ले।",
            exampleNepali = "आकाश सफा छ।",
            exampleEnglish = "The sky is clear.",
            phoneticGuide = "Open 'Nam'",
            culturalContext = "Kham Magars predict rainfall by watching Nam winds."
        ),
        KhamItem(
            id = "nat_4",
            khamDevanagari = "सा",
            khamRoman = "Sa",
            nepali = "माटो / भूमि / जमिन",
            english = "Earth / Soil / Land",
            category = KhamCategory.NATURE,
            exampleKham = "सा देवतालाई ढोग।",
            exampleNepali = "माटो / भूमे देवतालाई ढोग्नुहोस्।",
            exampleEnglish = "Bow to Mother Earth / Bhume deity.",
            phoneticGuide = "Short high 'Sa'",
            culturalContext = "The sacred soil worshiped in Bhume Parva."
        ),
        KhamItem(
            id = "nat_5",
            khamDevanagari = "री / डाँडा",
            khamRoman = "Ri / Danda",
            nepali = "हिमाल / पहाड / डाँडा",
            english = "Mountain / Hill / Ridge",
            category = KhamCategory.NATURE,
            exampleKham = "हिउँ री साह्रै राम्रो ले।",
            exampleNepali = "हिउँले ढाकिएको हिमाल साह्रै सुन्दर छ।",
            exampleEnglish = "The snow-capped mountain is very beautiful.",
            phoneticGuide = "High tense 'Ri'",
            culturalContext = "The lofty ridges of Rolpa, Rukum, and Dhorpatan."
        ),
        KhamItem(
            id = "nat_6",
            khamDevanagari = "सिङ",
            khamRoman = "Sing",
            nepali = "रुख / काठ / दाउरा",
            english = "Tree / Wood / Timber",
            category = KhamCategory.NATURE,
            exampleKham = "सिङ छ्याङ्गे दाउरा बन्के।",
            exampleNepali = "रुख काटेर दाउरा बन्यो।",
            exampleEnglish = "Wood was chopped for firewood.",
            phoneticGuide = "Nasal 'Sing'",
            culturalContext = "Pine and oak forests of the mid-hills."
        ),
        KhamItem(
            id = "nat_7",
            khamDevanagari = "मेन्धो / मेन्दो",
            khamRoman = "Mendho / Mendo",
            nepali = "फूल / लालीगुराँस",
            english = "Flower / Blossom",
            category = KhamCategory.NATURE,
            exampleKham = "रातो मेन्धो डाँडाखा फुल्यो।",
            exampleNepali = "रातो गुराँसको फूल डाँडामा फुल्यो।",
            exampleEnglish = "Red rhododendron bloomed on the ridge.",
            phoneticGuide = "Soft 'Mendho'",
            culturalContext = "Worn by Magar maidens behind their ears during festivals."
        ),
        KhamItem(
            id = "nat_8",
            khamDevanagari = "ग्योएख / खोला",
            khamRoman = "Gyoekh / Khola",
            nepali = "खोला / नदी",
            english = "River / Stream",
            category = KhamCategory.NATURE,
            exampleKham = "ग्योएखखा ति बगे।",
            exampleNepali = "खोलामा पानी बग्यो।",
            exampleEnglish = "Water flowed in the river.",
            phoneticGuide = "Glottal ending 'kh'",
            culturalContext = "The Sani Bheri and Madi river valleys."
        ),

        // === CONVERSATION & QUESTIONS ===
        KhamItem(
            id = "conv_1",
            khamDevanagari = "नाङ कदा बान्या?",
            khamRoman = "Nang kada banya?",
            nepali = "तपाईं / तिमी कहाँ जाँदै हुनुहुन्छ?",
            english = "Where are you going?",
            category = KhamCategory.CONVERSATION,
            exampleKham = "नाङ कदा बान्या, साथी?",
            exampleNepali = "तिमी कहाँ जाँदैछौ, साथी?",
            exampleEnglish = "Where are you going, friend?",
            phoneticGuide = "'Kada' = where, 'banya' = to go",
            culturalContext = "The most standard path greeting when meeting a traveler."
        ),
        KhamItem(
            id = "conv_2",
            khamDevanagari = "ङा झिमका बान्या",
            khamRoman = "Nga zhim-ka banya",
            nepali = "म घर जाँदैछु",
            english = "I am going home",
            category = KhamCategory.CONVERSATION,
            exampleKham = "बेलुका भए, ङा झिमका बान्या।",
            exampleNepali = "साँझ पर्यो, म घर जाँदैछु।",
            exampleEnglish = "Evening has fallen, I am going home.",
            phoneticGuide = "'-ka' is locative suffix meaning 'towards / at'",
            culturalContext = "Heading home before mountain twilight."
        ),
        KhamItem(
            id = "conv_3",
            khamDevanagari = "झ्या झ्याउ?",
            khamRoman = "Zhya zhyau?",
            nepali = "खाना खानुभयो?",
            english = "Did you eat food?",
            category = KhamCategory.CONVERSATION,
            exampleKham = "झोर्ले दाजु, झ्या झ्याउ?",
            exampleNepali = "नमस्ते दाजु, खाना खानुभयो?",
            exampleEnglish = "Hello brother, did you eat?",
            phoneticGuide = "'Zhyau' = past question verb for eating",
            culturalContext = "Shows caring hospitality in Nepali and Kham culture."
        ),
        KhamItem(
            id = "conv_4",
            khamDevanagari = "ङा नाङलाई माया दान्या",
            khamRoman = "Nga nang-lai maya danya",
            nepali = "म तिमीलाई माया गर्छु",
            english = "I love you",
            category = KhamCategory.CONVERSATION,
            exampleKham = "ङा नाङलाई सधैं माया दान्या।",
            exampleNepali = "म तिमीलाई सधैं माया गर्छु।",
            exampleEnglish = "I will always love you.",
            phoneticGuide = "'danya' = to do / to love",
            culturalContext = "Heard in emotional Kham folk ballads."
        ),
        KhamItem(
            id = "conv_5",
            khamDevanagari = "खिन / मखिर",
            khamRoman = "Khin / Makhir",
            nepali = "हो / होइन",
            english = "Yes (it is) / No (it isn't)",
            category = KhamCategory.CONVERSATION,
            exampleKham = "यो नाङको झिम खिन?",
            exampleNepali = "यो तिम्रो घर हो?",
            exampleEnglish = "Is this your house?",
            phoneticGuide = "'khin' = affirmative, 'makhir' = negative",
            culturalContext = "Affirmative vs negative polar answers."
        ),
        KhamItem(
            id = "conv_6",
            khamDevanagari = "ओ काता रो?",
            khamRoman = "O kata ro?",
            nepali = "यो के हो?",
            english = "What is this?",
            category = KhamCategory.CONVERSATION,
            exampleKham = "ओ काता चिज रो?",
            exampleNepali = "यो के चीज हो?",
            exampleEnglish = "What item is this?",
            phoneticGuide = "'O' = this, 'kata' = what",
            culturalContext = "Great question for learning new vocabulary in the village."
        ),

        // === VERBS & ACTIONS ===
        KhamItem(
            id = "verb_1",
            khamDevanagari = "बान्या",
            khamRoman = "Banya",
            nepali = "जानु / हिँड्नु",
            english = "To go / To walk",
            category = KhamCategory.VERBS,
            exampleKham = "गे मेलाखा बान्या।",
            exampleNepali = "हामी मेलामा जानेछौं।",
            exampleEnglish = "We will go to the festival.",
            phoneticGuide = "'-nya' is the infinitive verb marker in Kham",
            culturalContext = "All verbs naturally end in '-nya'."
        ),
        KhamItem(
            id = "verb_2",
            khamDevanagari = "हुन्या",
            khamRoman = "Hunya",
            nepali = "आउनु",
            english = "To come",
            category = KhamCategory.VERBS,
            exampleKham = "भोलि ङा झिमका हुन्या।",
            exampleNepali = "भोलि म घरमा आउनेछु।",
            exampleEnglish = "Tomorrow I will come home.",
            phoneticGuide = "Smooth 'Hu-nya'",
            culturalContext = "Opposite of 'Banya'."
        ),
        KhamItem(
            id = "verb_3",
            khamDevanagari = "झ्यान्या",
            khamRoman = "Zhyanya",
            nepali = "खानु",
            english = "To eat",
            category = KhamCategory.VERBS,
            exampleKham = "झ्या झ्यान्या समय भए।",
            exampleNepali = "खाना खाने समय भयो।",
            exampleEnglish = "It is time to eat food.",
            phoneticGuide = "Voiced fricative 'zhya'",
            culturalContext = "Daily action verb."
        ),
        KhamItem(
            id = "verb_4",
            khamDevanagari = "थुन्या",
            khamRoman = "Thunya",
            nepali = "पिउनु",
            english = "To drink",
            category = KhamCategory.VERBS,
            exampleKham = "चिसो ति थुन्या।",
            exampleNepali = "चिसो पानी पिउनु।",
            exampleEnglish = "Drink cold water.",
            phoneticGuide = "Crisp aspirate 'Thu'",
            culturalContext = "Drinking water or mountain tea."
        ),
        KhamItem(
            id = "verb_5",
            khamDevanagari = "द्योन्या",
            khamRoman = "Dyonya",
            nepali = "हेर्नु / देख्नु",
            english = "To see / To look",
            category = KhamCategory.VERBS,
            exampleKham = "नाच द्योन्या हुरा।",
            exampleNepali = "नाच हेर्न आउनुहोस्।",
            exampleEnglish = "Come to watch the dance.",
            phoneticGuide = "'Dyo-nya'",
            culturalContext = "Watching Bhume or Paisari cultural dances."
        ),
        KhamItem(
            id = "verb_6",
            khamDevanagari = "दान्या",
            khamRoman = "Danya",
            nepali = "गर्नु / बनाउनु",
            english = "To do / To make",
            category = KhamCategory.VERBS,
            exampleKham = "काम राम्रो दाउ।",
            exampleNepali = "काम राम्ररी गर्नुहोस्।",
            exampleEnglish = "Do your work well.",
            phoneticGuide = "General utility verb",
            culturalContext = "Used frequently in compound verbs."
        ),

        // === BODY PARTS ===
        KhamItem(
            id = "body_1",
            khamDevanagari = "मिक",
            khamRoman = "Mik",
            nepali = "आँखा",
            english = "Eye",
            category = KhamCategory.BODY,
            exampleKham = "मिकले संसार द्योके।",
            exampleNepali = "आँखाले संसार देख्यो।",
            exampleEnglish = "The eye saw the world.",
            phoneticGuide = "Glottal stop at 'k'",
            culturalContext = "Tibeto-Burman root *myak."
        ),
        KhamItem(
            id = "body_2",
            khamDevanagari = "ना",
            khamRoman = "Na",
            nepali = "नाक",
            english = "Nose",
            category = KhamCategory.BODY,
            exampleKham = "ना ले बास्ना थाहा पाउँछ।",
            exampleNepali = "नाकले सुगन्ध थाहा पाउँछ।",
            exampleEnglish = "The nose senses scent.",
            phoneticGuide = "Short 'Na'",
            culturalContext = "Cognate *s-na."
        ),
        KhamItem(
            id = "body_3",
            khamDevanagari = "कुथुर / कान",
            khamRoman = "Kuthur / Kaan",
            nepali = "कान",
            english = "Ear",
            category = KhamCategory.BODY,
            exampleKham = "कुथुरले गीत सुन्या।",
            exampleNepali = "कानले गीत सुन्नु।",
            exampleEnglish = "Listening to songs with ears.",
            phoneticGuide = "Rolled 'r' in Kuthur",
            culturalContext = "Ears where golden 'Chepte Sun' rings hang."
        ),
        KhamItem(
            id = "body_4",
            khamDevanagari = "या / हात",
            khamRoman = "Ya / Haat",
            nepali = "हात",
            english = "Hand / Arm",
            category = KhamCategory.BODY,
            exampleKham = "या जोडेर झोर्ले दाउ।",
            exampleNepali = "हात जोडेर नमस्ते गर्नुहोस्।",
            exampleEnglish = "Fold hands and greet Jhorle.",
            phoneticGuide = "Short open 'Ya'",
            culturalContext = "Used for labor, weaving, and folding greetings."
        ),
        KhamItem(
            id = "body_5",
            khamDevanagari = "खोल / खुट्टा",
            khamRoman = "Khol / Khutta",
            nepali = "खुट्टा",
            english = "Leg / Foot",
            category = KhamCategory.BODY,
            exampleKham = "खोलेले डाँडा काट्यो।",
            exampleNepali = "खुट्टाले डाँडा पार गर्यो।",
            exampleEnglish = "Legs climbed across the mountain ridge.",
            phoneticGuide = "'Khol'",
            culturalContext = "Mountain hiking resilience."
        ),
        KhamItem(
            id = "body_6",
            khamDevanagari = "मु",
            khamRoman = "Mu",
            nepali = "मुख",
            english = "Mouth",
            category = KhamCategory.BODY,
            exampleKham = "मु ले मिठा कुरा दाउ।",
            exampleNepali = "मुखले मिठो बोली बोल्नुहोस्।",
            exampleEnglish = "Speak kind words with your mouth.",
            phoneticGuide = "High 'Mu'",
            culturalContext = "Speaking Kham Pang faithfully."
        ),

        // === TIME & SEASONS ===
        KhamItem(
            id = "time_1",
            khamDevanagari = "छिङा",
            khamRoman = "Chhinga",
            nepali = "आज",
            english = "Today",
            category = KhamCategory.TIME,
            exampleKham = "छिङा रमाइलो दिन ले।",
            exampleNepali = "आज रमाइलो दिन छ।",
            exampleEnglish = "Today is a joyful day.",
            phoneticGuide = "Aspirated 'Chhin-ga'",
            culturalContext = "Living in the present day."
        ),
        KhamItem(
            id = "time_2",
            khamDevanagari = "नखा",
            khamRoman = "Nakha",
            nepali = "भोलि",
            english = "Tomorrow",
            category = KhamCategory.TIME,
            exampleKham = "नखा मेला सुरु हुने।",
            exampleNepali = "भोलि मेला सुरु हुनेछ।",
            exampleEnglish = "Tomorrow the festival begins.",
            phoneticGuide = "Open 'Na-kha'",
            culturalContext = "Looking forward to tomorrow."
        ),
        KhamItem(
            id = "time_3",
            khamDevanagari = "मझाङ",
            khamRoman = "Mazhang",
            nepali = "हिजो",
            english = "Yesterday",
            category = KhamCategory.TIME,
            exampleKham = "मझाङ पानी झर्के।",
            exampleNepali = "हिजो पानी पर्यो।",
            exampleEnglish = "It rained yesterday.",
            phoneticGuide = "'Ma-zhang'",
            culturalContext = "Reflecting on yesterday."
        ),
        KhamItem(
            id = "time_4",
            khamDevanagari = "बिहिना",
            khamRoman = "Bihina",
            nepali = "बिहान / प्रभात",
            english = "Morning",
            category = KhamCategory.TIME,
            exampleKham = "बिहिना च्यु ले।",
            exampleNepali = "शुभ बिहानी / बिहान राम्रो छ।",
            exampleEnglish = "Good morning.",
            phoneticGuide = "Soft 'Bihina'",
            culturalContext = "Mountain morning sun rising."
        ),
        KhamItem(
            id = "time_5",
            khamDevanagari = "नाम्खुम / राति",
            khamRoman = "Namkhum / Raati",
            nepali = "रात / साँझ",
            english = "Night / Darkness",
            category = KhamCategory.TIME,
            exampleKham = "नाम्खुम भए, झिमका बाओ।",
            exampleNepali = "रात पर्यो, घर जानुहोस्।",
            exampleEnglish = "Night has fallen, go home.",
            phoneticGuide = "'Nam-khum' literally means dark-sky",
            culturalContext = "Cozy evenings by the wood hearth (Chulho)."
        ),

        // === CULTURE & TRADITIONS ===
        KhamItem(
            id = "cult_1",
            khamDevanagari = "भुमे / बल पूजा",
            khamRoman = "Bhume / Bal Puja",
            nepali = "भुमे पर्व (भूमि/माटोको भव्य पूजा)",
            english = "Bhume Festival (Earth Worship Festival)",
            category = KhamCategory.CULTURE,
            exampleKham = "भुमे मेलाखा सबैजना नाचिन्या।",
            exampleNepali = "भुमे मेलामा सबैजना नाच्छन्।",
            exampleEnglish = "Everyone dances in the sacred Bhume festival.",
            phoneticGuide = "Solemn veneration of nature",
            culturalContext = "The grandest annual celebration of Kham Magars in Rolpa and Rukum every Jestha/Ashadh."
        ),
        KhamItem(
            id = "cult_2",
            khamDevanagari = "भाङ्ग्रा",
            khamRoman = "Bhangra",
            nepali = "भाङ्ग्रा (अल्लो/भाङबाट बनेको परम्परागत थैली/पोसाक)",
            english = "Bhangra (Handwoven Nettle Cross-Vest & Pouch)",
            category = KhamCategory.CULTURE,
            exampleKham = "आबाले भाङ्ग्रा भिरेर बान्या।",
            exampleNepali = "बुबाले भाङ्ग्रा भिरेर जानुभयो।",
            exampleEnglish = "Father wore the traditional Bhangra vest.",
            phoneticGuide = "Woven from wild Himalayan giant nettle (Allo)",
            culturalContext = "Symbol of Magar identity, used as a cross-chest cloak and carrying bag."
        ),
        KhamItem(
            id = "cult_3",
            khamDevanagari = "ध्याङ्ग्रो",
            khamRoman = "Dhyangro",
            nepali = "ध्याङ्ग्रो (झाँक्रीको पवित्र ढोल/बाजा)",
            english = "Dhyangro (Sacred Shamanic Ritual Drum)",
            category = KhamCategory.CULTURE,
            exampleKham = "झाँक्रीले ध्याङ्ग्रो ठोकेर चिन्ता बस्यो।",
            exampleNepali = "झाँक्रीले ध्याङ्ग्रो ठोकेर चिन्ता बसे।",
            exampleEnglish = "The shaman played the Dhyangro drum during the healing ritual.",
            phoneticGuide = "Double-sided leather drum with carved wooden ritual dagger handle",
            culturalContext = "Central instrument of Kham shamanism (Dhami-Jhakri lineage)."
        ),
        KhamItem(
            id = "cult_4",
            khamDevanagari = "पैसारी नाच",
            khamRoman = "Paisari Naach",
            nepali = "पैसारी नाच (खाम मगरहरूको वीर परम्परागत नृत्य)",
            english = "Paisari Dance (Ancient Magar Heroic Circle Dance)",
            category = KhamCategory.CULTURE,
            exampleKham = "पैसारी नाचमा सेतो फेटा र तरबार हुन्छ।",
            exampleNepali = "पैसारी नाचमा सेतो फेटा र तरबार हुन्छ।",
            exampleEnglish = "In the Paisari dance, dancers wear white turbans with heroic steps.",
            phoneticGuide = "Step dance accompanied by flute and drums",
            culturalContext = "Commemorates historic Magar warriors and community unity."
        ),
        KhamItem(
            id = "cult_5",
            khamDevanagari = "घालेक र कछाड",
            khamRoman = "Ghalek & Kachhad",
            nepali = "घालेक (महिलाको पोसाक) र कछाड (पुरुषको धोती)",
            english = "Ghalek (Women's Wrap) & Kachhad (Men's Kilt)",
            category = KhamCategory.CULTURE,
            exampleKham = "घालेक र कछाड हाम्रो मौलिक पहिरन रो।",
            exampleNepali = "घालेक र कछाड हाम्रो मौलिक पहिरन हो।",
            exampleEnglish = "Ghalek and Kachhad are our authentic indigenous attire.",
            phoneticGuide = "Distinctive colors and handloom weave",
            culturalContext = "Worn with pride during gatherings, weddings, and rituals."
        ),
        KhamItem(
            id = "cult_6",
            khamDevanagari = "खाम् पाङ",
            khamRoman = "Kham Pang",
            nepali = "खाम भाषा (मगर खाम मातृभाषा)",
            english = "Kham Language (Mother Tongue of Kham Magars)",
            category = KhamCategory.CULTURE,
            exampleKham = "खाम् पाङ जोगाउनु हाम्रो कर्तव्य रो।",
            exampleNepali = "खाम भाषा जोगाउनु हाम्रो कर्तव्य हो।",
            exampleEnglish = "Preserving the Kham language is our sacred duty.",
            phoneticGuide = "'Pang' means language / speech in Kham",
            culturalContext = "The ancestral tongue spoken across the valleys of Western Nepal."
        )
    )

    // Daily Proverb
    val dailyProverbs = listOf(
        Triple(
            "सा देवता नरिसाए, खेती राम्रो हुन्छ।",
            "When Mother Earth is worshiped with pure heart, harvests flourish.",
            "खाम उखान: सा खा जिउने, नाम खा हेर्ने (माटोमा जिउने, आकाशलाई हेर्ने)"
        ),
        Triple(
            "एक हातले भाङ्ग्रा बुनिँदैन, समुदाय मिलेर गाउँ बन्छ।",
            "A Bhangra is not woven with one thread; a village thrives in unity.",
            "खाम उखान: एकता नै ठूलो शक्ति रो (Togetherness is strength)"
        ),
        Triple(
            "आफ्नो पाङ नभुल्नु, आफ्नो मूल नछोड्नु।",
            "Never forget your mother tongue; never abandon your roots.",
            "खाम भनाइ: खाम् पाङ हाम्रो मुटु रो (Kham Pang is our heartbeat)"
        )
    )

    // Cultural Articles
    val cultureArticles: List<CultureArticle> = listOf(
        CultureArticle(
            id = "art_1",
            titleKham = "भुमे पर्व (बल पूजा) र खाम सभ्यता",
            titleNepali = "भुमे पर्व (बल पूजा) - प्रकृतिको महान आराधना",
            titleEnglish = "The Sacred Bhume Parva: Earth Worship Festival",
            tag = "महान पर्व (Grand Festival)",
            summaryNepali = "रोल्पा, रुकुम र बागलुङका खाम मगरहरूले हरेक वर्ष जेठ-असारमा धुमधामका साथ मनाउने भुमे पर्व प्रकृतिको सम्मान र बालीनालीको रक्षाका लागि गरिने प्राचीन अनुष्ठान हो।",
            summaryEnglish = "Celebrated every year in mid-summer by Kham Magars of Rolpa, Rukum, and Baglung, Bhume Parva is a majestic nature-worship ritual seeking blessings for bountiful harvests, peaceful livestock, and community safety.",
            contentSections = listOf(
                "पर्वको ऐतिहासिक पृष्ठभूमि (Historical Roots)" to
                        "भुमे (भूमे) को अर्थ 'भूमि' वा जमिन हो। खाम मगर समुदायमा प्रकृतिलाई प्रत्यक्ष ईश्वरको रूपमा पुज्ने परम्परा छ। परापूर्वकालदेखि पहाडी भीरपाखा, खर्क र गाउँहरूमा पहिरो, महामारी र खडेरी नपरोस् भनी गाउँका धामी-झाँक्री र बालबालिका मिलेर बल पूजा र भूमे पूजा गर्दछन्।",
                "२२ तालको परम्परागत नाच (The 22 Sacred Rhythms)" to
                        "भुमे नाचमा २२ प्रकारका चालहरू (तालहरू) हुन्छन्। पुरुषहरूले सेतो फेटा, भोटो, भाङ्ग्रा र कछाड भिरेर तथा महिलाहरूले रातो-कालो घालेक, पछ्यौरी र सुनका परम्परागत गहना (गलाको काण्ठमाला, शिरफुल, बुलाकी) लगाएर गोलो घेरामा बाजाको तालमा लयबद्ध नृत्य गर्दछन्।",
                "नौतुना लेकको यात्रा (Pilgrimage to High Meadows)" to
                        "पूजाको मुख्य दिन गाउँका युवाहरू अग्लो लेकमा गएर पवित्र फूल र धूपी-पात ल्याउँछन् र गाउँको थानमा चढाएर सुख-शान्तिको कामना गर्छन्। यस दिन गाउँका कुनै पनि सदस्यले हलो जोत्ने वा जमिन खन्ने काम गर्दैनन्।"
            ),
            keyFacts = listOf(
                "समय: हरेक वर्ष जेठ मसान्तदेखि असार पहिलो साता",
                "मुख्य थलो: थबाङ, मिरुल, तकसेरा, लुकुम, महत, जलजला",
                "नृत्य: २२ तालको भुमे नाच, दमाहा, सनाई र मादलको ताल"
            )
        ),
        CultureArticle(
            id = "art_2",
            titleKham = "खाम मगरको इतिहास र अठार मगरात",
            titleNepali = "खाम मगर जातिको गौरवशाली इतिहास र अठार मगरात",
            titleEnglish = "History of Kham Magars & The Athara Magarat",
            tag = "इतिहास (History & Origins)",
            summaryNepali = "नेपालको प्राचीन इतिहासमा मगरात भूमिलाई १२ मगरात र १८ मगरात गरी दुई भागमा चिनिन्छ। कर्णाली र धौलागिरिको मध्य पहाडमा बसोबास गर्ने खाम मगरहरू १८ मगरातका मुख्य बासिन्दा हुन्।",
            summaryEnglish = "In ancient Nepalese history, the Magar realm was divided into Barha Magarat and Athara Magarat (18 Confederacies). The Kham Magars residing along the Dhaulagiri and Karnali hills form the core of the Athara Magarat lineage.",
            contentSections = listOf(
                "अठार मगरातको भूक्षेत्र (Geographical Territory)" to
                        "रोल्पा, रुकुम, बागलुङ, जाजरकोट, सल्यान र डोल्पाका दुर्गम पहाडी उपत्यकाहरू ऐतिहासिक अठार मगरात क्षेत्र हुन्। यहाँ बोलिने खाम भाषा अन्य मगर ढुट भाषाभन्दा व्याकरण, ध्वनिविज्ञान र शब्दभण्डारमा निकै भिन्न र विशिष्ट छ।",
                "खाम जातिको जीवनशैली र खर्क परम्परा (Highland Pastoralism)" to
                        "खाम मगरहरू परम्परागत रूपमा पशुपालन (भेडा-बाख्रा, चौंरी) र खेतीपातीमा निर्भर थिए। हिउँदमा बेँसी र वर्षायाममा अग्ला बुकी तथा खर्कमा बथान लिएर जाने घुमन्ते गोठाले जीवनले उनीहरूको जीवनशैलीलाई साहसी, आत्मनिर्भर र प्रकृतिसँग एकाकार बनाएको छ।",
                "सामाजिक संगठन र भेषभुषा (Social Structure)" to
                        "गाउँमा 'मुखिया' र 'रोका' परम्पराले सामाजिक न्याय र विकास हेर्थ्यो। अल्लो (सिस्नुको धागो) बाट बनेको भाङ्ग्रा कपडाले चिसो, काँडा र वर्षाबाट शरीरको रक्षा गर्थ्यो भने पिठ्युँमा सामान बोक्न थैलीको काम पनि गर्थ्यो।"
            ),
            keyFacts = listOf(
                "मुख्य जिल्लाहरू: रोल्पा, रुकुम पूर्व, रुकुम पश्चिम, बागलुङ",
                "भाषा परिवार: चिनियाँ-तिब्बती (Tibeto-Burman), खाम-मगराती उपसमूह",
                "प्रमुख थरहरू: रोका, बुढा, पुन, घर्ती, झाँक्री, पुन मगर आदि"
            )
        ),
        CultureArticle(
            id = "art_3",
            titleKham = "झाँक्री परम्परा र ध्याङ्ग्रोको महिमा",
            titleNepali = "खाम झाँक्री परम्परा र ध्याङ्ग्रोको आध्यात्मिक रहस्य",
            titleEnglish = "Shamanic Heritage: The Kham Jhakri & Dhyangro",
            tag = "अध्यात्म र झाँक्री (Shamanism)",
            summaryNepali = "खाम समाजमा झाँक्री केवल धामी मात्र नभई प्राचीन लोकज्ञान, जडीबुटी, प्राकृतिक चिकित्सा र आध्यात्मिक मार्गदर्शकका रूपमा सम्मानित छन्।",
            summaryEnglish = "In Kham Magar society, the Jhakri (Shaman) is not only a spiritual healer but the supreme custodian of ancestral folklore, medicinal herbs, and natural equilibrium.",
            contentSections = listOf(
                "ध्याङ्ग्रोको बनावट र महत्व (The Sacred Drum)" to
                        "ध्याङ्ग्रो एउटा विशेष काठ (जस्तै दार वा पैंयुँ) बाट बनाइन्छ। यसको दुवैतर्फ मृग वा बाख्राको छाला मोडिन्छ। यसको समात्ने काठको डाँठलाई खड्ग वा बज्र आकारमा कुँदिएको हुन्छ जसले नकारात्मक शक्ति भगाउने विश्वास गरिन्छ।",
                "चिन्ता र उपचार पद्धति (The Healing Chinta Ritual)" to
                        "बिरामी परेमा वा अनिष्ट भएमा झाँक्रीले रातभरि ध्याङ्ग्रो बजाएर मुन्धुम/मन्त्र उच्चारण गर्दै 'चिन्ता' बस्छन्। उनीहरूले वनस्पति र जडीबुटीबाट बिरामीको उपचार गर्छन् र पूर्वजहरू (पितृ) को आत्मालाई शान्त पार्छन्।",
                "प्रकृतिसँगको गहिरो तालमेल (Harmony with Wilderness)" to
                        "झाँक्रीहरू वनदेवी, वनझाँक्री र भीरपहाराका देव-देवीहरूको पूजा गर्छन्। उनीहरूको विश्वास अनुसार मानिसले प्रकृतिलाई दोहन गरेमा वा फोहोर गरेमा दैवी प्रकोप आउँछ।"
            ),
            keyFacts = listOf(
                "बाजा: ध्याङ्ग्रो, घण्टी, शंख र सिङको बाजा",
                "पोसाक: सेतो जामा, मयुरको प्वाँखको मुकुट, रुद्राक्ष/घण्टीको माला",
                "ज्ञान: १०० भन्दा बढी पहाडी जडीबुटी र प्राकृतिक ओखतीको पहिचान"
            )
        ),
        CultureArticle(
            id = "art_4",
            titleKham = "ढुङ्गाका छाना र थबाङ-तकसेराको वास्तुशिल्प",
            titleNepali = "खाम गाउँहरूको परम्परागत वास्तुकला र ढुङ्गे शैली",
            titleEnglish = "Traditional Stone Slate Architecture of Kham Villages",
            tag = "वास्तुकला (Mountain Architecture)",
            summaryNepali = "रोल्पाको थबाङ र रुकुमको तकसेरा, कोल, मैकोट जस्ता खाम गाउँहरू बाक्लो ढुङ्गाका छाना र मिलेका काठका बुट्टेदार झ्याल-ढोकाका कारण विश्वमै अद्वितीय मानिन्छन्।",
            summaryEnglish = "High mountain villages like Thabang in Rolpa and Takasera, Kol, and Maikot in Rukum boast breathtaking multi-tiered stone slate roofs, timber balconies, and clustered defense-oriented architecture.",
            contentSections = listOf(
                "एकमाथि अर्को जोडिएका घरहरू (Clustered Rooftops)" to
                        "खाम गाउँहरूमा घरहरू यसरी एकआपसमा जोडिएका हुन्छन् कि एउटा घरको छत अर्को घरको आँगन जस्तो देखिन्छ। यसले जाडो याममा चिसो हावा छेक्न र समुदायलाई न्यानो राख्न मद्दत गर्दछ।",
                "स्थानीय काठ र स्लेट ढुङ्गा (Natural Materials)" to
                        "छानामा स्थानीय खानीबाट निकालिएका पातला स्लेट (ढुङ्गाका पाता) प्रयोग गरिन्छ। यी छानाहरूले सयौं वर्षसम्म हिमपात र वर्षालाई सजिलै थेग्छन्।",
                "अगेनो र सामाजिक बसाइ (The Hearth as Social Center)" to
                        "घरको मुटु भनेको चुल्हो (अगेनो) हो, जहाँ परिवार भेला भएर तातो पिउने, पाङ बोल्ने र परम्परागत कपडा बुन्ने गर्छन्।"
            ),
            keyFacts = listOf(
                "प्रसिद्ध गाउँहरू: थबाङ, तकसेरा, मैकोट, लुकुम, कोल, मिरुल",
                "शैली: स्लेट छाना, ढुङ्गे गारो र काठको बार्दली",
                "विशेषता: भूकम्प प्रतिरोधी परम्परागत काठ-ढुङ्गा प्रविधि"
            )
        )
    )

    // Practice Quiz Questions
    val quizQuestions: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "q1",
            questionPrompt = "'झोर्ले' (Jhorle) को नेपाली र अङ्ग्रेजी अर्थ के हो?",
            promptSubtext = "What does 'Jhorle' mean?",
            correctAnswer = "नमस्ते (Hello / Greetings)",
            options = listOf(
                "नमस्ते (Hello / Greetings)",
                "धन्यवाद (Thank you)",
                "पानी (Water)",
                "खाना (Food)"
            ),
            explanation = "'झोर्ले' (Jhorle) खाम मगर जातिको मौलिक र पवित्र अभिवादन हो।",
            audioDevanagari = "झोर्ले"
        ),
        QuizQuestion(
            id = "q2",
            questionPrompt = "खाम भाषामा 'पानी' लाई के भनिन्छ?",
            promptSubtext = "How do you say 'Water' in Kham Pang?",
            correctAnswer = "ति (Ti)",
            options = listOf(
                "ति (Ti)",
                "झ्या (Zhya)",
                "मे (Me)",
                "सा (Sa)"
            ),
            explanation = "खाम भाषामा पानीलाई 'ति' (Ti) र आगोलाई 'मे' (Me) भनिन्छ।",
            audioDevanagari = "ति"
        ),
        QuizQuestion(
            id = "q3",
            questionPrompt = "खाम भाषामा 'तुप', 'नेः', 'सोम' ले के बुझाउँछ?",
            promptSubtext = "What do 'Tup', 'Neh', 'Som' represent?",
            correctAnswer = "एक, दुई, तीन (1, 2, 3)",
            options = listOf(
                "एक, दुई, तीन (1, 2, 3)",
                "खाना, पानी, घर",
                "बुबा, आमा, दाजु",
                "घाम, जून, तारा"
            ),
            explanation = "'तुप' = १, 'नेः' = २, 'सोम' = ३, 'ब्जि' = ४, 'प्ङा' = ५।",
            audioDevanagari = "तुप ने सोम"
        ),
        QuizQuestion(
            id = "q4",
            questionPrompt = "'ना मिन कथा रो?' भन्नाले के सोधिएको हो?",
            promptSubtext = "What question is 'Na min katha ro?' asking?",
            correctAnswer = "तिम्रो नाम के हो? (What is your name?)",
            options = listOf(
                "तिम्रो नाम के हो? (What is your name?)",
                "कहाँ जाँदैछौ? (Where are you going?)",
                "खाना खायौ? (Did you eat?)",
                "कति वर्ष भयौ? (How old are you?)"
            ),
            explanation = "'मिन' को अर्थ नाम र 'कथा' को अर्थ के/कस्तो हुन्छ।",
            audioDevanagari = "ना मिन कथा रो"
        ),
        QuizQuestion(
            id = "q5",
            questionPrompt = "खाम मगर समुदायको सबैभन्दा ठूलो प्रकृतिको पर्व कुन हो?",
            promptSubtext = "Which is the greatest nature festival of Kham Magars?",
            correctAnswer = "भुमे पर्व / बल पूजा (Bhume Parva)",
            options = listOf(
                "भुमे पर्व / बल पूजा (Bhume Parva)",
                "दसैं (Dashain)",
                "होली (Holi)",
                "ल्होसार (Lhosar)"
            ),
            explanation = "भुमे पर्वमा २२ तालको मौलिक नृत्य गरिन्छ र जमिनको पूजा गरिन्छ।",
            audioDevanagari = "भुमे"
        ),
        QuizQuestion(
            id = "q6",
            questionPrompt = "अल्लो वा सिस्नुको धागोबाट बनेको परम्परागत मगर पोसाक कुन हो?",
            promptSubtext = "Which handwoven attire is made from wild nettle fiber?",
            correctAnswer = "भाङ्ग्रा (Bhangra)",
            options = listOf(
                "भाङ्ग्रा (Bhangra)",
                "दौरा सुरुवाल",
                "कुर्ता",
                "बख्खु"
            ),
            explanation = "भाङ्ग्रा छातीमा छड्के पारेर भिर्ने खाम मगरहरूको विशिष्ट पोसाक र झोला हो।",
            audioDevanagari = "भाङ्ग्रा"
        ),
        QuizQuestion(
            id = "q7",
            questionPrompt = "'ङा झिमका बान्या' को सही नेपाली अर्थ छान्नुहोस्:",
            promptSubtext = "Select the correct Nepali meaning of 'Nga zhim-ka banya':",
            correctAnswer = "म घर जाँदैछु (I am going home)",
            options = listOf(
                "म घर जाँदैछु (I am going home)",
                "म बजार जान्छु (I go to market)",
                "म खाना खाँदैछु (I am eating)",
                "म खेल्न जान्छु (I go to play)"
            ),
            explanation = "'ङा' = म, 'झिम' = घर, 'बान्या' = जानु/हिँड्नु।",
            audioDevanagari = "ङा झिमका बान्या"
        ),
        QuizQuestion(
            id = "q8",
            questionPrompt = "खाम भाषामा 'घाम' र 'जून' लाई के भनिन्छ?",
            promptSubtext = "What are the Sun and Moon called in Kham?",
            correctAnswer = "तिनाम र ल्हा (Tinam & Lha)",
            options = listOf(
                "तिनाम र ल्हा (Tinam & Lha)",
                "सा र नाम",
                "मे र ति",
                "सिङ र ढुङ्गा"
            ),
            explanation = "'तिनाम' = सूर्य/घाम, 'ल्हा' = चन्द्रमा/जून।",
            audioDevanagari = "तिनाम र ल्हा"
        )
    )

    // Flashcard Pairs for Word Matching game
    val matchPairs: List<Pair<String, String>> = listOf(
        "झोर्ले (Jhorle)" to "नमस्ते (Hello)",
        "ति (Ti)" to "पानी (Water)",
        "झ्या (Zhya)" to "भात/खाना (Food)",
        "झिम (Zhim)" to "घर (House)",
        "तिनाम (Tinam)" to "घाम (Sun)",
        "ल्हा (Lha)" to "चन्द्रमा (Moon)",
        "सा (Sa)" to "माटो (Earth)",
        "आबा (Aba)" to "बुबा (Father)",
        "आमा (Aama)" to "आमा (Mother)",
        "भाङ्ग्रा (Bhangra)" to "मौलिक पोसाक (Magar Vest)"
    )
}
