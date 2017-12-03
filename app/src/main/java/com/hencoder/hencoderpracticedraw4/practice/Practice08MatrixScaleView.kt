package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice08MatrixScaleView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = PointF(200f, 200f)
    internal var point2 = PointF(600f, 200f)
    val matrixR = Matrix()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()

        matrixR.postScale(1.3f, 1.3f, point1.x + bitmap.width / 2, point1.y + bitmap.height / 2)
        canvas.concat(matrixR)
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint)
        matrixR.reset()
        canvas.restore()

        canvas.save()

        matrixR.postScale(0.6f, 1.6f, point2.x + bitmap.width / 2, point2.y + bitmap.height / 2)
        canvas.concat(matrixR)
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint)
        matrixR.reset()
        canvas.restore()
    }
}
