package com.example.nbatv.internal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nbatv.R
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class RemoteFragment : Fragment(R.layout.teams_fragment) {
    lateinit var rvTeams: RecyclerView
    lateinit var remoteViewModel: RemoteViewModel
    lateinit var adapter: RemoteTeamsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMembers()
        setUpViews(view)
        fetchTeams()
    }

    private fun fetchTeams() {
        lifecycleScope.launch {
            remoteViewModel.fetchTeams().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun initMembers() {
        remoteViewModel = defaultViewModelProviderFactory.create(RemoteViewModel::class.java)
        adapter = RemoteTeamsAdapter()
    }

    private fun setUpViews(view: View) {
        rvTeams = view.findViewById(R.id.recyclerViewTeams)
        rvTeams.adapter = adapter
    }
}