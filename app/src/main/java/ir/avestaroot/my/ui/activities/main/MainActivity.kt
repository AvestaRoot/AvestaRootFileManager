package ir.avestaroot.my.ui.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.ActivityMainBinding
import ir.avestaroot.my.ui.activities.search.SearchActivity
import ir.avestaroot.my.util.FragmentNavigator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragmentNavigator by lazy { FragmentNavigator(supportFragmentManager, R.id.frag) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            android.R.id.home -> {

            }

            R.id.search -> {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    private fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentNavigator.navigateTo(FragmentNavigator.Fragments.Main)
        setSupportActionBar(binding.toolbar)
    }
}