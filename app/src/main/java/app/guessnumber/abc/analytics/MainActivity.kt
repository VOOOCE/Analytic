package app.guessnumber.abc.analytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.guessnumber.abc.analytics.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        analytics = Firebase.analytics

        binding.select.setOnClickListener {
            selectEvent("Id","Name","Content")
        }
        binding.track.setOnClickListener {
            trackScreen()
        }
    }
    private fun selectEvent(id:String,name:String,content:String){
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
            param(FirebaseAnalytics.Param.ITEM_ID,id)
            param(FirebaseAnalytics.Param.ITEM_NAME,name)
            param(FirebaseAnalytics.Param.CONTENT_TYPE,content)

        }
    }
    private fun trackScreen(){
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
            param(FirebaseAnalytics.Param.SCREEN_NAME,"Activity_main")
            param(FirebaseAnalytics.Param.SCREEN_CLASS,"MainActivity")
        }
    }
}