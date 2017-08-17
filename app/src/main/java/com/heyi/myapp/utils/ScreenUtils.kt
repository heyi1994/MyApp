package com.heyi.myapp.utils

import android.content.Context
import android.support.annotation.Keep
import android.util.TypedValue

/**
 * @author Heyi
 * @since 1.0.0
 */
class ScreenUtils {
    @Keep
    companion object {
        fun sp2px(context: Context,v:Float):Float=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,v,context.resources.displayMetrics)
        fun dp2px(context: Context,v:Float):Float=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,v,context.resources.displayMetrics)
        fun px2dp(context: Context,v:Float):Float=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,v,context.resources.displayMetrics)
        fun getStatusBarHeight(context: Context):Int=context.resources.getDimensionPixelSize(context.resources.getIdentifier("status_bar_height","dimen","android"))
    }
}