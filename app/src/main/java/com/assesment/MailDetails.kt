package com.assesment

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import java.io.Serializable

data class MailDetails(
    val sender: String?,
    val title: String,
    val body: String,
    val isFav: Boolean = false,
    val time: Long=0L,
    @DrawableRes var imageIcon: Int = R.drawable.andimg
): Serializable