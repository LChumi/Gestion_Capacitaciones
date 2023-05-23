/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 16/5/23 22:00
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.model.SliderItem;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH>{
    private Context context;
    private List<SliderItem> mSliderItems = new ArrayList<>();

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {

        SliderItem sliderItem = mSliderItems.get(position);

        viewHolder.textView.setText(sliderItem.getTitulo());
        viewHolder.textView.setTextSize(16);
        viewHolder.textView.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImagen())
                .fitCenter()
                .into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    public void updateItem(List<SliderItem> lista) {
        mSliderItems.clear();
        mSliderItems.addAll(lista);
        this.notifyDataSetChanged();
    }

    protected class SliderAdapterVH extends SliderViewAdapter.ViewHolder{
        View itemView;
        ImageView imageView;
        TextView textView;

        public SliderAdapterVH(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_auto_image_slider);
            textView = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}
