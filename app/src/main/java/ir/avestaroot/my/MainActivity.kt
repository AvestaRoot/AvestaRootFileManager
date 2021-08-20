package ir.avestaroot.my

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import ir.avestaroot.my.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragmentNavigator by lazy { FragmentNavigator(supportFragmentManager, R.id.frag) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initAppbar()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            android.R.id.home -> {

            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun initAppbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    private fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentNavigator.navigateTo(Fragments.Main)
    }
}