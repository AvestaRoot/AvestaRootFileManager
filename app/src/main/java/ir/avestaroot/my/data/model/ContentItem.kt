package ir.avestaroot.my.data.model

import android.graphics.Bitmap

class ContentItem(

    val id: Long,
    val title: String = "",
) {

    override fun equals(other: Any?): Boolean {
        val other = other as ContentItem

        return this.title == other.title &&
                this.id == other.id
    }

}