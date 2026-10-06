package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.KhamCategory
import com.example.data.KhamRepository
import com.example.data.UserPreferences
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Magar Kham", appName)
    }

    @Test
    fun `verify vocabulary repository contains authentic categories`() {
        val vocab = KhamRepository.allVocabulary
        assertTrue("Vocabulary should not be empty", vocab.isNotEmpty())
        assertTrue("Contains greetings", vocab.any { it.category == KhamCategory.GREETINGS })
        assertTrue("Contains numbers", vocab.any { it.category == KhamCategory.NUMBERS })
        assertTrue("Contains cultural words", vocab.any { it.category == KhamCategory.CULTURE })

        val jhorle = vocab.firstOrNull { it.id == "greet_1" }
        assertEquals("झोर्ले", jhorle?.khamDevanagari)
    }

    @Test
    fun `verify bookmark toggle in user preferences`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val prefs = UserPreferences(context)

        val testId = "test_word_1"
        assertFalse(prefs.getBookmarkedIds().contains(testId))

        val added = prefs.toggleBookmark(testId)
        assertTrue(added)
        assertTrue(prefs.getBookmarkedIds().contains(testId))

        val removed = prefs.toggleBookmark(testId)
        assertFalse(removed)
        assertFalse(prefs.getBookmarkedIds().contains(testId))
    }
}
