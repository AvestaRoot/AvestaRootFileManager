package ir.avestaroot.my

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.avestaroot.my.databinding.FragmentStorageBinding


class StorageFragment : Fragment() {
    private lateinit var binding: FragmentStorageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_storage, container, false)
        val recyclerview = v.findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(activity)

        val data = ArrayList<ItemsViewModel>()


            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))
            data.add(ItemsViewModel("Android", "19 Agu 1:30 " ,"1 items"))


        val adapter = StorageAdapter(data)

        recyclerview.adapter = adapter

        return v
    }
    companion object {

        @JvmStatic
        fun newInstance() = StorageFragment()
    }
}