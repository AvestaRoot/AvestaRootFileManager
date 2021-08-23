package ir.avestaroot.my.ui.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.ActivityMainBinding
import ir.avestaroot.my.ui.activities.search.SearchActivity
import ir.avestaroot.my.util.FragmentNavigator
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragmentNavigator by lazy { FragmentNavigator(supportFragmentManager, R.id.frag) }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        //listeners and observers
        viewModel.currentFragment.observe(this, currentFragmentChanged)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack()
    }

    private val currentFragmentChanged = Observer<String> {

//        supportFragmentManager.popBackStack(it, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        var found = false
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            val name = supportFragmentManager.getBackStackEntryAt(i).name
            Log.d("myapplog", "Name : $name")

            if (name == it) {
                found = true
                break
            }
        }
        if (found)
            Log.d("myapplog", "yes")
        else
            Log.d("myapplog", "no")

        fragmentNavigator.navigateTo(FragmentNavigator.Fragments.valueOf(it))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
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