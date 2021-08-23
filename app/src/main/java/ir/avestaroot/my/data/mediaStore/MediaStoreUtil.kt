package ir.avestaroot.my.data.mediaStore

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.media.ThumbnailUtils
import android.os.Build
import android.os.CancellationSignal
import android.provider.MediaStore
import android.util.Size
import android.webkit.MimeTypeMap
import ir.avestaroot.my.data.model.ContentItem
import java.io.File

/**
 * this object holds the constants used in the classes of "mediaStore" pacakge*/
object MSConstants {

    val URI = MediaStore.Files.getContentUri("external")
    val ID = MediaStore.Files.FileColumns._ID
    val DISPLAY_NAME = MediaStore.Files.FileColumns.DISPLAY_NAME
    val DATE_ADDED = MediaStore.Files.FileColumns.DATE_ADDED

    @Deprecated(message = "")
    val DATA = MediaStore.Files.FileColumns.DATA
    val MIME_TYPE = MediaStore.Files.FileColumns.MIME_TYPE
}

fun getMimeTypeByExtension(extension: String) =
    MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)

fun getFileSizeByUri(uri: String): Float {
    val file = File(uri)
    return (file.length() / 1024f)
}

interface MediaStoreInterface {
    fun getContents(): ArrayList<ContentItem>
}