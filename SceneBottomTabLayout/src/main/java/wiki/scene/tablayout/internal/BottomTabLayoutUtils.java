package wiki.scene.tablayout.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import wiki.scene.tablayout.custom.SpecialTab;
import wiki.scene.tablayout.custom.SpecialTabRound;
import wiki.scene.tablayout.item.BaseTabItem;
import wiki.scene.tablayout.item.NormalItemView;


public class BottomTabLayoutUtils {

    /**
     * Drawable 染色
     *
     * @param drawable 染色对象
     * @param color    颜色
     * @return 染色后的资源
     */
    public static Drawable tinting(Drawable drawable, int color) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        wrappedDrawable.mutate();
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

    public static Drawable newDrawable(Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState != null ? constantState.newDrawable() : drawable;
    }

    /**
     * 获取colorPrimary的颜色,需要V7包的支持
     *
     * @param context 上下文
     * @return 0xAARRGGBB
     */
    public static int getColorPrimary(Context context) {
        Resources res = context.getResources();
        int attrRes = res.getIdentifier("colorPrimary", "attr", context.getPackageName());
        if (attrRes == 0) {
            return 0xFF009688;
        }
        return ContextCompat.getColor(context, getResourceId(context, attrRes));
    }

    /**
     * 获取自定义属性的资源ID
     *
     * @param context 上下文
     * @param attrRes 自定义属性
     * @return resourceId
     */
    private static int getResourceId(Context context, int attrRes) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attrRes, typedValue, true);
        return typedValue.resourceId;
    }

    /**
     * 正常tab
     */
    public static BaseTabItem newSpecialItem(Context context, @DrawableRes int drawable, @DrawableRes int checkedDrawable, String text, @ColorInt int textColor, @ColorInt int checkedTextColor) {
        SpecialTab mainTab = new SpecialTab(context);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(textColor);//0xFF888888
        mainTab.setTextCheckedColor(checkedTextColor);//0xFF888888
        return mainTab;
    }

    /**
     * 圆形tab
     */
    public static BaseTabItem newSpecialRoundItem(Context context, @DrawableRes int drawable, @DrawableRes int checkedDrawable, String text, @ColorInt int textColor, @ColorInt int checkedTextColor) {
        SpecialTabRound mainTab = new SpecialTabRound(context);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(textColor);
        mainTab.setTextCheckedColor(checkedTextColor);
        return mainTab;
    }

    //创建一个Item
    public static BaseTabItem newNormalItem(Context context, @DrawableRes int drawable, @DrawableRes int checkedDrawable, String text, @ColorInt int textColor, @ColorInt int checkedTextColor) {
        NormalItemView normalItemView = new NormalItemView(context);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(textColor);
        normalItemView.setTextCheckedColor(checkedTextColor);
        return normalItemView;
    }

}
