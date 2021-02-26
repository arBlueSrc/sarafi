package com.arash.applikatask.ui.seke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arash.applikatask.databinding.SekeFragmentBinding
import com.arash.applikatask.localdb.PriceRepository
import com.arash.applikatask.ui.arz.ArzAdapter
import com.arash.applikatask.utils.bases.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SekeFragment : BaseFragment() {

    private val viewModel: SekeViewModel by viewModel()
    lateinit var binding: SekeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SekeFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        PriceRepository.getFilterPrice(requireContext(),"seke")?.observe(viewLifecycleOwner,{
            binding.rv.adapter = ArzAdapter().apply { submitList(it) }
        })
    }


}