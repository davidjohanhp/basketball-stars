package com.example.proyekakhirsimpleapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val description: String,
    val awards: String,
    val photo: String
) : Parcelable
