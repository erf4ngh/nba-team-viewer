package com.example.nbatv.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.R
import kotlinx.android.synthetic.main.teams_fragment.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel



class TeamListFragment : Fragment() {

    private val viewModel: TeamViewModel by viewModel()
    private val adapter = TeamListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onStart() {
        super.onStart()
        recyclerViewTeams.layoutManager = LinearLayoutManager(activity)
        recyclerViewTeams.adapter = adapter
        lifecycleScope.launch {
            viewModel.getAllTeams().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }
}