package quick.adapter.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/8/8.
 */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<AdapterHelper> implements
                                                                                     View.OnClickListener
{

    protected final Context context;

    protected final int layoutResId;

    protected List<T> data;
    private OnItemClickListener mOnItemClickListener = null;
    protected LayoutInflater layoutInflater;

    /**
     * Create a QuickAdapter.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public RecyclerAdapter(Context context, int layoutResId)
    {
        this(context, layoutResId, null);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public RecyclerAdapter(Context context, int layoutResId, List<T> data)
    {
        this.data = data == null ? new ArrayList<T>() : data;
        this.context = context;
        this.layoutResId = layoutResId;
        layoutInflater = LayoutInflater.from(context);
    }

    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
        notifyDataSetChanged();
    }

    public void clear()
    {
        this.data = null;
        notifyDataSetChanged();
    }

    public void addData(List<T> data)
    {
        if (this.data == null)
        {
            setData(data);
        } else
        {
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    public void removeData(int position)
    {
        if (data != null)
        {
            this.data.remove(position);
        }

    }

    @Override
    public int getItemCount()
    {
        if (data == null)
        {
            return 0;
        }
        return data.size();
    }

    public T getItem(int position)
    {
        if (position >= data.size())
        {
            return null;
        }
        return data.get(position);
    }

    public T getItem(AdapterHelper adapterHelper)
    {
        return data.get(adapterHelper.getDataPosition());
    }

    @Override
    public AdapterHelper onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = layoutInflater.inflate(layoutResId, viewGroup, false);
        view.setOnClickListener(this);
        AdapterHelper vh = getAdapterHelper(view);
        return vh;
    }

    @NonNull
    public AdapterHelper getAdapterHelper(View view)
    {
        return new AdapterHelper(view);
    }

    @Override
    public void onBindViewHolder(AdapterHelper helper, int position)
    {
        helper.itemView.setTag(position);
        T item = getItem(position);
        convert(helper, item, position);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper   A fully initialized helper.
     * @param item     The item that needs to be displayed.
     * @param position
     */
    protected abstract void convert(AdapterHelper helper, T item, int position);

    @Override
    public void onClick(View v)
    {
        if (mOnItemClickListener != null)
        {
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mOnItemClickListener = listener;
    }

    //define interface
    public static interface OnItemClickListener
    {
        void onItemClick(View view, int position);
    }

}