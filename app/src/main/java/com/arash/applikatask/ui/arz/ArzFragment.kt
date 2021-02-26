package com.arash.applikatask.ui.arz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arash.applikatask.databinding.ArzFragmentBinding
import com.arash.applikatask.localdb.PriceRepository
import com.arash.applikatask.utils.bases.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArzFragment : BaseFragment() {

    private val viewModel : ArzViewModel by viewModel()
    lateinit var binding : ArzFragmentBinding

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
            binding.recyclerView.adapter = ArzAdapter().apply { submitList(it) }
        })

    }


}