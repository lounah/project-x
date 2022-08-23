package me.lounah.projectx

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.view.children

class BottomNavigationBar @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attributeSet, defStyleAttr, defStyleRes) {

    var onTabSelectedListener: OnTabSelectedListener? = null
    var selectedTab: Int = -1

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_bottom_navigation, this, true)
        setBackgroundResource(android.R.color.white)
        selectTab(0)
        children.forEachIndexed { index, view ->
            view.setOnClickListener { selectTab(index) }
        }
    }

    private fun selectTab(position: Int) {
        if (selectedTab != position) {
            getChildAt(selectedTab)?.isSelected = false
            getChildAt(position)?.isSelected = true
            selectedTab = position
            onTabSelectedListener?.onTabSelected(position)
        }
    }

    fun interface OnTabSelectedListener {

        fun onTabSelected(position: Int)
    }
}