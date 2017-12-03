package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw4.R

class Practice01ClipRectView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val left = ((width - bitmap.width) / 2).toFloat()
        val top = ((height - bitmap.height) / 2).toFloat()
        canvas.save()
        canvas.clipRect(left + 50, top + 50, left + 300, top + 200)
        canvas.drawBitmap(bitmap, left, top, paint)
        canvas.restore()
    }
}
