package quick.widget.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.TextView;

public class MyColorState
{

    private int normal;

    private int pressed;

    private Context context;

    private int normalColor;

    private int pressedColor;

    private MyColorState()
    {

    }

    public static MyColorState create(Context context)
    {
        MyColorState colorStateUtil = new MyColorState();
        colorStateUtil.context = context;
        return colorStateUtil;
    }

    public static void makePressedTransColor(TextView textView)
    {
        int defaultColor = textView.getTextColors().getDefaultColor();
        try
        {
            int r = (int) (Color.red(defaultColor) + 50);
            int g = (int) (Color.green(defaultColor) + 50);
            int b = (int) (Color.blue(defaultColor) + 50);
            int a = Color.alpha(defaultColor);
            int newColor = Color.argb(a, r, g, b);

            // int a = (int) (defaultColor * 0.5);

            if (newColor == 0)
            {
                newColor = Color.GRAY;
            }
            create(textView.getContext()).normalColor(defaultColor).pressedColor(newColor).init
                    (textView);
        } catch (Exception e)
        {
            create(textView.getContext()).normalColor(defaultColor).pressedColor(Color.GRAY).init
                    (textView);
        }
    }

    public static ColorStateList newColorStateN_S(int normal, int state_selected)
    {


        int[][] states = new int[2][];

        states[0] = new int[]{android.R.attr.state_selected};

        states[1] = new int[]{};

        int[] colors = new int[]{state_selected, normal};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }
    public static ColorStateList newColorStateN_P(int normal, int pressed)
    {
        int[][] states = new int[2][];

        states[0] = new int[]{android.R.attr.state_pressed};

        states[1] = new int[]{};
        int[] colors = new int[]{pressed, normal};

        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }
    public static ColorStateList newColorStateN_P_S(int normal, int pressed, int selected)
    {
        int[][] states = new int[3][];

        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{android.R.attr.state_selected};
        states[2] = new int[]{};
        int[] colors = new int[]{pressed, selected, normal};

        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }



    public MyColorState init(TextView textView)
    {
        if (pressed != 0)
        {
            Resources res = context.getResources();
            textView.setTextColor(createColorStateList(res.getColor(normal), res.getColor
                    (pressed)));

        } else
        {
            textView.setTextColor(createColorStateList(normalColor, pressedColor));
        }

        return this;
    }

    private ColorStateList createColorStateList(int normal, int pressed)
    {
        int[] colors = new int[]{pressed, normal};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    public MyColorState normal(int normal)
    {
        this.normal = normal;
        return this;
    }

    public MyColorState pressed(int pressed)
    {
        this.pressed = pressed;
        return this;
    }

    public MyColorState normalColor(int normalColor)
    {
        this.normalColor = normalColor;
        return this;
    }

    public MyColorState pressedColor(int pressedColor)
    {
        this.pressedColor = pressedColor;
        return this;
    }
}
