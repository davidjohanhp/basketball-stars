package com.example.proyekakhirsimpleapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailPlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)

        val tvPlayerName: TextView = findViewById(R.id.tv_item_name)
        val tvPlayerDesc: TextView = findViewById(R.id.tv_item_description)
        val tvPlayerAwards: TextView = findViewById(R.id.tv_item_awards)
        val imgPlayer: ImageView  = findViewById(R.id.item_image)

        val dataPlayer = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_player", Player::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_player")
        }

        if (dataPlayer != null) {
            tvPlayerName.text = dataPlayer.name
            tvPlayerDesc.text = dataPlayer.description
            Glide.with(applicationContext)
                .load(dataPlayer.photo)
                .into(imgPlayer)
            tvPlayerAwards.text = dataPlayer.awards
        }
    }
}