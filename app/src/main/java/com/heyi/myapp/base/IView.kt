package com.heyi.myapp.base

import android.support.annotation.IntegerRes
import android.support.annotation.StringRes
import com.heyi.myapp.R

/**
 * @author Heyi
 * @since 1.0.0
 */
interface IView {
    fun toastMsg(@StringRes msg:Int)
    fun showLoading()
    fun loadingFinish()
    fun getTranslateAnimIn():Int=R.anim.anim_left_in
    fun getTranslateAnimOut():Int=R.anim.anim_left_out
}