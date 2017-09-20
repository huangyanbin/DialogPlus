package com.bin.david.dialoglib.anim;


import android.animation.Animator;
import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * Created by huang on 2017/9/20.
 */

public class RotateYDialogAnim extends IBaseDialogAnim {

    @Override
    public void showAnim(View contentView) {
        contentView.setRotationY(90);
        contentView.setAlpha(0);
        ViewCompat.animate(contentView).rotationY(0).alpha(1).setDuration(400).start();
    }

    @Override
    public void dismissAnim(View contentView, final Animator.AnimatorListener animatorListener) {
        contentView.setRotationY(0);
        contentView.setAlpha(1);
        ViewCompat.animate(contentView).rotationY(90).alpha(0).setDuration(400).withEndAction(new Runnable() {
            @Override
            public void run() {
                animatorListener.onAnimationEnd(null);
            }
        }).start();
    }
}
