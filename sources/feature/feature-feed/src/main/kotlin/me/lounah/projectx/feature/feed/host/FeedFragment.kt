package me.lounah.projectx.feature.feed.host

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import me.lounah.projectx.feature.feed.R
import me.lounah.projectx.feature.feed.databinding.FragmentFeedBinding
import me.lounah.projectx.feature.feed.host.FeedTabsAdapter.Companion.POSITION_HOT
import me.lounah.projectx.feature.feed.host.FeedTabsAdapter.Companion.POSITION_LATEST
import me.lounah.projectx.feature.feed.host.FeedTabsAdapter.Companion.POSITION_PERSONAL
import me.lounah.projectx.feature.feed.tab.FeedMode

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private val binding: FragmentFeedBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        binding.pages.adapter = FeedTabsAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        TabLayoutMediator(binding.tabs, binding.pages) { tab, position ->
            when (position) {
                POSITION_HOT -> FeedMode.HOT.description
                POSITION_LATEST -> FeedMode.LATEST.description
                POSITION_PERSONAL -> FeedMode.PERSONAL.description
                else -> error("Unsupported position `$position`.")
            }.also(tab::setText)
        }.attach()
    }
}
