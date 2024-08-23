package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Find_Id_Finish_Activity : AppCompatActivity() {

    private var selectedTab: Int = R.id.general_member_tab // 기본값으로 설정

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_finish)

        // Find_Id_Activity에서 전달된 탭 정보 받기
        selectedTab = intent.getIntExtra("selected_tab", R.id.general_member_tab)

         //사용자가 탭을 변경할 수 없도록 설정
        val fragment = supportFragmentManager.findFragmentById(R.id.tab_buttons_fragment_container)
        if (fragment is Tab_Buttons_Fragment1) {
            fragment.disableTabSelection(selectedTab)
        }

        // 로그인 버튼 클릭 시 LoginActivity로 이동
        val loginButton: Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}

//비밀번호 찾기 미구현