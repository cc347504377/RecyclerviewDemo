package com.luoye.demo.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by Luoye on 2016/10/24.
 */

public class RcycleAdapter extends RecyclerView.Adapter implements CompoundButton.OnCheckedChangeListener {
    private Context context;
    private List<Iteminfo> datas;

    public RcycleAdapter(List<Iteminfo> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleviewitem, parent, false);
        Viewholer holer = new Viewholer(view);
        return holer;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,int position) {
        Log.i("TAG", position + "" + datas.get(position).isChecked() + "");
        Viewholer viewholer = ((Viewholer) holder);
        //为checkbox设置tag，为了让点击监听时得到当前position
        //必须放在setchecked之前，否则setchecked会触发监听，这样之前的状态会被覆盖。
        viewholer.getCheckBox().setTag(position);
        viewholer.getCheckBox().setChecked(datas.get(position).isChecked());
        //通过修改params 实现简单的瀑布流效果
        ViewGroup.LayoutParams params = viewholer.getTextView().getLayoutParams();
        params.height = 50+new Random().nextInt(100);
        viewholer.getTextView().setText(datas.get(position).getTv());
        viewholer.getCheckBox().setOnCheckedChangeListener(this);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        datas.get((Integer) buttonView.getTag()).setChecked(isChecked);
    }
}
class Viewholer extends RecyclerView.ViewHolder{

    private CheckBox checkBox;
    private TextView textView;

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public TextView getTextView() {
        return textView;
    }

    public Viewholer(View itemView) {
        super(itemView);
        checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        textView = (TextView) itemView.findViewById(R.id.tv);
    }

}
