package com.bin.david.dialoglib.anim;

import android.animation.Animator;
import android.os.Build;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * Created by huang on 2017/9/20.
 * 阻尼动画
 */

public class SpringDialogAnim extends IBaseDialogAnim {



    @Override
    public void showAnim(View contentView) {
        contentView.setTranslationY(contentView.getHeight());
        SpringForce springForce = new SpringForce(0)
                .setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        final SpringAnimation anim = new SpringAnimation(contentView ,SpringAnimation.TRANSLATION_Y).setSpring(springForce);
        anim.start();
    }

    @Override
    public void dismissAnim(View contentView, final Animator.AnimatorListener animatorListener) {
        contentView.setTranslationY(0);
        SpringForce springForce = new SpringForce(contentView.getHeight())
                .setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_MEDIUM);
        final SpringAnimation anim = new SpringAnimation(contentView ,SpringAnimation.TRANSLATION_Y).setSpring(springForce);
        anim.start();
        anim.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                animatorListener.onAnimationEnd(null);
            }
        });

    }
}
