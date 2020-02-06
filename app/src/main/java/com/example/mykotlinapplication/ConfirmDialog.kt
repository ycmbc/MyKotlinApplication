package com.example.mykotlinapplication


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * 通用dialog
 */
class ConfirmDialog : DialogFragment() {

    private var mContentView: View? = null
    private var callBack: onCallBack? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dialog = dialog
        if (dialog != null) {
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            if (dialog.window != null) {
                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }
        mContentView = inflater.inflate(R.layout.dialog_confirm, container, false)
        return mContentView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linClose = mContentView!!.findViewById<LinearLayout>(R.id.lin_close)
        val tvContent = mContentView!!.findViewById<TextView>(R.id.tv_content)
        val btnConfirm = mContentView!!.findViewById<AppCompatButton>(R.id.btn_confirm)
        val bundle = arguments
        if (bundle != null) {
            tvContent.setText(bundle.getInt("contentId"))
            btnConfirm.setText(bundle.getInt("confirmId"))
        }
        linClose.setOnClickListener { v -> dismiss() }
        btnConfirm.setOnClickListener { v ->
            if (callBack != null) {
                callBack!!.onConfirm()
                dismiss()
            }
        }

    }


    fun setOnCallBack(callBack: onCallBack) {
        this.callBack = callBack
    }

    interface onCallBack {
        fun onConfirm()
    }

    companion object {

        fun newInstance(contentId: Int, confirmId: Int): ConfirmDialog {
            val confirmDialog = ConfirmDialog()
            val bundle = Bundle()
            bundle.putInt("contentId", contentId)
            bundle.putInt("confirmId", confirmId)
            confirmDialog.arguments = bundle
            return confirmDialog
        }
    }
}
