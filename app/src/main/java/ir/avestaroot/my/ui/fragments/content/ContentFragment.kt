package ir.avestaroot.my.ui.fragments.content

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.avestaroot.my.R
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.databinding.FragmentContentBinding
import ir.avestaroot.my.ui.adapters.ContentRecyclerAdapter
import ir.avestaroot.my.ui.activities.main.MainViewModel
import ir.avestaroot.my.util.mToast


class ContentFragment : Fragment() {

    private lateinit var binding: FragmentContentBinding
    private lateinit var mainViewModel: MainViewModel
    private val contentRecyclerAdapter by lazy { ContentRecyclerAdapter() }
    private val readExternalStorageLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
        ActivityResultCallback {
            if (it) {
                mainViewModel.loadContents()
            } else {
                mToast(R.string.permission_denied)
            }
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(inflater, container, false)
        contentRecyclerAdapter.submitList(listOf(
            ContentItem(title = "Test1"),
                ContentItem(title = "Test2"),
                ContentItem(title = "Test3"),
                ContentItem(title = "Test4"),
                ContentItem(title = "Test5"),
                ContentItem(title = "Test6"),
                ContentItem(title = "Test8"),
                ContentItem(title = "Test9"),
                ContentItem(title = "Test10"),
                ContentItem(title = "Test11"),
                ContentItem(title = "Test12"),
                ContentItem(title = "Test13")
        ))


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        initContentRecyclerView()

        setTopBarValues()

        readExternalStorageLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

        //listeners and observers
        mainViewModel.contentsList.observe(viewLifecycleOwner, contentsListChanged)
    }

    private val contentsListChanged = Observer<ArrayList<ContentItem>> {contents ->
        contentRecyclerAdapter.submitList(contents)
    }

    private fun setTopBarValues() {
        binding.topbar.title = mainViewModel.currentFragment.value?.name ?: ""
        binding.topbar.size = "This is a test size"
    }

    private fun initContentRecyclerView() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = contentRecyclerAdapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}