package com.example.valorantagentapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValorantAgents (
    val name: String,
    val role: String,
    val description: String,
    val photo: Int,
    val strength: String,
    val weakness: String,
) : Parcelable
