package com.example.yesable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment



class Tab_Buttons_Fragment2 : Fragment() {

    private var selectedTab: Int = R.id.business_number_tab // 기본값으로 사업자번호 탭 설정

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab_buttons, container, false)

        val businessNumberMemberTab: Button = view.findViewById(R.id.business_number_tab)
        val phoneNumberMemberTab: Button = view.findViewById(R.id.phone_number_tab)

        businessNumberMemberTab.setOnClickListener {
            selectedTab = R.id.business_number_tab
        }

        phoneNumberMemberTab.setOnClickListener {
            selectedTab = R.id.phone_number_tab
        }

    return view
    }

    fun getSelectedTab(): Int {
        return selectedTab
    }
    fun disableTabSelection(selectedTab: Int) {
        // Disable tab selection, prevent user from changing tabs
        val view = view ?: return
        val businessNumberMemberTab: Button = view.findViewById(R.id.business_number_tab)
        val phoneNumberMemberTab: Button = view.findViewById(R.id.phone_number_tab)

        businessNumberMemberTab.isEnabled = false
        phoneNumberMemberTab.isEnabled = false

        if (selectedTab == R.id.business_number_tab) {
            businessNumberMemberTab.isSelected = true
        } else if (selectedTab == R.id.phone_number_tab) {
            phoneNumberMemberTab.isSelected = true
        }
    }
}
