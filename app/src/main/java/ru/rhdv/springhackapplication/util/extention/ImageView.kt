package ru.rhdv.springhackapplication.util.extention

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.mail.mailhackathonapplication.R

fun ImageView.loadImage(url: String) =
    Glide.with(this.context)
        .load(url)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.ic_profile)
                .error(R.drawable.ic_profile)
                .fitCenter()
        )
        .into(this)

fun ImageView.setImageFromFile(name: String) =
        Glide.with(this.context)
            .load(BitmapFactory.decodeFile("${Environment.getExternalStorageDirectory().absolutePath}/$name"))
            .apply(
                RequestOptions()
                    .fitCenter()
                    .centerCrop()
            )
            .into(this)

fun ImageView.setImageFromBitmap(bitmap: Bitmap) =
        Glide.with(this.context)
            .load(bitmap)
            .apply(
                RequestOptions()
                    .fitCenter()
                    .centerCrop()
            )
            .into(this)

fun ImageView.setImageFromUri(uri: Uri) {
    Glide.with(this.context)
        .load(uri)
        .apply(
            RequestOptions()
                .fitCenter()
                .centerCrop()
        )
        .into(this)
}

fun ImageView.setNewBackground(background: Int) =
        Glide.with(this.context)
            .load(background)
            .into(this)