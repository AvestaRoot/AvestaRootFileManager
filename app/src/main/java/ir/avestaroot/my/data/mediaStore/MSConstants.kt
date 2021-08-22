package ir.avestaroot.my.data.mediaStore

import android.provider.MediaStore

/**
 * this object holds the constants used in the classes of "mediaStore" pacakge*/
object MSConstants {

    val URI = MediaStore.Files.getContentUri("external")
    val ID = MediaStore.Files.FileColumns._ID
    val DISPLAY_NAME = MediaStore.Files.FileColumns.DISPLAY_NAME
    val DATE_ADDED = MediaStore.Files.FileColumns.DATE_ADDED
    val DATA = MediaStore.Files.FileColumns.DATA

}