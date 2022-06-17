package com.android.example.p5rconfidantdialoguev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.android.example.p5rconfidantdialoguev2.Database.*
import com.android.example.p5rconfidantdialoguev2.MainActivity.Companion.CONFIDANT
import com.android.example.p5rconfidantdialoguev2.MainActivity.Companion.HANGOUTNUMBER
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber


class TextFinderActivity : AppCompatActivity() {

        private val repository by lazy { ConfidantApplication.repository }
        private val viewModel: ConfidantViewModel by viewModels()
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_text_finder)
                if (BuildConfig.DEBUG) {
                        Timber.plant(Timber.DebugTree())
                }
                val dialogueprint: TextView = findViewById(R.id.dialogueprint)
                val hangoutprint: TextView = findViewById(R.id.hangoutprint)
                val charactername: String? = intent.getStringExtra(CONFIDANT)
                val hangoutNumber: Int = intent.getIntExtra(HANGOUTNUMBER, 0)
                Timber.tag("Confidant Tests").i("charactername in Text Finder Activity is $charactername")
                hangoutprint.text = hangoutNumber.toString()
                Timber.tag("Confidant Tests").i("hangoutnumber in Text Finder Activity is $hangoutNumber")
                title = charactername
                when (charactername) {
                        "Ryuji the Chariot" -> dialogueprint.text = repository.getDialogue(0, hangoutNumber -1)
                        "Maruki the Councillor" -> dialogueprint.text = repository.getDialogue(1, hangoutNumber -1)
                        "Takemi the Death" -> dialogueprint.text = repository.getDialogue(2, hangoutNumber -1)
                        "Ohya the Devil" -> dialogueprint.text = repository.getDialogue(3,hangoutNumber -1)
                        "Yusuke the Emperor" -> dialogueprint.text = repository.getDialogue(4,hangoutNumber -1)
                        "Haru the Empress" -> dialogueprint.text = repository.getDialogue(5, hangoutNumber -1)
                        "Kasumi the Faith" -> dialogueprint.text = repository.getDialogue(6, hangoutNumber -1)
                        "Chihaya the Fortune" -> dialogueprint.text = repository.getDialogue(7,hangoutNumber -1)
                        "Iwai the Hanged" -> dialogueprint.text = repository.getDialogue(8, hangoutNumber -1)
                        "Futaba the Hermit" -> dialogueprint.text = repository.getDialogue(9,hangoutNumber -1)
                        "Sojiro the Hierophant" -> dialogueprint.text = repository.getDialogue(10, hangoutNumber -1)
                        "Akechi the Justice" -> dialogueprint.text = repository.getDialogue(11, hangoutNumber -1)
                        "Ann the Lovers" -> dialogueprint.text = repository.getDialogue(12, hangoutNumber -1)
                        "Mishima the Moon" -> dialogueprint.text = repository.getDialogue(13, hangoutNumber -1)
                        "Makoto the Priestess" -> dialogueprint.text = repository.getDialogue(14, hangoutNumber -1)
                        "Hifumi the Star" -> dialogueprint.text = repository.getDialogue(15, hangoutNumber -1)
                        "Yoshida the Sun" -> dialogueprint.text = repository.getDialogue(16, hangoutNumber -1)
                        "Kawakami the Temperance" -> dialogueprint.text = repository.getDialogue(17, hangoutNumber - 1)
                        "Shinya the Tower" -> dialogueprint.text = repository.getDialogue(18, hangoutNumber -1)

                }
        }
}


