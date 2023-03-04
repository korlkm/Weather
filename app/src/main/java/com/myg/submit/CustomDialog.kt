package com.myg.submit

import android.app.Dialog
import android.content.Context
import com.myg.submit.databinding.LayoutDialogBinding

class CustomDialog(context: Context) {

    lateinit var binding: LayoutDialogBinding
    private val dialog = Dialog(context)

    fun show(title: String, content: String) {
        binding = LayoutDialogBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(binding.root)
//        dialog.setContentView(R.layout.layout_dialog)

        if(title != "") {
            binding.dialogTitle.text = title
        }
        if(content != "") {
            binding.dialogContent.text = content
        }

        initView()
        dialog.show()
    }

    fun initView() {
        binding.btnConfirm.setOnClickListener {
            android.os.Process.killProcess(android.os.Process.myPid());  //앱 종료
        }

        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
    }

}