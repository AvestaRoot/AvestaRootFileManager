package ir.avestaroot.my

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ir.avestaroot.my.databinding.FragmentStorageBinding


class ContentFragment : Fragment() {
    private lateinit var binding: FragmentStorageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStorageBinding.inflate(inflater, container, false)
        val recyclerview = binding.recyclerview

        recyclerview.layoutManager = LinearLayoutManager(activity)

        val data = ArrayList<ItemsViewModel>()


        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))
        data.add(ItemsViewModel("Android", "19 Agu 1:30 ", "1 items"))


        val adapter = ContentAdapter(data)

        recyclerview.adapter = adapter

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}