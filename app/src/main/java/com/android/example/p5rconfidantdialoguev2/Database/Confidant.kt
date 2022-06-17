package com.android.example.p5rconfidantdialoguev2

import androidx.room.*
import kotlin.Unit.toString


@Entity
data class dialogueText(
        @PrimaryKey
        val dialogueid: String,

        val character: Int,

        val hangoutid: Int
        )




