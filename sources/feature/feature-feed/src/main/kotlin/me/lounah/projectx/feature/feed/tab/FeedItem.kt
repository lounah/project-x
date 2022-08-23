package me.lounah.projectx.feature.feed.tab

import android.view.View
import me.lounah.projectx.feature.feed.R
import me.lounah.projectx.feature.feed.databinding.ItemFeedBinding
import ru.tinkoff.mobile.tech.ti_recycler.base.BaseViewHolder
import ru.tinkoff.mobile.tech.ti_recycler.base.ViewTyped

class FeedItem(
    override val uid: String = "FEED_ITEM",
    override val viewType: Int = R.layout.item_feed
) : ViewTyped

internal class FeedItemViewHolder(view: View) : BaseViewHolder<FeedItem>(view) {

    private val binding: ItemFeedBinding = ItemFeedBinding.bind(view)

    override fun bind(item: FeedItem) {

    }
}