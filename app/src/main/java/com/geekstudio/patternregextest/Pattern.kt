package com.geekstudio.patternregextest

import java.util.regex.Pattern

object Pattern {
    val numberDummy = arrayListOf(
        "123456789",
        "ⅣⅦ",
        "ⅾↀↁ"
    )

    val specialLanguageDummy = arrayListOf(
        "!@#$%^&*()_+",
        "♡゚゚゚̥̥̊",
        "♤♢",
        "㊎㊮",
        "◐⊙〇"
    )

    const val spaceDummy = " "

    val languageDummy: List<String> by lazy {
        arrayListOf<String>().apply {
            addAll(koreaLanguageDummy)
            addAll(japaneseLanguageDummy)
            addAll(englishLanguageDummy)
            addAll(vietnamLanguageDummy)
            addAll(chineseLanguageDummy)
        }
    }

    val englishLanguageDummy = arrayListOf(
        "Test",
        "asdfasdfasdf",
    )

    val vietnamLanguageDummy = arrayListOf(
        "sựđaukhổvềthểchất",
        "giaohàngtrễhẹn",
    )

    val koreaLanguageDummy = arrayListOf(
        "테스트",
        "ㄴㅁㅇㄻㄴㅇㄹ",
    )

    val chineseLanguageDummy = arrayListOf(
        "聊天机器人的出现让我们可以更方便地获取信息",
        "复习",
        "你买好电影票了吗"
    )

    val japaneseLanguageDummy = arrayListOf(
        "せんりょう",
        "ついで",
        "出待ち"
    )

    fun isRegexMatches(string: String, regex: String = "\\p{L}"): Boolean {
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(string)
        return matcher.matches()
    }
}