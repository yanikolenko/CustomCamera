package com.example.customcameraapp

import android.app.Activity
import android.graphics.Canvas
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView


class SurfaceViewLineDemo : Activity(), SurfaceHolder.Callback {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = SurfaceView(this)
        setContentView(view)
        view.holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        tryDrawing(holder)
    }

    override fun surfaceChanged(holder: SurfaceHolder, frmt: Int, w: Int, h: Int) {
        tryDrawing(holder)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {}
    private fun tryDrawing(holder: SurfaceHolder) {
        //Log.i(TAG, "Trying to draw...")
        val canvas: Canvas? = holder.lockCanvas()
        if (canvas == null) {
            //Log.e(TAG, "Cannot draw onto the canvas as it's null")
        } else {
            drawMyStuff(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }

    private fun drawMyStuff(canvas: Canvas) {
        //val random = Random()
       // Log.i(TAG, "Drawing...")
        canvas.drawRGB(255, 128, 128)
    }

    companion object {
        private const val TAG = "TestSurface"
    }
}