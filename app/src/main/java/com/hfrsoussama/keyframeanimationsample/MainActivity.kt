package com.hfrsoussama.keyframeanimationsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startAnimation(v: View) {
        Log.wtf("TAG", "HOLA !")
        val myViewGroup = findViewById<ConstraintLayout>(R.id.cl_root_view)

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.second_keyframe_activity_main)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)

        TransitionManager.beginDelayedTransition(myViewGroup, transition)
        constraintSet.applyTo(myViewGroup)

    }
}
