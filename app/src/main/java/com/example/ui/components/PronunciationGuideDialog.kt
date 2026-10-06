package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun PronunciationGuideDialog(
    onSpeakSample: (String) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "खाम भाषा ध्वनि र उच्चारण",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Kham Pang Phonetics & Tonal Guide",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Intro explanation
                Text(
                    text = "मगर खाम भाषा भोट-बर्मेली (Tibeto-Burman) परिवारको विशिष्ट भाषा हो। यसमा स्वरको लम्बाइ (Tense vs Lax Vowels), स्वासको कम्पन (Aspiration) र घाँटीको रुकावट (Glottal stops) ले शब्दको अर्थ फरक पार्छन्।",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Guide Point 1: ङ (Nga)
                PhoneticRuleItem(
                    title = "१. कण्ठ्य नासिक्य ध्वनि 'ङ' (Nga)",
                    description = "खाम भाषामा धेरै शब्दहरू 'ङ' बाट सुरु हुन्छन्, जस्तै 'ङा' (म / Me), 'ङो' (हाँस)। यसको उच्चारण नेपाली 'सिंघ' वा अङ्ग्रेजी 'sing' को 'ng' जस्तै घाँटीबाट नाकको सहायताले गरिन्छ।",
                    sampleWord = "ङा (Nga - I)",
                    onSpeak = { onSpeakSample("ङा") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Guide Point 2: विसर्ग र सासको रुकावट (Glottal Stop)
                PhoneticRuleItem(
                    title = "२. घाँटीको रुकावट र विसर्ग (:)",
                    description = "खाम भाषामा 'नेः' (दुई / Two) वा 'तुः' (छ / Six) जस्ता शब्दमा स्वरको अन्त्यमा सासलाई घाँटीमा छोटो समय रोकिन्छ (Glottal stop)।",
                    sampleWord = "नेः (Neh - Two)",
                    onSpeak = { onSpeakSample("नेः") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Guide Point 3: ब्जि र ज्ह (Voiced Fricatives)
                PhoneticRuleItem(
                    title = "३. संयुक्त उष्मा ध्वनि 'ब्जि' (Bzi) र 'झ्या' (Zhya)",
                    description = "'झ्या' (खाना) र 'ब्जि' (चार) मा ओठ र जिब्रोको तालु रगडेर आवाज निकालिन्छ। अङ्ग्रेजी 'measure' को 's' वा फ्रेन्च 'j' जस्तै उच्चारण हुन्छ।",
                    sampleWord = "झ्या (Zhya - Food)",
                    onSpeak = { onSpeakSample("झ्या") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Guide Point 4: क्रियापदको प्रत्यय '-न्या' (-nya)
                PhoneticRuleItem(
                    title = "४. क्रियापदको अन्त्यमा '-न्या' (-nya)",
                    description = "खाम भाषाका अधिकांश मूल क्रियापदहरू '-न्या' मा टुङ्गिन्छन्; जस्तै 'बान्या' (जानु), 'हुन्या' (आउनु), 'झ्यान्या' (खानु), 'थुन्या' (पिउनु)।",
                    sampleWord = "बान्या (Banya - To go)",
                    onSpeak = { onSpeakSample("बान्या") }
                )
            }
        }
    }
}

@Composable
private fun PhoneticRuleItem(
    title: String,
    description: String,
    sampleWord: String,
    onSpeak: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "उदाहरण: $sampleWord",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary
                )
                IconButton(
                    onClick = onSpeak,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Listen",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}
