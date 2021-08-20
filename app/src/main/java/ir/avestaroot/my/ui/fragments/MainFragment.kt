package ir.avestaroot.my.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.FragmentMainBinding
import ir.avestaroot.my.model.StorageItem
import ir.avestaroot.my.ui.adapters.MainActivityRecyclerAdapter
import ir.avestaroot.my.ui.custom.SpaceItemDecoration
import ir.avestaroot.my.util.FragmentNavigator

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mediasRecyclerAdapter by lazy { MainActivityRecyclerAdapter(Medias.values().toList()) }
    private val storagesRecyclerAdapter by lazy { MainActivityRecyclerAdapter(listOf(
        StorageItem(R.drawable.icons8_iphone_96, "Title", "State"),
        StorageItem(R.drawable.sd_card, "Title2", "State2")
    )) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        initMediasRecyclerView()
        initStorageRecyclerView()

        return binding.root
    }

    private fun initMediasRecyclerView() {
        binding.mediasRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
            addItemDecoration(SpaceItemDecoration(16))
            adapter = mediasRecyclerAdapter
        }
    }

    private fun initStorageRecyclerView() {
        binding.storagesRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = storagesRecyclerAdapter
        }
    }

    enum class Medias(val nameRes: Int, val iconRes: Int) {
        Images(R.string.images, R.drawable.image),
        Videos(R.string.videos, R.drawable.icons8_video_96),
        Audio(R.string.audio, R.drawable.audio),
        Documents(R.string.documents, R.drawable.document),
        Downloads(R.string.downloads, R.drawable.download),
        Installations(R.string.installationsFiles, R.drawable.installation_files),
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}