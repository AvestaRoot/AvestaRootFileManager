package ir.avestaroot.my

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.lucasr.twowayview.TwoWayView

class CvLocation(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private var name_fl_tv: TextView
    private var listView: TwoWayView
    private var listViews: AutoCompleteTextView
    private var relative_items: RelativeLayout
    private var selectitme: MutableList<String> = ArrayList()
    private var allItems: MutableList<String> = ArrayList()

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.cv_location, this, true)
        name_fl_tv = view.findViewById(R.id.name_fl_tv)
        listView = view.findViewById(R.id.rec_item_cv_location)
        relative_items = view.findViewById(R.id.relative_items)

        relative_items.setOnClickListener {
            val selectString = name_fl_tv.text.trim().toString()
            when {
                selectString.isEmpty() -> Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT)
                    .show()
                selectString.contains(selectString) -> Toast.makeText(
                    getContext(),
                    "good",
                    Toast.LENGTH_SHORT
                ).show()
                else -> {
                    selectitme.add(0, selectString)
                    refreshData()
                }
            }

        }

    }
    fun allData(data : MutableList<String>){
        allItems = data
        listViews.setA
    }
    fun refreshData(){
        listView.adapter = ItemAdapter(context,R.layout.cv_location,selectitme)
        setListViewOnChildren(listView)
    }
    private fun setListViewOnChildren(listView : TwoWayView){
        val listAdapter = listView.adapter ?: return
        var totalHeight = listView.paddingTop + listView.paddingBottom
        for (i in 0 until listAdapter.count){
            val listItem = listAdapter.getView(i,null,listView)
            (listView as? ViewGroup)?.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            listItem.measure(0,0)
            totalHeight += listItem.measuredHeight
        }
        val params = listView.layoutParams
        params.height = totalHeight  +(listAdapter.count -1)
        listView.layoutParams = params
    }
    inner class ItemAdapter(context: Context?, var resource: Int, var objects: MutableList<String>?) :
        ArrayAdapter<String>(context!!, resource, objects!!) {
        private val inflater: LayoutInflater = LayoutInflater.from(context)

        override fun getCount(): Int {
            return objects!!.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val v = inflater.inflate(resource,parent,false)

            val name = v.findViewById<TextView>(R.id.folder_name_tv)
            name.text= objects!!.get(position)
            return v
        }
    }
}