package com.example.mvi_rx_kotlin_androidversionsapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvi_rx_kotlin_androidversionsapi.adapter.AndroidVersionsAdapter
import com.example.mvi_rx_kotlin_androidversionsapi.api.AndroidVersions
import com.example.mvi_rx_kotlin_androidversionsapi.mvi.DisplayInputEvent
import com.example.mvi_rx_kotlin_androidversionsapi.mvi.DisplayScreen
import com.example.mvi_rx_kotlin_androidversionsapi.mvi.DisplayViewModel
import com.example.mvi_rx_kotlin_androidversionsapi.repo.AndroidVersionsRepo
import com.example.mvi_rx_kotlin_androidversionsapi.repo.IAndroidVersionsRepo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), DisplayScreen.UserInterface, AndroidVersionsAdapter.Listener {

    private val inputEvents = PublishSubject.create<DisplayInputEvent>()

    private val repo: IAndroidVersionsRepo = AndroidVersionsRepo()

    private val screen = DisplayScreen(repo)

    private lateinit var androidVersions: ArrayList<AndroidVersions>

    private lateinit var versionsAdapter: AndroidVersionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen.attach(this)

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        inputEvents.onNext(DisplayInputEvent.Show)
    }

    private fun initRecyclerView() {
        recycler_view.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recycler_view.layoutManager = layoutManager
    }

    private fun handleResponse(androidList: List<AndroidVersions>) {
        androidVersions = ArrayList(androidList)
        versionsAdapter = AndroidVersionsAdapter(androidVersions, this)
        recycler_view.adapter = versionsAdapter
    }

    private fun handleError(error: Throwable) {
        Toast.makeText(this, "Error " + error.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun render(viewModel: DisplayViewModel) {
        when (viewModel) {
            is DisplayViewModel.Displayer.Display -> {
                Log.i("mytest: ", "show")
                handleResponse(viewModel.androidVersions)
            }
        }
    }

    override fun inputEvents(): Observable<DisplayInputEvent> =
        Observable.mergeArray(
            inputEvents,
        )

    override fun onDestroy() {
        screen.terminate()
        screen.detach()
        super.onDestroy()
    }

    override fun onItemClick(androidVersion: AndroidVersions) {
        Toast.makeText(this, "You clicked: ${androidVersion.name}", Toast.LENGTH_SHORT).show()
    }
}