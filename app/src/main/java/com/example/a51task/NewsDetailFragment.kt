package com.example.a51task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.a51task.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {
    private lateinit var binding: FragmentNewsDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)

        val news = arguments?.getParcelable<News>("news")
        news?.let {
            Glide.with(this).load(it.imageUrl).into(binding.detailImage)
            binding.detailDesc.text = it.description
            binding.relatedRecycler.layoutManager = LinearLayoutManager(requireContext())
            binding.relatedRecycler.adapter = NewsAdapter(it.related) {}
        }

        return binding.root
    }

    companion object {
        fun newInstance(news: News) = NewsDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("news", news)
            }
        }
    }
}
