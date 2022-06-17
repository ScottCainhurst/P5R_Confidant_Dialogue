package com.android.example.p5rconfidantdialoguev2.Database

import androidx.room.*
import com.android.example.p5rconfidantdialoguev2.dialogueText

@Dao
interface ConfidantDao{


@Insert(onConflict = OnConflictStrategy.IGNORE)
 fun insertDialogueText(dialogueText: List<dialogueText>)

 @Query("SELECT * FROM dialogueText")
 fun getConfidant(): List<dialogueText>

@Query("SELECT dialogueid FROM dialogueText WHERE character = :character AND hangoutid = :hangoutid")

fun getDialogue(character: Int, hangoutid: Int): String

}