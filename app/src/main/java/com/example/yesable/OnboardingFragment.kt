package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class OnboardingFragment : Fragment() {

    private lateinit var obButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageNumber = arguments?.getInt("page_number") ?: 0

        val layoutResId = when (pageNumber) {
            0 -> R.layout.fragment_onboarding1
            1 -> R.layout.fragment_onboarding2
            2 -> R.layout.fragment_onboarding3
            3 -> R.layout.fragment_onboarding4
            4 -> R.layout.fragment_onboarding5
            5 -> R.layout.fragment_onboarding6
            6 -> R.layout.fragment_onboarding7
            else -> R.layout.fragment_onboarding1
        }

        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        obButton = view.findViewById(R.id.ob_button)
        val pageNumber = arguments?.getInt("page_number") ?: 0

        obButton.setOnClickListener {
            when (pageNumber) {
                in 0..9 -> {
                    (activity as? OnboardingActivity)?.viewPager2?.currentItem = pageNumber + 1
                }
                10 -> {
                    val intent = Intent(activity, StartActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                }
            }
        }
    }

    companion object {
        fun newInstance(pageNumber: Int): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle()
            args.putInt("page_number", pageNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
