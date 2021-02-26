package com.arash.applikatask.ui.car

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arash.applikatask.databinding.CarFragmentBinding
import com.arash.applikatask.localdb.PriceRepository
import com.arash.applikatask.ui.arz.ArzAdapter
import com.arash.applikatask.utils.bases.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CarFragment : BaseFragment() {

    private val viewModel : CarViewModel by viewModel()
    lateinit var binding : CarFragmentBinding

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
            binding.rv.adapter = CarAdapter().apply { submitList(it) }
        })
    }

}