package com.heyi.myapp.base

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.*
import android.support.annotation.IntRange
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.heyi.myapp.R
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

/**
 * @author Heyi
 * @since 1.0.0
 */
abstract class BaseActivity:SwipeBackActivity(),IView{
    protected val TAG:String=this.javaClass.simpleName
    protected var progress:ProgressDialog?=null

     @CallSuper
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
         initData()
   }


    @NonNull
    @MainThread
    protected abstract fun getLayoutId(): Int

    @MainThread
    protected abstract fun initData()

    @UiThread
    @NonNull
    override fun toastMsg(msg: Int) {
     Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    @UiThread
    override fun showLoading() {
     if (progress!=null&&progress!!.isShowing){
         progress!!.dismiss()
     }
     progress= ProgressDialog.show(this,null,getString(R.string.msg_loading),true,true)
    }

    @UiThread
    override fun loadingFinish() {
     if (progress!=null&&progress!!.isShowing){
         progress!!.dismiss()
     }
     }

    @CallSuper
    override fun startActivity(intent: Intent?) {
     super.startActivity(intent)
     overridePendingTransition(getTranslateAnimIn(),getTranslateAnimOut())
    }

    @CallSuper
    override fun startActivityForResult(intent: Intent?, requestCode: Int, options: Bundle?) {
     super.startActivityForResult(intent, requestCode, options)
     overridePendingTransition(getTranslateAnimIn(),getTranslateAnimOut())
    }

    /**
     * @see BaseConst
     */
    protected fun configScreen(@IntRange(from=1,to=3)type:Int,@ColorRes color:Int=R.color.red_status_bar_color){
      when(type){
       BaseConst.ACTIVITY_FULLSCREEN->window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
       BaseConst.ACTIVITY_STATUSBAR_TRANSPARENT->{
        if(Build.VERSION.SDK_INT>=19){
         window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
       }
       BaseConst.ACTIVITY_SET_STATUSBAR_COLOR->{
        if (Build.VERSION.SDK_INT>=21){
         window.statusBarColor=resources.getColor(color)
        }
       }
      }
    }

    @CallSuper
    override fun onRestart() {
     super.onRestart()
        Log.d(TAG,"---onRestart---")
     }

    @CallSuper
    override fun onPause() {
     super.onPause()
      Log.d(TAG,"---onPause---")
     }

    @CallSuper
    override fun onResume() {
     super.onResume()
     Log.d(TAG,"---onResume---")
     }

    @CallSuper
    override fun onStart() {
     super.onStart()
      Log.d(TAG,"---onStart---")
    }

    @CallSuper
    override fun onStop() {
     super.onStop()
      Log.d(TAG,"---onStop---")
     }


}