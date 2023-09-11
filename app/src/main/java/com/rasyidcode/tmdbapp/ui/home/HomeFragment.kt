package com.rasyidcode.tmdbapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.rasyidcode.tmdbapp.databinding.FragmentHomeBinding
import com.rasyidcode.tmdbapp.ui.adapters.MovieListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        setupListAdapters()

        return binding.root
    }

    private fun setupListAdapters() {
        binding.listNowPlaying.adapter = MovieListAdapter()
        binding.listPopular.adapter = MovieListAdapter()
        binding.listUpcoming.adapter = MovieListAdapter()
        binding.listTopRated.adapter = MovieListAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "HomeFragment"
    }

}