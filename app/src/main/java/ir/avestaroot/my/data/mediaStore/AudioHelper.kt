package ir.avestaroot.my.data.mediaStore

import android.content.ContentResolver
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import ir.avestaroot.my.data.mediaStore.MSConstants.DATA
import ir.avestaroot.my.data.mediaStore.MSConstants.DATE_ADDED
import ir.avestaroot.my.data.mediaStore.MSConstants.DISPLAY_NAME
import ir.avestaroot.my.data.mediaStore.MSConstants.ID
import ir.avestaroot.my.data.mediaStore.MSConstants.MIME_TYPE
import ir.avestaroot.my.data.mediaStore.MSConstants.URI
import ir.avestaroot.my.data.model.ContentItem

class AudioHelper(private val resolver: ContentResolver) : MediaStore(resolver) {

    override fun getSelection() = arrayOf(
        MIME_TYPE to getMimeTypeByExtension("mp3")
    )

    override fun getProjection() = arrayOf(
        ID,
        DISPLAY_NAME,
    )

    override fun getUri() = URI

    override fun getSortOrder() = DATE_ADDED

    override fun getItem(cursor: Cursor): ContentItem? {
        return ContentItem(
            id = cursor.getLong(cursor.getColumnIndex(ID)),
            title = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME)) ?: return null
        )
    }

    companion object {

        fun getAudioThumbnailByUri(uri: String): Bitmap? {
            val retriever = MediaMetadataRetriever()
            var byteArray: ByteArray? = null

            retriever.setDataSource(uri)
            byteArray = retriever.embeddedPicture

            return if (byteArray != null)
                BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size, BitmapFactory.Options())
            else
                null
        }

    }
}