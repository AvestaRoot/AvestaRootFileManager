package ir.avestaroot.my.data.mediaStore

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import ir.avestaroot.my.data.model.ContentItem
import java.lang.RuntimeException

abstract class MediaStore(private val resolver: ContentResolver) {

    abstract fun getSelection(): Array<Pair<String, String?>>
    abstract fun getProjection(): Array<String>
    abstract fun getUri(): Uri
    abstract fun getSortOrder(): String

    private fun getCursor() = resolver.query(
        getUri(),
        getProjection(),
        getSelection().joinToString(
            transform = { it.first },
            separator = " = ? OR ",
            postfix = " = ?"
        ),
        getSelection().map {
            it.second
        }.toTypedArray(),
        "${getSortOrder()} DESC"
    )

    fun load(): ArrayList<ContentItem> {
        val result = ArrayList<ContentItem>()
        val cursor = getCursor()

        while (cursor?.moveToNext() ?: throw RuntimeException("Cursor in MediaStore class is null")) {
            val item = getItem(cursor)

            result.add(item)
        }

        return result
    }

    abstract fun getItem(cursor: Cursor): ContentItem
}