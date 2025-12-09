package com.example.w1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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
        val nickname = intent.getStringExtra("username").orEmpty()
        if (nickname.isNotEmpty()) tvUsername.text = nickname
        val signature = intent.getStringExtra("signature").orEmpty()
        if (signature.isNotEmpty()) tvSignature.text = signature

        findViewById<LinearLayout>(R.id.itemNickname).setOnClickListener {
            Toast.makeText(this, "昵称", Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.itemSignature).setOnClickListener {
            Toast.makeText(this, "签名", Toast.LENGTH_SHORT).show()
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
