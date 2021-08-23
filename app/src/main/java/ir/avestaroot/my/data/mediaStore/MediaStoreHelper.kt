package ir.avestaroot.my.data.mediaStore

import android.content.ContentResolver
import ir.avestaroot.my.data.mediaStore.MSConstants.DATA
import ir.avestaroot.my.data.mediaStore.MSConstants.DATE_ADDED
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Audio
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Downloads
import ir.avestaroot.my.util.FragmentNavigator.Fragments.InstallationsFiles
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Documents
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Videos
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Images
import ir.avestaroot.my.data.mediaStore.MSConstants.ID
import ir.avestaroot.my.util.FragmentNavigator
import java.util.*
import kotlin.collections.ArrayList

class MediaStoreHelper(private val resolver: ContentResolver) {

    suspend fun getUriFromId(id: Long): String? {
        val cursor = resolver.query(
            MSConstants.URI,
            arrayOf(DATA),
            "$ID = ?",
            arrayOf("$id"),
            "$DATE_ADDED DESC"
        )

        return if (cursor?.moveToNext() ?: return null)
            cursor.getString(cursor.getColumnIndex(DATA))
        else
            null
    }

    fun getContents(dataType: FragmentNavigator.Fragments) = when(dataType) {

        Audio -> AudioHelper(resolver).load()

        Videos -> VideoHelper(resolver).load()

        //this branch will be never used
        else -> ArrayList()
    }
}