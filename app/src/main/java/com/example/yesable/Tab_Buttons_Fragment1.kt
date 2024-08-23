package com.example.yesable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class Tab_Buttons_Fragment1 : Fragment() {

    private var selectedTab: Int = R.id.general_member_tab // 기본값으로 일반회원 탭 설정

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab_buttons, container, false)

        val generalMemberTab: Button = view.findViewById(R.id.general_member_tab)
        val companyMemberTab: Button = view.findViewById(R.id.company_member_tab)

        generalMemberTab.setOnClickListener {
            selectedTab = R.id.general_member_tab
        }

        companyMemberTab.setOnClickListener {
            selectedTab = R.id.company_member_tab
        }

        return view
    }

    fun getSelectedTab(): Int {
        return selectedTab
    }
    fun disableTabSelection(selectedTab: Int) {
        // Disable tab selection, prevent user from changing tabs
        val view = view ?: return
        val generalMemberTab: Button = view.findViewById(R.id.general_member_tab)
        val companyMemberTab: Button = view.findViewById(R.id.company_member_tab)

        generalMemberTab.isEnabled = false
        companyMemberTab.isEnabled = false

        if (selectedTab == R.id.general_member_tab) {
            generalMemberTab.isSelected = true
        } else if (selectedTab == R.id.company_member_tab) {
            companyMemberTab.isSelected = true
        }
    }
}
