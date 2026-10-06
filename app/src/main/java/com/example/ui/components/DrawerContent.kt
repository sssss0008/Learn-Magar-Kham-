package com.example.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.LanguageDisplayMode

@Composable
fun AppDrawerContent(
    currentTab: Int,
    languageMode: LanguageDisplayMode,
    onSelectTab: (Int) -> Unit,
    onSelectLanguageMode: (LanguageDisplayMode) -> Unit,
    onOpenDictionary: () -> Unit,
    onOpenPronunciationGuide: () -> Unit,
    onOpenFeedbackDialog: () -> Unit,
    onCloseDrawer: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .width(320.dp)
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState())
    ) {
        // === DRAWER HEADER ===
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF8B1E2D),
                            Color(0xFF5A0D18)
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "🏔️", fontSize = 28.sp)
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "मगर खाम भाषा (Magar Kham)",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "खाम् पाङ सिकाइ र संस्कृति • त्रैभाषिक एप",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFFFD54F)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // === 4 NAVIGATION TABS SHORTCUTS ===
        Text(
            text = "मुख्य खण्डहरू (Main Tabs):",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)
        )

        NavigationDrawerItem(
            label = { Text("गृहपृष्ठ (Home)") },
            selected = currentTab == 0,
            onClick = {
                onSelectTab(0)
                onCloseDrawer()
            },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            label = { Text("शब्दावली र पाठहरू (Learn)") },
            selected = currentTab == 1,
            onClick = {
                onSelectTab(1)
                onCloseDrawer()
            },
            icon = { Icon(Icons.Default.School, contentDescription = null) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            label = { Text("अभ्यास र क्विज (Practice)") },
            selected = currentTab == 2,
            onClick = {
                onSelectTab(2)
                onCloseDrawer()
            },
            icon = { Icon(Icons.Default.Quiz, contentDescription = null) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            label = { Text("संस्कृति र विवरण (About & Culture)") },
            selected = currentTab == 3,
            onClick = {
                onSelectTab(3)
                onCloseDrawer()
            },
            icon = { Icon(Icons.Default.Celebration, contentDescription = null) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))

        // === SPECIAL TOOLS ===
        Text(
            text = "सिकाइ औजारहरू (Learning Tools):",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
        )

        DrawerActionItem(
            icon = Icons.Default.Book,
            label = "खाम शब्दकोश (Trilingual Dictionary)",
            onClick = {
                onCloseDrawer()
                onOpenDictionary()
            }
        )

        DrawerActionItem(
            icon = Icons.Default.VolumeUp,
            label = "ध्वनि तथा उच्चारण नियम (Phonetics Guide)",
            onClick = {
                onCloseDrawer()
                onOpenPronunciationGuide()
            }
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))

        // === LANGUAGE DISPLAY MODE CHOOSER ===
        Text(
            text = "भाषा प्रदर्शन शैली (Display Mode):",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
        )

        LanguageDisplayMode.values().forEach { mode ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelectLanguageMode(mode) }
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = languageMode == mode,
                    onClick = { onSelectLanguageMode(mode) }
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = mode.label,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = if (languageMode == mode) FontWeight.Bold else FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Divider(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))

        // === DEVELOPER CONTACT IN DRAWER ===
        Text(
            text = "प्रतिक्रिया र सम्पर्क (Feedback & Contacts):",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
        )

        DrawerContactItem(
            icon = Icons.Default.Email,
            text = "awiskaracharya@gmail.com",
            onClick = { openEmail(context, "awiskaracharya@gmail.com", "Magar Kham App Inquiry") }
        )

        DrawerContactItem(
            icon = Icons.Default.Call,
            text = "+977 9827106244 (Call / WhatsApp)",
            onClick = { openDialer(context, "+9779827106244") }
        )

        DrawerContactItem(
            icon = Icons.Default.Link,
            text = "linkedin.com/in/awiskaracharya",
            onClick = { openUrl(context, "https://www.linkedin.com/in/awiskaracharya/") }
        )

        DrawerActionItem(
            icon = Icons.Default.Feedback,
            label = "सुझाव दिनुहोस् (Send App Feedback)",
            onClick = {
                onCloseDrawer()
                onOpenFeedbackDialog()
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun DrawerActionItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun DrawerContactItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1
        )
    }
}
