package ir.avestaroot.my.data.mediaStore

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import androidx.lifecycle.LiveData
import ir.avestaroot.my.data.mediaStore.MSConstants.MIME_TYPE
import ir.avestaroot.my.data.mediaStore.MSConstants.DISPLAY_NAME
import ir.avestaroot.my.data.mediaStore.MSConstants.DATE_ADDED
import ir.avestaroot.my.data.mediaStore.MSConstants.DATA
import ir.avestaroot.my.data.mediaStore.MSConstants.URI
import ir.avestaroot.my.data.model.ContentItem

class AudioHelper(private val resolver: ContentResolver) : MediaStore(resolver) {

    override fun getSelection() = arrayOf(
        MIME_TYPE to getMimeTypeByExtension("mp3")
    )

    override fun getProjection() = arrayOf(
        DISPLAY_NAME,
        DATE_ADDED
    )

    override fun getUri() = URI

    override fun getSortOrder() = DATE_ADDED

    override fun getItem(cursor: Cursor): ContentItem {
        val fileUri = cursor.getString(cursor.getColumnIndex(DATA))

        return ContentItem(
            title = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME)),
            uri = fileUri,
            size = getFileSizeByUri(fileUri),
            thumbnail = getThumbnailByUri(fileUri)
        )
    }
}