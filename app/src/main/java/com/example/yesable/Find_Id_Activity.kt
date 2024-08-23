package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Find_Id_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // Fragment에서 선택된 탭 확인
//        val fragment = supportFragmentManager.findFragmentById(R.id.tab_buttons_fragment_container)
//        if (fragment is Tab_Buttons_Fragment1) {
//            when (fragment.getSelectedTab()) {
//                R.id.general_member_tab -> {
//                    // 일반회원 탭이 선택된 경우
//                    setContentView(R.layout.activity_find_gid)
//                }
//                R.id.company_member_tab -> {
//                    // 기업회원 탭이 선택된 경우, Tab_Buttons_Fragment2를 사용
//                    supportFragmentManager.beginTransaction().replace(R.id.tab_buttons_fragment_container, Tab_Buttons_Fragment2()).commit()
//
//                    val fragment2 = supportFragmentManager.findFragmentById(R.id.tab_buttons_fragment_container)
//                    if (fragment2 is Tab_Buttons_Fragment2) {
//                        when (fragment2.getSelectedTab()) {
//                            R.id.business_number_tab -> {
//                                // 사업자번호로 찾기 탭이 선택된 경우
//                                setContentView(R.layout.activity_find_cid_business)
//                            }
//                            R.id.phone_number_tab -> {
//                                // 휴대전화로 찾기 탭이 선택된 경우
//                                setContentView(R.layout.activity_find_cid_phone)
//                            }
//                            else -> {
//                                // 기본적으로 사업자번호로 찾기 탭이 선택된 것으로 간주
//                                setContentView(R.layout.activity_find_cid_business)
//                            }
//                        }
//                    }
//                }
//                else -> {
//                    // 기본적으로 일반회원 탭이 선택된 것으로 간주
//                    setContentView(R.layout.activity_find_gid)
//                }
//            }
//        } else {
//            // Fragment가 로드되지 않은 경우 기본값 설정
//            setContentView(R.layout.activity_find_gid)
//        }

        // 뒤로가기 버튼 설정
        val back_button = findViewById<TextView>(R.id.back_button)
        back_button.setOnClickListener {
            finish() // 현재 액티비티를 종료하고 이전 화면으로 돌아갑니다.
        }

        // 아이디 찾기 버튼 설정
        val findIdButton: Button = findViewById(R.id.find_id_button)
        findIdButton.setOnClickListener {
            val isInputValid = validateInput()

            if (isInputValid) {
                val intent = Intent(this, Find_Id_Finish_Activity::class.java)
                startActivity(intent)
            } else {
                showErrorPopup()
            }
        }
    }

    // 입력값을 검증하는 함수
    private fun validateInput(): Boolean {
        // 실제 로직에서는 입력값을 가져와서 확인해야 합니다.
        return false // 예제로는 항상 오류가 발생하도록 합니다.
    }

    // 오류 팝업을 표시하는 함수
    private fun showErrorPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_find_id_error_popup, null)
        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val errorButton: Button = dialogView.findViewById(R.id.dialog_button)
        errorButton.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}
