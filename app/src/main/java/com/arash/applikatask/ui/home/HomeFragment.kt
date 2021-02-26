package com.arash.applikatask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arash.applikatask.databinding.HomeFragmentBinding
import com.arash.applikatask.localdb.PriceRepository
import com.arash.applikatask.model.localdbmodel.DbModel
import com.arash.applikatask.ui.arz.ArzAdapter
import com.arash.applikatask.utils.bases.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {


    private val viewModel: HomeViewModel by viewModel()
    lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater)
        binding.data = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        PriceRepository.getFilterPrice(requireContext(), "arz")?.observe(viewLifecycleOwner, {
            binding.textView5.text =
                it.filter { filter -> filter.Name.equals("دلار") }?.get(0)?.Price.let {
                    "قیمت دلار امروز : $it تومان"
                }
        })


        viewModel.responseArz.observe(viewLifecycleOwner, {
            binding.textView5.text =
                viewModel.responseArz.value?.filter { it.name.equals("دلار") }?.get(0)?.price.let {
                    "قیمت دلار امروز : $it تومان"
                }

            for (item in it) {
                val saveItem = DbModel(
                    0,
                    item.name.toString(),
                    item.price.toString(),
                    item.change.toString(),
                    item.percent.toString(),
                    "arz"
                )

                viewModel.insertData(requireContext(), saveItem)
            }
        })

        viewModel.responseSeke.observe(viewLifecycleOwner, {

            for (item in it) {
                val saveItem = DbModel(
                    0,
                    item.name.toString(),
                    item.price.toString(),
                    item.change.toString(),
                    item.percent.toString(),
                    "seke"
                )

                viewModel.insertData(requireContext(), saveItem)
            }
        })

        viewModel.responseCar.observe(viewLifecycleOwner, {

            for (item in it.result!!) {
                val saveItem = DbModel(
                    0,
                    item.name.toString(),
                    item.moshakhasat.toString(),
                    item.karkhane.toString(),
                    item.bazar.toString(),
                    "car"
                )

                viewModel.insertData(requireContext(), saveItem)
            }
        })

        binding.button.setOnClickListener {
            viewModel.getData()
        }

    }

}