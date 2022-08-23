package me.lounah.projectx.feature.feed.tab

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import me.lounah.projectx.feature.feed.R
import me.lounah.projectx.feature.feed.databinding.FragmentFeedTabBinding
import ru.tinkoff.mobile.tech.ti_recycler.base.ViewTyped
import ru.tinkoff.mobile.tech.ti_recycler_rx2.TiRecyclerRx

internal class FeedTabFragment : Fragment(R.layout.fragment_feed_tab) {

    private val binding: FragmentFeedTabBinding by viewBinding()

    private lateinit var mode: FeedMode

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mode = arguments?.getSerializable(ARG_MODE) as FeedMode
        val recycler = TiRecyclerRx<ViewTyped>(binding.recycler, FeedHolderFactory()) {
            layoutManager = LinearLayoutManager(requireContext())
        }
        recycler.setItems((0..20).map { FeedItem() })
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

enum class FeedMode(@StringRes val description: Int) {
    HOT(R.string.feed_tab_hot),
    LATEST(R.string.feed_tab_latest),
    PERSONAL(R.string.feed_tab_personal)
}