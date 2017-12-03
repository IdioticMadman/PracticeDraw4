package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice02ClipPathView : View {
    internal var paint = Paint()
    internal var bitmap: Bitmap
    internal var point1 = PointF(200f, 200f)
    internal var point2 = PointF(600f, 200f)
    val path1 = Path()
    val path2 = Path()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
        path1.addCircle(point1.x + bitmap.width / 2 + 50, point1.y + bitmap.height / 2 + 50, (bitmap.width / 2).toFloat(), Path.Direction.CW);
        path2.fillType = Path.FillType.INVERSE_WINDING
        path2.addCircle(point2.x + bitmap.width / 2 + 50, point2.y + bitmap.height / 2 + 50, (bitmap.width / 2).toFloat(), Path.Direction.CW);
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.clipPath(path1)
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint)
        canvas.restore()

        canvas.save()
        canvas.clipPath(path2)
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint)
        canvas.restore()
    }
}
