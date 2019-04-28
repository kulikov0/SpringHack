package ru.rhdv.springhackapplication.ui.developer_section.boss

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_boss.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.ui.base.view.BaseActivity
import java.text.SimpleDateFormat
import java.util.*

class BossFragment: Fragment() {

    companion object {
        const val TAG = "BossFragment"
        fun newInstance(): BossFragment = BossFragment()
    }

    private lateinit var thread: Thread


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_boss, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv_gif.loadGIFResource(requireContext(), ru.mail.mailhackathonapplication.R.drawable.boss )
        seekbar_boss.setOnTouchListener { v, event -> true }
        thread = object : Thread() {

            override fun run() {
                try {
                    while (tv_time_left != null) {
                        Thread.sleep(1000)
                            requireActivity().runOnUiThread {
                                if (tv_time_left != null) {
                                    tv_time_left.text = updateTimeLeft()
                                }
                            }
                    }
                } catch (e: Throwable) {
                    thread.destroy()
                }

            }
        }
        thread.start()
    }

    @SuppressLint("SimpleDateFormat")
    private fun updateTimeLeft(): String {
        val sprintEnd = "2019-05-10 12:56:50"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        val newDate = dateFormat.parse(sprintEnd)
        System.out.println(newDate)
        val currentDate = Date()
        var diff = newDate.time - currentDate.time

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24

        val elapsedDays = diff / daysInMilli
        diff %= daysInMilli

        val elapsedHours = diff / hoursInMilli
        diff %= hoursInMilli

        val elapsedMinutes = diff / minutesInMilli
        diff %= minutesInMilli

        val elapsedSeconds = diff / secondsInMilli

        return if (newDate.after(currentDate)) {
            "$elapsedDays дней, $elapsedHours часов, $elapsedMinutes минут"
        } else ""

    }




}