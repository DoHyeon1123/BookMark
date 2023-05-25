package com.bookmark.presentation.features.home.view

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.profile.Comment
import com.bookmark.presentation.base.BaseFragment
import com.bookmark.presentation.databinding.FragmentCommentBinding
import com.bookmark.presentation.databinding.FragmentHomeBinding
import com.bookmark.presentation.features.comment.adapter.CommentAdapter
import com.bookmark.presentation.features.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), HomeAdapter.CallBack {
    override val viewModel: HomeViewModel by viewModels()
    private val adapter = HomeAdapter(this)

    //private val args: CommentFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()
        //viewModel.getComment(args.bookId)
        binding.rvBookList.adapter = adapter
        binding.rvBookList.layoutManager =
            LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun observerViewModel() {
        binding.btnSearch.setOnClickListener{
            //viewModel.addComment(args.bookId)
        }

        /*with(viewModel){
            commentList.observe(
                viewLifecycleOwner,
                Observer<List<Comment>> {
                    Log.e("LibraryFragment", it.toString())
                    adapter.submitList(it)
                }
            )
        }*/
    }
    override fun deleteComment(info: Book) {
        TODO("Not yet implemented")
    }
}