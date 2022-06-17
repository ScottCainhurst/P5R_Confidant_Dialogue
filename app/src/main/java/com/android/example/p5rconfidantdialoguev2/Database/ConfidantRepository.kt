package com.android.example.p5rconfidantdialoguev2.Database

import com.android.example.p5rconfidantdialoguev2.dialogueText

interface ConfidantRepository{
    fun insertDialogue(dialogueText: List<dialogueText>)

    fun getConfidant(): List<dialogueText>

    fun getDialogue(character: Int, hangoutid: Int): String

}