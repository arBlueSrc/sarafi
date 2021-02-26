package com.arash.applikatask.ui.info

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.arash.applikatask.databinding.FragmentInfoBinding
import com.arash.applikatask.utils.bases.BaseFragment

class InfoFragment : BaseFragment() {

    lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPress()
        onBackShape()

        onInstagramClick()

        onLinkedinClick()

    }

    private fun onBackShape() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun onLinkedinClick() {
        binding.btnLinkedin.setOnClickListener {
            onLinkedin()
        }
    }

    private fun onLinkedin() {
        val uri: Uri = Uri.parse("https://ir.linkedin.com/public-profile/in/arash-mirzaie")
        val likeIng = Intent(Intent.ACTION_VIEW, uri)

        likeIng.setPackage("com.linkedin.android")

        try {
            startActivity(likeIng)
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://ir.linkedin.com/public-profile/in/arash-mirzaie?challengeId=AQHMSx6vPyyGpAAAAXe6L5U1G9DEsp4P34-msgWmf1sd3XWvTs1WvTLVgrXROQusEOGQysQzXg2kqGTaK885-cI_dQgY_iiurg&submissionId=7589137d-b824-6516-ba18-92737e280467")
                )
            )
        }
    }

    private fun onInstagramClick() {
        binding.btnInsta.setOnClickListener {
            onInstagram()
        }
    }

    private fun onInstagram() {
        val uri: Uri = Uri.parse("https://www.instagram.com/arash.mirzaie.en")
        val likeIng = Intent(Intent.ACTION_VIEW, uri)

        likeIng.setPackage("com.instagram.android")

        try {
            startActivity(likeIng)
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/arash.mirzaie.en")
                )
            )
        }
    }

    fun onBackPress(){
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    findNavController().navigateUp()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), callback)
    }

}