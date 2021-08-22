package ir.avestaroot.my.data.model

class ContentItem(
    val title: String = "",
    val data: String = "",
    val dateAdded: String = "",
    val size_count: String = ""
) {

    override fun equals(other: Any?): Boolean {
        val other = other as ContentItem

        return this.dateAdded == other.dateAdded &&
                this.title == other.title &&
                this.data == other.data &&
                this.size_count == other.size_count
    }

}