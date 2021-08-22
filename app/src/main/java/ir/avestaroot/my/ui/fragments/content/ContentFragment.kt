package ir.avestaroot.my.ui.fragments.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ir.avestaroot.my.databinding.FragmentContentBinding
import ir.avestaroot.my.ui.adapters.ContentRecyclerAdapter
import ir.avestaroot.my.ui.activities.main.MainViewModel


class ContentFragment : Fragment() {

    private lateinit var binding: FragmentContentBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private val contentRecyclerAdapter by lazy { ContentRecyclerAdapter(mainViewModel.getContentsList()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(inflater, container, false)

        initContentRecyclerView()

        return binding.root
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