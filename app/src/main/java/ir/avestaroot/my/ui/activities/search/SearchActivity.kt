package ir.avestaroot.my.ui.activities.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ir.avestaroot.my.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        binding.searchView.setOnBackButtonClickListener {
            Toast.makeText(this, "backbutton clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun init() {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}