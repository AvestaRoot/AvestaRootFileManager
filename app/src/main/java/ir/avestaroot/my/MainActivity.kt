package ir.avestaroot.my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.avestaroot.my.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragmentNavigator by lazy { FragmentNavigator(supportFragmentManager, R.id.frag) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
 
    }
    private fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentNavigator.navigateTo(Fragments.Main)
    }

}