package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice10MatrixSkewView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = PointF(200f, 200f)
    internal var point2 = PointF(600f, 200f)
    val matrixS = Matrix()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        matrixS.setSkew(0f, 0.5f, point1.x, point1.y)
        canvas.concat(matrixS)
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint)
        matrixS.reset()
        canvas.restore()
        canvas.save()
        matrixS.setSkew(-0.5f, 0f, point1.x + bitmap.width, point1.y)
        canvas.concat(matrixS)
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint)
        matrixS.reset()
        canvas.restore()
    }
}
