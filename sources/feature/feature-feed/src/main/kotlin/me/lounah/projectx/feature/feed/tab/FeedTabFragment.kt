package me.lounah.projectx.feature.feed.tab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import me.lounah.projectx.feature.feed.R
import me.lounah.projectx.feature.feed.databinding.FragmentFeedTabBinding

internal class FeedTabFragment : Fragment(R.layout.fragment_feed_tab) {

    private val binding: FragmentFeedTabBinding by viewBinding()

    private lateinit var mode: FeedMode

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mode = arguments?.getSerializable(ARG_MODE) as FeedMode
        binding.title.text = mode.name
    }

    companion object {

        private const val ARG_MODE = "mode"

        fun create(mode: FeedMode) = FeedTabFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ARG_MODE, mode)
            }
        }
    }
}

enum class FeedMode {
    HOT, LATEST, PERSONAL
}