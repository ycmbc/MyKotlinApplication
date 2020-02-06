package com.example.mykotlinapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val confirmDialog = ConfirmDialog.newInstance(R.string.app_name, R.string.app_name)
        confirmDialog.setOnCallBack(object : ConfirmDialog.onCallBack {
            override fun onConfirm() {
                Toast.makeText(this@MainActivity, "222", Toast.LENGTH_LONG).show()
            }
        })
        confirmDialog.show(supportFragmentManager, "ss")
    }


    override fun onPause() {
        super.onPause()
        getData()
    }

    private fun getData() {
        val time = 3


    }
}
