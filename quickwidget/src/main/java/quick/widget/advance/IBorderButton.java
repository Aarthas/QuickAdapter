package quick.widget.advance;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import org.yi.statesbutton.R;
import quick.widget.help.IButtonHelper;
import quick.widget.help.ITextColorHelper;
import quick.widget.utils.ViewHelp;

/**
 * Created by admin on 2015/11/12.
 */
public class IBorderButton extends TextView
{
    public IBorderButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setGravity(Gravity.CENTER);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ITextView);


        final float corners = a.getDimensionPixelSize(R.styleable.ITextView_yi_corners, 0);
        final int stroke_width = a.getDimensionPixelSize(R.styleable.ITextView_yi_stroke_width, 0);
        final int yi_color = a.getColor(R.styleable.ITextView_yi_stroke_color, 0);
        int solid_color = a.getColor(R.styleable.ITextView_yi_solid_color, 0);
        a.recycle();
        boolean press_enable = true;
        if (solid_color == 0)
            solid_color = Color.WHITE;
        final int stroke_color = yi_color;
        final int solid_color_pressed = yi_color;
        final int solid_color_selected = yi_color;


        Drawable drawable = IButtonHelper.getDrawable(press_enable, corners, stroke_width,
                stroke_color, solid_color, solid_color_pressed, solid_color_selected, 0, 0, 0);
        ViewHelp.setBackground(this, drawable);
        ColorStateList x = ITextColorHelper.getColorStateList(yi_color, Color.WHITE, Color.WHITE);

        setTextColor(x);

    }
}
