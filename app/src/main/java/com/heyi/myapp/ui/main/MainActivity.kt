package com.heyi.myapp.ui.main

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.support.v4.widget.DrawerLayout
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.heyi.myapp.R
import com.heyi.myapp.base.BaseActivity
import com.heyi.myapp.base.BaseConst
import com.heyi.myapp.utils.ScreenUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_activity_main_master.*


/**
 * @author Heyi
 * @since 1.0.0
 */
class MainActivity:BaseActivity() {
    companion object {
        fun getIntent(context: Context):Intent{
         return Intent(context,MainActivity::class.java)
        }
    }
    override fun getLayoutId(): Int = R.layout.activity_main
    override fun initData() {
        configScreen(BaseConst.ACTIVITY_STATUSBAR_TRANSPARENT)
        setSwipeBackEnable(false)
        toolBar.setPadding(0,ScreenUtils.getStatusBarHeight(this),0,0)
        iv_open_left.setOnClickListener {
            drawer_layout.openDrawer(Gravity.START)
        }
        drawer_layout.addDrawerListener(object :DrawerLayout.DrawerListener{
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {
            }

            override fun onDrawerClosed(drawerView: View?) {
            }

            override fun onDrawerOpened(drawerView: View?) {
            }

        })
    }
}