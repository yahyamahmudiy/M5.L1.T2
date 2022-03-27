package com.example.m5l1t2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l1t2.Adapter.MainAdapter
import com.example.m5l1t2.Model.Page

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private lateinit var pages: ArrayList<Page>
    private lateinit var tv_skip: TextView
    private lateinit var btn_start: Button
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews(){
        recyclerView = findViewById(R.id.rv_intro)
        gridLayoutManager = object : GridLayoutManager(this, 1, HORIZONTAL, false) {
            override fun canScrollHorizontally(): Boolean {
                return true
            }
        }
        recyclerView.setLayoutManager(gridLayoutManager)
        tv_skip = findViewById(R.id.tv_skip)
        btn_start = findViewById(R.id.btn_start)
        pages = ArrayList()
        addPages()
        refreshAdapter()
        controlPage()
    }

    private fun controlPage() {
        tv_skip.setOnClickListener { v: View? ->
            if (gridLayoutManager.findLastCompletelyVisibleItemPosition() < adapter.itemCount - 1) {
                gridLayoutManager.scrollToPosition(gridLayoutManager.findLastCompletelyVisibleItemPosition() + 1)
            }
        }
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == adapter.itemCount - 1) {
                    btn_start.visibility = View.VISIBLE
                } else {
                    btn_start.visibility = View.GONE
                }
            }
        })
    }

    private fun refreshAdapter() {
        adapter = MainAdapter(pages)
        recyclerView.adapter = adapter
    }

    private fun addPages() {
        pages.add(
            Page(
                R.drawable.img,
                "Say Hello to Global-Top Up",
                "Send mobile top-up to more than 500 networks in over 140 countries"
            )
        )
        pages.add(
            Page(
                R.drawable.img_2,
                "Safe, Trusted & Fully Secure",
                "Encrypted transactions mean your payments & Privacy and protected"
            )
        )
        pages.add(
            Page(
                R.drawable.img_1,
                "Easy to Use",
                "Pick a number, choose an account, send your Top-up. Simple"
            )
        )
    }

}