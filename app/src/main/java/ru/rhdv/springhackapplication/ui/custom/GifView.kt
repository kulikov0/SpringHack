package ru.rhdv.springhackapplication.ui.custom

import android.graphics.Movie
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.io.IOException
import java.io.InputStream

class GifView : View {

    internal var movie: Movie? = null
    internal var moviestart: Long = 0

    @Throws(IOException::class)
    constructor(context: Context) : super(context) {
    }

    @Throws(IOException::class)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    @Throws(IOException::class)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    }

    fun loadGIFResource(context: Context, id: Int) {
        //turn off hardware acceleration
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        val `is` = context.resources.openRawResource(id)
        movie = Movie.decodeStream(`is`)
    }

    fun loadGIFAsset(context: Context, filename: String) {
        val `is`: InputStream
        try {
            `is` = context.resources.assets.open(filename)
            movie = Movie.decodeStream(`is`)
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (movie == null) {
            return
        }

        val now = android.os.SystemClock.uptimeMillis()

        if (moviestart == 0L) moviestart = now

        val relTime: Int
        relTime = ((now - moviestart) % movie!!.duration()).toInt()
        movie!!.setTime(relTime)
        movie!!.draw(canvas, 10f, 10f)
        this.invalidate()
    }
}