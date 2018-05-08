package quick.widget.help;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import org.yi.statesbutton.R;
import quick.widget.utils.MyColorState;

/**
 * Created by admin on 2015/10/21.
 */
public class ITextColorHelper
{
    public static ColorStateList parseTextColor(Context context, AttributeSet attrs)
    {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ITextColor);
        int yi_text_color_normal = a.getColor(R.styleable.ITextColor_yi_text_color_normal, 0);
        int yi_text_color_pressed = a.getColor(R.styleable.ITextColor_yi_text_color_pressed, 0);
        int yi_text_color_selected = a.getColor(R.styleable.ITextColor_yi_text_color_selected, 0);
        a.recycle();
        ColorStateList x = getColorStateList(yi_text_color_normal, yi_text_color_pressed,
                yi_text_color_selected);
        if (x != null)
        {
            return x;
        }
        return null;

    }

    public static ColorStateList getColorStateList(int yi_text_color_normal, int
            yi_text_color_pressed, int yi_text_color_selected)
    {
        if (yi_text_color_normal != 0)
        {
            ColorStateList colorStateList = null;
            if (yi_text_color_pressed != 0 && yi_text_color_selected != 0)
            {
                colorStateList = MyColorState.newColorStateN_P_S(yi_text_color_normal,
                        yi_text_color_pressed, yi_text_color_selected);

            }
           else  if (yi_text_color_pressed != 0)
            {
                colorStateList = MyColorState.newColorStateN_P(yi_text_color_normal,
                        yi_text_color_pressed);
            }
            else if (yi_text_color_selected != 0)
            {
                colorStateList = MyColorState.newColorStateN_S(yi_text_color_normal,
                        yi_text_color_selected);
            }
            if (colorStateList == null)
            {
                colorStateList = ColorStateList.valueOf(yi_text_color_normal);
            }
            return colorStateList;
        }
        return null;
    }
}
