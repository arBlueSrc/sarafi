package com.arash.applikatask.ui.car

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.arash.applikatask.databinding.CarFragmentBinding
import com.arash.applikatask.localdb.PriceRepository
import com.arash.applikatask.ui.arz.ArzAdapter
import com.arash.applikatask.utils.bases.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CarFragment : BaseFragment() {

    private val viewModel : CarViewModel by viewModel()
    lateinit var binding : CarFragmentBinding
    lateinit var carAdapter: CarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CarFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PriceRepository.getFilterPrice(requireContext(),"car")?.observe(viewLifecycleOwner,{
            viewModel.updateList(it)
            carAdapter = CarAdapter(it)
            binding.rv.adapter = carAdapter
        })

        onSearchView()
    }

    private fun onSearchView() {

        binding.searchView.setOnSearchClickListener {
            binding.txtTitleCar.visibility = View.GONE
        }

        binding.searchView.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                binding.txtTitleCar.visibility = View.VISIBLE
                return false
            }
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                carAdapter.getFilter()?.filter(newText);

                return false
            }

        })
    }

}