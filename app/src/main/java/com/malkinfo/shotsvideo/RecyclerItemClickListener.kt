package com.malkinfo.shotsvideo

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener

class RecyclerItemClickListener(context: Context?, private val mListener: OnItemClickListener?) :
    OnItemTouchListener {
    var mGestureDetector: GestureDetector
    override fun onInterceptTouchEvent(view: RecyclerView, e: MotionEvent): Boolean {
        // タッチした箇所のViewを取得
        val childView = view.findChildViewUnder(e.x, e.y)
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            // onInterceptTouchEventのタイミングだとアイテムのtouch feedbackがつく前にonItemClickが呼ばれてしまうので、明示的にsetPressed(true)を呼んでいます。
            childView.isPressed = true
            mListener.onItemClick(childView, view.getChildPosition(childView))
        }
        return false
    }

    override fun onTouchEvent(view: RecyclerView, motionEvent: MotionEvent) {
        // Do nothing
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("Not yet implemented")
    }

    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    init {
        mGestureDetector = GestureDetector(context, object : SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }
        })
    }
}