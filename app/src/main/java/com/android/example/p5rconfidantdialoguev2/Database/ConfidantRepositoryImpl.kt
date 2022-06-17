package com.android.example.p5rconfidantdialoguev2.Database

import com.android.example.p5rconfidantdialoguev2.dialogueText

class ConfidantRepositoryImpl(private val confidantDao: ConfidantDao): ConfidantRepository {
    override fun insertDialogue(dialogueText: List<dialogueText>) = confidantDao.insertDialogueText(dialogueText)

    override fun getConfidant(): List<dialogueText> = confidantDao.getConfidant()

    override fun getDialogue(character: Int, hangoutid: Int): String = confidantDao.getDialogue(character, hangoutid)

}