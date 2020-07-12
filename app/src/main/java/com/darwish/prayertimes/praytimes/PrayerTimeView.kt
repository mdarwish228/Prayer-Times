package com.darwish.prayertimes.praytimes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.darwish.prayertimes.R
import kotlinx.android.synthetic.main.prayer_time.view.*


class PrayerTimeView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    init {
        inflate(context, R.layout.prayer_time, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.PrayerTimeView)

        prayer_time_label.text = attributes.getString(R.styleable.PrayerTimeView_prayer_time_label)
        prayer_time_value.text = attributes.getString(R.styleable.PrayerTimeView_prayer_time_value)

        attributes.recycle()
    }
}
