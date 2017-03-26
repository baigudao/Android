package com.jackie.android.frame.glide;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.jackie.android.R;
import com.jackie.android.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

/**
 * Created by jackie on 2017/3/24 13:39.
 * QQ : 971060378
 * Used as : xxx
 */
public class GlideTransformationAdapter extends RecyclerView.Adapter<GlideTransformationAdapter.ViewHolder> {

    private Context context;
    private List<String> datas = new ArrayList<>();

    public GlideTransformationAdapter(Context context) {
        this.context = context;
        for (int i = 1; i <= 21; i++) {
            datas.add(i + "");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item_glide_transformation, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // 设置名称
        holder.tv_glide_name.setText("item" + (position + 1));

        int integer = Integer.parseInt(datas.get(position));

        switch (integer) {
            case 1: {
                int width = DensityUtil.dip2px(context, 133.33f);
                int height = DensityUtil.dip2px(context, 126.33f);
                Glide.with(context)
                        .load(R.drawable.check)
                        .override(width, height)
                        .bitmapTransform(new CenterCrop(context),
                                new MaskTransformation(context, R.drawable.mask_starfish))
                        .into(holder.iv_glide_transformation);
                break;
            }
            case 2: {
                int width = DensityUtil.dip2px(context, 150.0f);
                int height = DensityUtil.dip2px(context, 100.0f);
                Glide.with(context)
                        .load(R.drawable.check)
                        .override(width, height)
                        .bitmapTransform(new CenterCrop(context),
                                new MaskTransformation(context, R.drawable.mask_chat_right))
                        .into(holder.iv_glide_transformation);
                break;
            }
            case 3:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(
                                new CropTransformation(context, 300, 100, CropTransformation.CropType.TOP))
                        .into(holder.iv_glide_transformation);
                break;
            case 4:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new CropTransformation(context, 300, 100))
                        .into(holder.iv_glide_transformation);
                break;
            case 5:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(
                                new CropTransformation(context, 300, 100, CropTransformation.CropType.BOTTOM))
                        .into(holder.iv_glide_transformation);

                break;
            case 6:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new CropSquareTransformation(context))
                        .into(holder.iv_glide_transformation);
                break;
            case 7:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new CropCircleTransformation(context))
                        .into(holder.iv_glide_transformation);
                break;
            case 8:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new ColorFilterTransformation(context, Color.argb(80, 255, 0, 0)))
                        .into(holder.iv_glide_transformation);
                break;
            case 9:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new GrayscaleTransformation(context))
                        .into(holder.iv_glide_transformation);
                break;
            case 10:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new RoundedCornersTransformation(context, 30, 0,
                                RoundedCornersTransformation.CornerType.BOTTOM))
                        .into(holder.iv_glide_transformation);
                break;
            case 11:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new BlurTransformation(context, 25))
                        .into(holder.iv_glide_transformation);
                break;
            case 12:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new ToonFilterTransformation(context))
                        .into(holder.iv_glide_transformation);
                break;
            case 13:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new SepiaFilterTransformation(context))
                        .into(holder.iv_glide_transformation);
                break;
            case 14:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new ContrastFilterTransformation(context, 2.0f))
                        .into(holder.iv_glide_transformation);
                break;
            case 15:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new InvertFilterTransformation(context))
                        .into(holder.iv_glide_transformation);
                break;
            case 16:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new PixelationFilterTransformation(context, 20))
                        .into(holder.iv_glide_transformation);
                break;
            case 17:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new SketchFilterTransformation(context))
                        .into(holder.iv_glide_transformation);
                break;
            case 18:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(
                                new SwirlFilterTransformation(context, 0.5f, 1.0f, new PointF(0.5f, 0.5f)))
                        .into(holder.iv_glide_transformation);
                break;
            case 19:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new BrightnessFilterTransformation(context, 0.5f))
                        .into(holder.iv_glide_transformation);
                break;
            case 20:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new KuwaharaFilterTransformation(context, 25))
                        .into(holder.iv_glide_transformation);
                break;
            case 21:
                Glide.with(context)
                        .load(R.drawable.check)
                        .bitmapTransform(new VignetteFilterTransformation(context, new PointF(0.5f, 0.5f),
                                new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f))
                        .into(holder.iv_glide_transformation);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_glide_transformation;
        private TextView tv_glide_name;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_glide_transformation = (ImageView) itemView.findViewById(R.id.iv_glide_transformation);
            tv_glide_name = (TextView) itemView.findViewById(R.id.tv_glide_name);
        }
    }
}
