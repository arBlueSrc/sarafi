package com.arash.applikatask.ui.arz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.arash.applikatask.databinding.ArzFragmentBinding
import com.arash.applikatask.localdb.PriceRepository
import com.arash.applikatask.utils.bases.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArzFragment : BaseFragment() {

    private val viewModel : ArzViewModel by viewModel()
    lateinit var binding : ArzFragmentBinding
    lateinit var arzAdapter: ArzAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ArzFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PriceRepository.getFilterPrice(requireContext(),"arz")?.observe(viewLifecycleOwner,{
            viewModel.updateList(it)
            arzAdapter = ArzAdapter(it)
            binding.recyclerView.adapter = arzAdapter
        })

        onSearchView()

    }

    private fun onSearchView() {

        binding.searchView.setOnSearchClickListener {
            binding.txtTitle.visibility = View.GONE
        }

        binding.searchView.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                binding.txtTitle.visibility = View.VISIBLE
                return false
            }
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                    arzAdapter.getFilter()?.filter(newText);

                return false
            }

        })
    }



}