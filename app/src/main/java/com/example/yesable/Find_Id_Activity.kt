package com.example.yesable

import android.widget.Button

class Find_Id_Activity : Fragment() {
    val dialog = Dialog(this)
    dialog.setContentView(R.layout.dialog_find_id_error)

    val button = dialog.findViewById<Button>(R.id.dialog_button)
    button.setOnClickListener {
        dialog.dismiss() // 버튼 클릭 시 다이얼로그 닫기
    }

    dialog.show()

}