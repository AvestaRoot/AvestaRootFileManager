package ir.avestaroot.my.data.model

import android.graphics.Bitmap

class ContentItem(
    val title: String = "",
    val uri: String = "",
    val size: Float = 0f,
    val thumbnail: Bitmap? = null
) {

    override fun equals(other: Any?): Boolean {
        val other = other as ContentItem

        return this.title == other.title &&
                this.uri == other.uri &&
                this.size == other.size
    }

}