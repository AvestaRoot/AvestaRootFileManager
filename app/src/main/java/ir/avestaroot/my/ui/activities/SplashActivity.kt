package ir.avestaroot.my.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import ir.avestaroot.my.R
import ir.avestaroot.my.ui.activities.main.MainActivity

class SplashActivity : AppCompatActivity() {

//    private val interval = 2000L
    private val interval = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, interval)
    }
}