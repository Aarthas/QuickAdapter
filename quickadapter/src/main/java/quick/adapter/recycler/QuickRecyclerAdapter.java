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
public abstract class QuickRecyclerAdapter<T, H extends QuickAdaptHelper> extends RecyclerView.Adapter<AdapterHelper> implements View.OnClickListener{

    protected final Context context;
 
    protected final int layoutResId;
 
    protected  List<T> data;
 
    protected boolean displayIndeterminateProgress = false;
 
    private OnItemClickListener mOnItemClickListener = null;
 
    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
 
    /**
     * Create a QuickAdapter.
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public QuickRecyclerAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }
 
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public QuickRecyclerAdapter(Context context, int layoutResId, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : data;
        this.context = context;
        this.layoutResId = layoutResId;
    }
 
    @Override
    public int getItemCount() {
        return data.size();
    }
 
 
    public T getItem(int position) {
        if (position >= data.size())
        {
            return null;
        }
        return data.get(position);
    }
    @Override
    public AdapterHelper onCreateViewHolder(ViewGroup viewGroup,  int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutResId, viewGroup, false);
        view.setOnClickListener(this);
        AdapterHelper vh = getAdapterHelper(view);
        return vh;
    }

    @NonNull
    public abstract AdapterHelper getAdapterHelper(View view);

    @Override
    public void onBindViewHolder(AdapterHelper helper,  int position) {
        helper.itemView.setTag(position);
        T item = getItem(position);
        convert((H)helper, item,position);
    }
 
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    protected  void convert(H helper, T item,int position)
    {
        if (helper instanceof QuickAdaptHelper)
        {
            final QuickAdaptHelper helper1 = (QuickAdaptHelper) helper;
            helper1.renderWithSave((T) item, position);
        }
    };
 
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
 
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public void setData(List<T> data)
    {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<T> data)
    {
        if (data == null)
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
            notifyDataSetChanged();
        }

    }

    public void removeData(T o)
    {
        if (data != null)
        {
            this.data.remove(o);
            notifyDataSetChanged();
        }

    }
}