package ir.avestaroot.my.data.mediaStore

import android.content.ContentResolver
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Audio
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Downloads
import ir.avestaroot.my.util.FragmentNavigator.Fragments.InstallationsFiles
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Documents
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Videos
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Images
import ir.avestaroot.my.util.FragmentNavigator

class MediaStoreHelper(private val resolver: ContentResolver) {

    fun getContents(dataType: FragmentNavigator.Fragments) = when(dataType) {

        Audio -> AudioHelper(resolver).load()

        //this branch will be never used
        else -> ArrayList()
    }
}