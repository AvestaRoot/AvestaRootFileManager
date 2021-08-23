package ir.avestaroot.my.ui.fragments.content

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.avestaroot.my.R
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.data.model.LoadingState
import ir.avestaroot.my.data.model.event.Event
import ir.avestaroot.my.data.model.event.EventObserver
import ir.avestaroot.my.databinding.FragmentContentBinding
import ir.avestaroot.my.ui.adapters.ContentRecyclerAdapter
import ir.avestaroot.my.ui.activities.main.MainViewModel
import ir.avestaroot.my.util.beGone
import ir.avestaroot.my.util.beVisible
import ir.avestaroot.my.util.mToast


class ContentFragment : Fragment() {

    private lateinit var binding: FragmentContentBinding
    private lateinit var mainViewModel: MainViewModel
    private val contentRecyclerAdapter by lazy { ContentRecyclerAdapter() }
    private val readExternalStorageLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
        ActivityResultCallback {
            if (it) {
                mainViewModel.onLoadingChanged(LoadingState.Started)
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
        mainViewModel.loadingState.observe(viewLifecycleOwner, loadingStateChanged)
    }

    private val loadingStateChanged = EventObserver<LoadingState> {state ->
        when(state) {
            LoadingState.Started -> binding.progressbar.beVisible()
            LoadingState.Finished -> binding.progressbar.beGone()
        }
    }

    private val contentsListChanged = EventObserver<ArrayList<ContentItem>> { contents ->
        mainViewModel.onLoadingChanged(LoadingState.Finished)
        contentRecyclerAdapter.submitList(contents)
        Log.d("myapplog", "changed")
    }

    private fun setTopBarValues() {
        binding.topbar.title = mainViewModel.currentFragment.value ?: ""
        binding.topbar.size = "This is a test size"
    }

    private fun initContentRecyclerView() {
        binding.recyclerview.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = contentRecyclerAdapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}