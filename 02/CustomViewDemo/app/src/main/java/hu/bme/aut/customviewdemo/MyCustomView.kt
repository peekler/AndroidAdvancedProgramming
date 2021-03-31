package hu.bme.aut.customviewdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent


class MyCustomView(context: Context, attrs: AttributeSet) : androidx.appcompat.widget.AppCompatButton(
    context,
    attrs
) {

    private var paintText: Paint = Paint()

    private var click = 0

    init {
        paintText.color = Color.RED
        paintText.style = Paint.Style.FILL_AND_STROKE
        paintText.textSize = 60f

        val attr = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CountColor,
            0, 0
        )

        var color = Color.RED
        try {
            color = attr.getColor(R.styleable.CountColor_countcolor, Color.RED)
            paintText.color = color
        } finally {
            // release the TypedArray so that it can be reused.
            attr.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText("$click", width - 60f, 70f, paintText)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN){
            click++
            invalidate()
        }

        return super.onTouchEvent(event)
    }
}