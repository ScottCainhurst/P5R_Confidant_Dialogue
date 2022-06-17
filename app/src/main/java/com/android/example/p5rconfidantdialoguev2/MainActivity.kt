package com.android.example.p5rconfidantdialoguev2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.example.p5rconfidantdialoguev2.Database.ConfidantApplication
import com.android.example.p5rconfidantdialoguev2.Database.ConfidantRoomDatabase
import com.android.example.p5rconfidantdialoguev2.Database.ConfidantViewModel
import com.android.example.p5rconfidantdialoguev2.databinding.ActivityMainBinding
import com.android.example.p5rconfidantdialoguev2.databinding.BindingButtonListBinding
import timber.log.Timber
import java.util.*

class MainActivity : AppCompatActivity() {

    /*
    Change text finder activity to a fragment and make it so that when
     */
    private lateinit var binding: BindingButtonListBinding
    private lateinit var hangoutspinner: Spinner
    private lateinit var database: ConfidantRoomDatabase
    private val viewModel: ConfidantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = ConfidantRoomDatabase.buildDatabase(this)
        binding = BindingButtonListBinding.inflate(layoutInflater)
        binding.root
        setContentView(binding.root)
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        hangoutspinner = findViewById(R.id.hangoutspinner)
        setUpSpinners()

        /*val confidantObserver = Observer()
        viewModel.confidantName.observe(this,confidantObserver)*/
        //All of the buttons to launch intents and check hangouts
        binding.ryujiimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Ryuji has been pressed")
            if(stopInvalidhangouts()){
                sendryuji()
            }
        }
        binding.annimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i( "Ann has been pressed")
            if(stopInvalidhangouts()) {
                sendann()
            }
        }
        binding.yusukeimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Yusuke has been pressed")
            if(stopInvalidhangouts()) {
                sendyusuke()
            }
        }
        binding.makotoimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Makoto has been pressed")
            if(stopInvalidhangouts()) {
                sendmakoto()
            }
        }
        binding.futabaimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Futaba has been pressed")
            if(stopInvalidhangouts()) {
                sendfutaba()
            }
        }
        binding.haruimagebutton.setOnClickListener {
            Timber.tag("Confidant Tests").i("Haru has been pressed")
            if (stopInvalidhangouts()) {
                sendharu()
            }
        }
        binding.akechiimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Akechi has been pressed")
            if(stopInvalidhangouts()) {
                sendakechi()
            }
        }
        binding.kasumiimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Kasumi has been pressed")
            if (stopInvalidhangouts()) {
                sendkasumi()
            }
        }
        binding.sojiroimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Sojiro has been pressed")
            if(stopInvalidhangouts()) {
                sendsojiro()
            }
        }
        binding.takemiimagebutton.setOnClickListener {
            Timber.tag("Confidant Tests").i("Takemi has been pressed")
            if (stopInvalidhangoutsTakemiHifumiChihayaIwaiOhya()) {
                sendtakemi()
            }
        }
        binding.mishimaimagebutton.setOnClickListener{
           Timber.tag("Confidant Tests").i("Mishima has been pressed")
           if(stopInvalidhangoutsMishima()){
               sendmishima()
           }
        }
        binding.marukiimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Maruki has been pressed")
            if(stopInvalidhangouts()) {
                sendmaruki()
            }
        }
        binding.kawakamiimagebutton.setOnClickListener {
            Timber.tag("Confidant Tests").i("Kawakami has been pressed")
            if (stopInvalidhangoutsKawakami()) {
                sendkawakami()
            }
        }
        binding.iwaiimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Iwai has been pressed")
            if (stopInvalidhangoutsTakemiHifumiChihayaIwaiOhya()) {
                sendiwai()
            }
        }
        binding.yoshidaimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Yoshida has been pressed")
            if(stopInvalidhangouts()) {
                sendyoshida()
            }
        }
        binding.shinyaimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Shinya has been pressed")
            if(stopInvalidhangouts()) {
                sendshinya()
            }
        }
        binding.hifumiimagebutton.setOnClickListener {
            Timber.tag("Confidant Tests").i("Hifumi has been pressed")
            if (stopInvalidhangoutsTakemiHifumiChihayaIwaiOhya()) {
                sendhifumi()
            }
        }
        binding.chihayaimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Chihaya has been pressed")
            if(stopInvalidhangoutsTakemiHifumiChihayaIwaiOhya()){
                sendchihaya()
            }
        }
        binding.ohyaimagebutton.setOnClickListener{
            Timber.tag("Confidant Tests").i("Ohya has been pressed")
            if(stopInvalidhangoutsTakemiHifumiChihayaIwaiOhya()){
                sendohya()
            }
        }
    }
    private fun setUpSpinners() {
        ArrayAdapter.createFromResource(
                this,
                R.array.Hangout_Selector,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            hangoutspinner.adapter = adapter
        }
    }
    //These functions prevents the intent from launching if the character does not have one of the specific hangouts
    private fun stopInvalidhangouts(): Boolean {
        return if(hangoutspinner.selectedItem == "Select your Confidant Rank" || hangoutspinner.selectedItem == "6.5(Mishima)" || hangoutspinner.selectedItem == "7.5(Takemi, Hifumi, Chihaya, Iwai, Ohya)" || hangoutspinner.selectedItem == "8.5(Kawakami)"){
            Toast.makeText(this, "Please choose another rank from the drop down", Toast.LENGTH_SHORT).show()
            false
        } else{
            true
        }
    }
    private fun stopInvalidhangoutsMishima(): Boolean {
        return if(hangoutspinner.selectedItem == "Select your Confidant Rank"  || hangoutspinner.selectedItem == "7.5(Takemi, Hifumi, Chihaya, Iwai, Ohya)" || hangoutspinner.selectedItem == "8.5(Kawakami)"){
            Toast.makeText(this, "Please choose another rank from the drop down", Toast.LENGTH_SHORT).show()
            false
        } else{
            true
        }
    }
    private fun stopInvalidhangoutsTakemiHifumiChihayaIwaiOhya(): Boolean {
        return if(hangoutspinner.selectedItem == "Select your Confidant Rank" || hangoutspinner.selectedItem == "6.5(Mishima)" || hangoutspinner.selectedItem == "8.5(Kawakami)"){
            Toast.makeText(this, "Please choose another rank from the drop down", Toast.LENGTH_SHORT).show()
            false
        }
        else{
            true
        }
    }
    private fun stopInvalidhangoutsKawakami(): Boolean {
        return if(hangoutspinner.selectedItem == "Select your Confidant Rank"  || hangoutspinner.selectedItem == "7.5(Takemi, Hifumi, Chihaya, Iwai, Ohya)"){
            Toast.makeText(this, "Please choose another rank from the drop down", Toast.LENGTH_SHORT).show()
            false
        }
        else{
            true
        }
    }
    //All of the intent functions for each character
    private fun sendryuji() {
        val ryujiintent = Intent(this, TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Ryuji the Chariot"
        ryujiintent.putExtra(CONFIDANT, confidant)
        ryujiintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(ryujiintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is $hangoutnumber")
}
    private fun sendann(){
        val annintent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Ann the Lovers"
        annintent.putExtra(CONFIDANT, confidant)
        annintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(annintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendyusuke() {
        val yusukeintent = Intent(this, TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Yusuke the Emperor"
        yusukeintent.putExtra(CONFIDANT, confidant)
        yusukeintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(yusukeintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendmakoto() {
        val makototintent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Makoto the Priestess"
        makototintent.putExtra(CONFIDANT, confidant)
        makototintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(makototintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendfutaba() {
        val futabaintent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Futaba the Hermit"
        futabaintent.putExtra(CONFIDANT, confidant)
        futabaintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(futabaintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendharu(){
        val haruintent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Haru the Empress"
        haruintent.putExtra(CONFIDANT, confidant)
        haruintent.putExtra(HANGOUTNUMBER,hangoutnumber)
        startActivity(haruintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendkasumi(){
        val kasumiintent = Intent(this, TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Kasumi the Faith"
        kasumiintent.putExtra(CONFIDANT, confidant)
        kasumiintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(kasumiintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")

    }
    private fun sendakechi() {
        val akechiintent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Akechi the Justice"
        akechiintent.putExtra(CONFIDANT, confidant)
        akechiintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(akechiintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendsojiro() {
        val sojirointent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Sojiro the Hierophant"
        sojirointent.putExtra(CONFIDANT, confidant)
        sojirointent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(sojirointent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendtakemi() {
        val takemiintent = Intent(this,TextFinderActivity::class.java)
        var hangoutnumber = hangoutspinner.selectedItem.toString()
        if(hangoutnumber == "7.5(Takemi, Hifumi, Chihaya, Iwai, Ohya)"){
            hangoutnumber= 10.toString()
        }
        val confidant = "Takemi the Death"
        takemiintent.putExtra(CONFIDANT, confidant)
        takemiintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(takemiintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendmishima() {
        val mishimaintent = Intent(this,TextFinderActivity::class.java)
        var hangoutnumber=  hangoutspinner.selectedItem.toString()
        if(hangoutnumber == "6.5(Mishima)"){
            hangoutnumber= 10.toString()
        }
        val confidant = "Mishima the Moon"
        mishimaintent.putExtra(CONFIDANT, confidant)
        mishimaintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(mishimaintent)
        Timber.tag("Confidant Tests").i("confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i("hangoutnumber in main activity is is $hangoutnumber")

    }
    private fun sendmaruki() {
        val marukiintent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Maruki the Councillor"
        marukiintent.putExtra(CONFIDANT, confidant)
        marukiintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(marukiintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendkawakami() {
        val kawakamiintent = Intent(this,TextFinderActivity::class.java)
        var hangoutnumber = hangoutspinner.selectedItem.toString()
        if(hangoutnumber == "8.5(Kawakami)"){
            hangoutnumber= 10.toString()
        }
        val confidant = "Kawakami the Temperance"
        kawakamiintent.putExtra(CONFIDANT, confidant)
        kawakamiintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(kawakamiintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendiwai() {
        val iwaiintent = Intent(this,TextFinderActivity::class.java)
        var hangoutnumber = hangoutspinner.selectedItem.toString()
        if(hangoutnumber == "7.5(Takemi, Hifumi, Chihaya, Iwai, Ohya)"){
            hangoutnumber= 10.toString()
        }
        val confidant = "Iwai the Hanged"
        iwaiintent.putExtra(CONFIDANT, confidant)
        iwaiintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(iwaiintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendyoshida() {
        val yoshidaintent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Yoshida the Sun"
        yoshidaintent.putExtra(CONFIDANT, confidant)
        yoshidaintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(yoshidaintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendshinya() {
        val shinyaintent = Intent(this,TextFinderActivity::class.java)
        val hangoutnumber = hangoutspinner.selectedItem.toString()
        val confidant = "Shinya the Tower"
        shinyaintent.putExtra(CONFIDANT, confidant)
        shinyaintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(shinyaintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendhifumi() {
        val hifumiintent = Intent(this,TextFinderActivity::class.java)
        var hangoutnumber = hangoutspinner.selectedItem.toString()
        if(hangoutnumber == "7.5(Takemi, Hifumi, Chihaya, Iwai, Ohya)"){
            hangoutnumber= 10.toString()
        }
        val confidant = "Hifumi the Star"
        hifumiintent.putExtra(CONFIDANT, confidant)
        hifumiintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(hifumiintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i("hangoutnumber is $hangoutnumber")
    }
    private fun sendchihaya() {
        val chihayaintent = Intent(this,TextFinderActivity::class.java)
        var hangoutnumber = hangoutspinner.selectedItem.toString()
        if(hangoutnumber == "7.5(Takemi, Hifumi, Chihaya, Iwai, Ohya)"){
            hangoutnumber= 10.toString()
        }
        val confidant = "Chihaya the Fortune"
        chihayaintent.putExtra(CONFIDANT, confidant)
        chihayaintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(chihayaintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }
    private fun sendohya() {
        val ohyaintent = Intent(this,TextFinderActivity::class.java)
        var hangoutnumber = hangoutspinner.selectedItem.toString()
        if(hangoutnumber == "7.5(Takemi, Hifumi, Chihaya, Iwai, Ohya)"){
            hangoutnumber= 10.toString()
        }
        val confidant = "Ohya the Devil"
        ohyaintent.putExtra(CONFIDANT, confidant)
        ohyaintent.putExtra(HANGOUTNUMBER, hangoutnumber.toInt())
        startActivity(ohyaintent)
        Timber.tag("Confidant Tests").i( "confidant in main activity is $confidant")
        Timber.tag("Confidant Tests").i( "hangoutnumber in main activity is is $hangoutnumber")
    }

   companion object {
       const val CONFIDANT = "confidant"
       const val HANGOUTNUMBER = "hangoutnumber"
   }
}