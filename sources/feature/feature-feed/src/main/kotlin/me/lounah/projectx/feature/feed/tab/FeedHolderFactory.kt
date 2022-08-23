package me.lounah.projectx.feature.feed.tab

import android.view.View
import me.lounah.projectx.feature.feed.R
import ru.tinkoff.mobile.tech.ti_recycler.base.BaseViewHolder
import ru.tinkoff.mobile.tech.ti_recycler.base.HolderFactory
import ru.tinkoff.mobile.tech.ti_recycler_rx2.base.RxHolderFactory

class FeedHolderFactory : RxHolderFactory() {

    override fun createViewHolder(view: View, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            R.layout.item_feed -> FeedItemViewHolder(view)
            else -> error("Unsupported viewType `$viewType`.")
        }
    }
}