package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.core.BaseView
import com.example.lesson.entity.Lesson

/**
 * Created by QUYONG on 12/27/20
 */
class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter>, Toolbar.OnMenuItemClickListener {

    override fun getPresenter(): LessonPresenter = LessonPresenter(this)

    private val lessonAdapter: LessonAdapter = LessonAdapter()

    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        val toolbar: Toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_lesson);
        toolbar.setOnMenuItemClickListener(this);

        val recyclerView: RecyclerView = findViewById(R.id.list);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = lessonAdapter;
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        refreshLayout = findViewById(R.id.swipe_refresh_layout)
        refreshLayout.setOnRefreshListener { getPresenter().fetchData() }
        refreshLayout.isRefreshing = true;
        getPresenter().fetchData()
    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons);
        refreshLayout.isRefreshing = false;
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        getPresenter().showPlayback()
        return false;
    }
}