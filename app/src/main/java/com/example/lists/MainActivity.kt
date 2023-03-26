package com.example.lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_course.view.*

class MainActivity : AppCompatActivity() {
    private val courses = listOf<Course>(
        Course("Basics & Coding - Level 0", 15, 99),
        Course("Coding & Foundation DSA - Level 1", 15, 99),
        Course("Interview DSA & Mocks - Level 2", 15, 99),
        Course("Competitive Coders - Advanced", 15, 99),
        Course("Android", 15, 99),
        Course("Frontend Development - React.js & Next.js", 15, 99),
        Course("Artificial Intelligence & Machine Learning", 15, 99),
        Course("Game Development", 15, 99),
        Course("Video Editing", 15, 99),
        Course("Native Application Development", 15, 99),
        Course("IOS Mobile App Development", 15, 99),
        Course("Devops", 15, 99),
        Course("Cloud Development", 15, 99),
        Course("Career Ready - Backend - Devops -Cloud", 15, 99),
        Course("Career Ready - Frontend - Devops -Cloud", 15, 99),
        Course("Career Ready - Mobile - Native - Devops -Cloud", 15, 99)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvCourses.adapter = object : BaseAdapter() {
            override fun getCount() = courses.size

            override fun getItem(position: Int): Course = courses[position]

            override fun getItemId(position: Int): Long = getItem(position).hashCode().toLong()

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val itemView = layoutInflater.inflate(R.layout.list_item_course, parent, false)
                val course = getItem(position)
                itemView.tvCourseName.text = course.name
                itemView.tvCourseDetails.text = "Days ${course.days} | Fees: INR ${course.fees}"
                return itemView
            }

        }

//        lvCourses.adapter = ArrayAdapter<Course>(
//            this,
//            android.R.layout.simple_expandable_list_item_1,
//            android.R.id.text1,
//            courses
//        )

        lvCourses.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Clicked on ${courses[position].name}", Toast.LENGTH_SHORT)
                .show()
        }
    }
}