package net.kboy.kinniku_kt.ui.schedule

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.data.Schedule

class ScheduleAdapter(
    private val mValues: Array<Schedule>
) : RecyclerView.Adapter<ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = mValues[position]
        holder.time.text = schedule.date.toString()
        holder.title.text = schedule.title
        holder.detail.text = schedule.detail
    }

    override fun getItemCount(): Int = mValues.size
}