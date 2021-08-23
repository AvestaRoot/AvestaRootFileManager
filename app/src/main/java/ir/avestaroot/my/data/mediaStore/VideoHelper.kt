package ir.avestaroot.my.data.mediaStore

import android.content.ContentResolver
import android.database.Cursor
import android.media.ThumbnailUtils
import android.net.Uri
import android.os.Build
import android.util.Size
import ir.avestaroot.my.data.mediaStore.MSConstants.DATA
import ir.avestaroot.my.data.mediaStore.MSConstants.DATE_ADDED
import ir.avestaroot.my.data.mediaStore.MSConstants.DISPLAY_NAME
import ir.avestaroot.my.data.mediaStore.MSConstants.URI
import ir.avestaroot.my.data.mediaStore.MSConstants.ID
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.data.mediaStore.MSConstants.MIME_TYPE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class VideoHelper(resolver: ContentResolver) : MediaStore(resolver) {

    override fun getSelection() = arrayOf(
        MIME_TYPE to getMimeTypeByExtension("mp4"),
        MIME_TYPE to getMimeTypeByExtension("mkv"),
    )

    override fun getProjection() = arrayOf(
        DISPLAY_NAME,
        ID
    )

    override fun getUri() = URI

    override fun getSortOrder() = DATE_ADDED

    override fun getItem(cursor: Cursor): ContentItem? {
        return ContentItem(
            id = cursor.getLong(cursor.getColumnIndex(ID)),
            title = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME)) ?: return null
        )
    }
}