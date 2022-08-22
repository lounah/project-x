package me.lounah.projectx.feature.feed.host

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.lounah.projectx.feature.feed.tab.FeedMode
import me.lounah.projectx.feature.feed.tab.FeedTabFragment

internal class FeedTabsAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = FeedMode.values().size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            POSITION_HOT -> FeedTabFragment.create(FeedMode.HOT)
            POSITION_LATEST -> FeedTabFragment.create(FeedMode.LATEST)
            POSITION_PERSONAL -> FeedTabFragment.create(FeedMode.PERSONAL)
            else -> error("Unsupported fragment position `$position`.")
        }
    }

    companion object {
        const val POSITION_HOT = 0
        const val POSITION_LATEST = 1
        const val POSITION_PERSONAL = 2
    }
}
