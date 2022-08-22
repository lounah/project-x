package me.lounah.projectx.feature.feed.host

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import me.lounah.projectx.feature.feed.R
import me.lounah.projectx.feature.feed.databinding.FragmentFeedBinding
import me.lounah.projectx.feature.feed.tab.FeedMode
import me.lounah.projectx.feature.feed.tab.FeedTabFragment

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private val binding: FragmentFeedBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pages.adapter = FeedTabsAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        TabLayoutMediator(binding.tabs, binding.pages) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }
}

class FeedTabsAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FeedTabFragment.create(FeedMode.HOT)
            1 -> FeedTabFragment.create(FeedMode.LATEST)
            2 -> FeedTabFragment.create(FeedMode.PERSONAL)
            else -> error("Unsupported fragment position `$position`.")
        }
    }
}
