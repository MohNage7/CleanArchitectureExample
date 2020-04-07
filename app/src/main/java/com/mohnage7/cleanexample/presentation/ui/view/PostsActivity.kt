package com.mohnage7.cleanexample.presentation.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohnage7.cleanexample.R
import com.mohnage7.cleanexample.framework.extensions.makeInvisible
import com.mohnage7.cleanexample.framework.extensions.makeVisible
import com.mohnage7.cleanexample.presentation.ui.viewmodel.PostsViewModel
import com.mohnage7.domain.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_posts.*
import kotlinx.android.synthetic.main.layout_empty_view_default.*
import org.koin.android.viewmodel.ext.android.viewModel

class PostsActivity : AppCompatActivity() {

    private val viewModel: PostsViewModel by viewModel()
    private lateinit var disposable: Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)


        disposable = viewModel.observePostsChanges()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::showPostsList, this::handleError)
    }

    private fun showPostsList(postsList: List<Post>) {
        if (postsList.isNotEmpty()) {
            showContent()
            setupAdapter(postsList)
        } else {
            showEmptyView()
        }
    }

    private fun handleError(error: Throwable) {
        showEmptyView()
    }

    private fun setupAdapter(postsList: List<Post>) {
        val postsAdapter =
            PostsAdapter(postsList)
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.setHasFixedSize(true)
        postsRecyclerView.adapter = postsAdapter
    }


    private fun showContent() {
        postsRecyclerView?.makeVisible()
        emptyLayout.makeInvisible()
    }

    private fun showEmptyView() {
        emptyLayout.makeVisible()
        postsRecyclerView.makeInvisible()
    }


    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
