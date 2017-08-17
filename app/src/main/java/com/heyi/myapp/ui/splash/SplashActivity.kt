package com.heyi.myapp.ui.splash

import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.heyi.myapp.R
import com.heyi.myapp.base.BaseActivity
import com.heyi.myapp.base.BaseConst
import com.heyi.myapp.ui.main.MainActivity
import com.heyi.myapp.utils.sharepreferences.SharePreferenceHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit

/**
 * @author Heyi
 * @since 1.0.0
 */
class SplashActivity:BaseActivity() {
    override fun getLayoutId(): Int= R.layout.activity_splash

    override fun initData() {
        configScreen(BaseConst.ACTIVITY_FULLSCREEN)
        if (SharePreferenceHelper.isFirstRun()){
            btn_start.visibility=View.VISIBLE
        }else{
            btn_start.visibility=View.GONE
            val subscribe = Observable.timer(2, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer {
                        startActivity(MainActivity.getIntent(this))
                        finish()
                    })
             addSubscription(subscribe)
        }

        val subscribe = Observable.timer(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { t ->
                    tv_app.visibility = View.VISIBLE
                    tv_app.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_top_in))
                })
        addSubscription(subscribe)

        btn_start.setOnClickListener {
           startActivity(MainActivity.getIntent(this))
            finish()
            SharePreferenceHelper.setIsFirstRun(false)
        }

    }
}