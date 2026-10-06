package com.example.data

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("kham_learning_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_BOOKMARKS = "key_bookmarks"
        private const val KEY_MASTERED = "key_mastered"
        private const val KEY_STREAK = "key_streak"
        private const val KEY_SCORE = "key_score"
        private const val KEY_QUIZZES_COUNT = "key_quizzes_count"
        private const val KEY_LANG_MODE = "key_lang_mode"
    }

    fun getBookmarkedIds(): Set<String> {
        return prefs.getStringSet(KEY_BOOKMARKS, emptySet()) ?: emptySet()
    }

    fun toggleBookmark(id: String): Boolean {
        val current = getBookmarkedIds().toMutableSet()
        val isAdded: Boolean
        if (current.contains(id)) {
            current.remove(id)
            isAdded = false
        } else {
            current.add(id)
            isAdded = true
        }
        prefs.edit().putStringSet(KEY_BOOKMARKS, current).apply()
        return isAdded
    }

    fun getMasteredIds(): Set<String> {
        return prefs.getStringSet(KEY_MASTERED, emptySet()) ?: emptySet()
    }

    fun markMastered(id: String, mastered: Boolean = true) {
        val current = getMasteredIds().toMutableSet()
        if (mastered) current.add(id) else current.remove(id)
        prefs.edit().putStringSet(KEY_MASTERED, current).apply()
    }

    fun getStreakDays(): Int = prefs.getInt(KEY_STREAK, 3)

    fun incrementStreak() {
        prefs.edit().putInt(KEY_STREAK, getStreakDays() + 1).apply()
    }

    fun getPracticeScore(): Int = prefs.getInt(KEY_SCORE, 150)

    fun addPracticeScore(points: Int) {
        prefs.edit().putInt(KEY_SCORE, getPracticeScore() + points).apply()
    }

    fun getQuizzesCount(): Int = prefs.getInt(KEY_QUIZZES_COUNT, 5)

    fun incrementQuizzesCount() {
        prefs.edit().putInt(KEY_QUIZZES_COUNT, getQuizzesCount() + 1).apply()
    }

    fun getLanguageMode(): LanguageDisplayMode {
        val name = prefs.getString(KEY_LANG_MODE, LanguageDisplayMode.TRILINGUAL.name)
        return try {
            LanguageDisplayMode.valueOf(name ?: LanguageDisplayMode.TRILINGUAL.name)
        } catch (_: Exception) {
            LanguageDisplayMode.TRILINGUAL
        }
    }

    fun setLanguageMode(mode: LanguageDisplayMode) {
        prefs.edit().putString(KEY_LANG_MODE, mode.name).apply()
    }
}
