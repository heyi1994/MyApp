package com.heyi.myapp.ui.splash

import android.widget.Toast
import com.heyi.myapp.R
import com.heyi.myapp.base.BaseActivity
import com.heyi.myapp.base.BaseConst
import com.heyi.myapp.utils.sharepreferences.SharePreferenceHelper

/**
 * @author Heyi
 * @since 1.0.0
 */
class SplashActivity:BaseActivity() {
    override fun getLayoutId(): Int= R.layout.activity_splash

    override fun initData() {
        configScreen(BaseConst.ACTIVITY_FULLSCREEN)

    }
}