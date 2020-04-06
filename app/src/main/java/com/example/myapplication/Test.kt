package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Draw(this))
    }

    class Draw (context: Context) : View(context){

        override fun onDraw(canvas: Canvas?) {
            canvas!!.drawRGB(255,255,255)
            val brush = Paint()
            val brush2 = Paint()
            val brush3 = Paint()
            brush.setARGB(255,255,0,0)
            brush2.setARGB(200,0,0,0)
            brush3.setARGB(255,0,0,0)
            brush.strokeWidth = 5F
            brush2.strokeWidth = 5F
            brush3.strokeWidth = 10F

            canvas!!.drawLine(40F, 540F, 1040F, 540F, brush3)
            canvas!!.drawLine(540F, 40F, 540F, 1040F, brush3)

            for(i in 40..1040 step 50){
                canvas!!.drawLine(i.toFloat(), 40F, i.toFloat(), 1040F, brush2)
                canvas!!.drawLine(40F, i.toFloat(), 1040F, i.toFloat(), brush2)
            }

            var rect = Rect(40,40,1040,1040)
            brush3.setStyle(Paint.Style.STROKE)
            canvas!!.drawRect(rect, brush3)

            var k = 0F

            while (k <= 540F) {
                if((k * k + 4F) * 50 <= 900F) {
                    canvas!!.drawPoint((k * 50F) + 540F, (-1F * k * k + 4F) * 50F + 540F, brush)
                }
                if((k * k + 4F) * 50 <= 900F) {
                canvas!!.drawPoint((-1F * k) * 50F + 540F, (-1F * k * k + 4F) * 50F + 540F, brush)
                    }
                k += 0.001F
            }

            k = 0F

            while (k <= 540F) {
                canvas!!.drawPoint((k  * 50F) + 540F, (4F / k) * 50F + 540F, brush)
                canvas!!.drawPoint((-1F * k) * 50F + 540F, (-4F / k) * 50F + 540F, brush)
                k += 0.001F
            }


        }
    }
}
