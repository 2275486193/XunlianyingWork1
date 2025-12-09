package com.example.w1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val tvSignature = findViewById<TextView>(R.id.tvSignature)
        val sp = getSharedPreferences("user_prefs", MODE_PRIVATE)
        val nickname = sp.getString("nickname", null) ?: sp.getString("username", "") ?: ""
        val signature = sp.getString("signature", "") ?: ""
        if (nickname.isNotEmpty()) tvUsername.text = nickname
        if (signature.isNotEmpty()) tvSignature.text = signature

        findViewById<LinearLayout>(R.id.itemNickname).setOnClickListener {
            val et = EditText(this)
            et.setText(tvUsername.text.toString())
            AlertDialog.Builder(this)
                .setTitle("修改昵称")
                .setView(et)
                .setPositiveButton("保存") { _, _ ->
                    val new = et.text.toString().trim()
                    getSharedPreferences("user_prefs", MODE_PRIVATE).edit()
                        .putString("nickname", new).apply()
                    tvUsername.text = new
                    Toast.makeText(this, "已保存", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("取消", null)
                .show()
        }
        findViewById<LinearLayout>(R.id.itemSignature).setOnClickListener {
            val et = EditText(this)
            et.setText(tvSignature.text.toString())
            AlertDialog.Builder(this)
                .setTitle("修改签名")
                .setView(et)
                .setPositiveButton("保存") { _, _ ->
                    val new = et.text.toString().trim()
                    getSharedPreferences("user_prefs", MODE_PRIVATE).edit()
                        .putString("signature", new).apply()
                    tvSignature.text = new
                    Toast.makeText(this, "已保存", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("取消", null)
                .show()
        }
        findViewById<LinearLayout>(R.id.itemChangePassword).setOnClickListener {
            Toast.makeText(this, "修改密码", Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.itemSettings).setOnClickListener {
            Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.itemVersion).setOnClickListener {
            Toast.makeText(this, "版本", Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.itemAbout).setOnClickListener {
            Toast.makeText(this, "关于我们", Toast.LENGTH_SHORT).show()
        }

        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            Toast.makeText(this, "已退出", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
