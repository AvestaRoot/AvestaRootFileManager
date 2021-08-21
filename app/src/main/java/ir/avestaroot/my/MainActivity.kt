package ir.avestaroot.my.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}