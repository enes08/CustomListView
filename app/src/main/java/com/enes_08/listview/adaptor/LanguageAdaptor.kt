package com.enes_08.listview.adaptor

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.enes_08.listview.R
import com.enes_08.listview.model.Language
import kotlinx.android.synthetic.main.item_list_language.view.*

class LanguageAdaptor(var mContext: Activity, var listLanguage: ArrayList<Language>) : BaseAdapter() {

    private val mlayoutInflater: LayoutInflater
    private val mlistDetail: ArrayList<Language>

    init {

        mlayoutInflater = LayoutInflater.from(mContext)
        mlistDetail = listLanguage
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view:View
        val listRowHolder:ListViewHolder

        if(convertView==null){
            view=this.mlayoutInflater.inflate(R.layout.item_list_language,parent,false)
            listRowHolder= ListViewHolder(view)
            view.tag=listRowHolder
        }
        else{
            view=convertView
            listRowHolder=view.tag as ListViewHolder
        }

        listRowHolder.ivLanguage.setBackgroundResource(mlistDetail.get(position).img)
                listRowHolder.tvDate.setText(mlistDetail.get(position).date)
                listRowHolder.tvLanguageDetail.setText(mlistDetail.get(position).description)
                listRowHolder.tvLanguageName.setText(mlistDetail.get(position).name)
                listRowHolder.rbRating.rating=(mlistDetail.get(position).rating).toFloat()


        listRowHolder.itemView.setOnClickListener(){
            
        }


            return view
    }

    override fun getItem(position: Int): Any {

        return listLanguage.get(position)

    }

    override fun getItemId(position: Int): Long {
        return position as Long

    }

    override fun getCount(): Int {

        return listLanguage.size

    }

    private class ListViewHolder(row: View) {

        var tvLanguageName: TextView
        var tvDate: TextView
        var tvLanguageDetail: TextView
        var rbRating: RatingBar
        var ivLanguage: ImageView
        var itemView:View


        init {

            tvLanguageName = row.tvLanguageName
            tvDate = row.tvDate
            tvLanguageDetail = row.tvLanguageDetail
            rbRating = row.rbRating
            ivLanguage = row.ivLanguage
            itemView=row
        }


    }


}