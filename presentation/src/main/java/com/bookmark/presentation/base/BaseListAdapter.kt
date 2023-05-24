package com.bookmark.presentation.base

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bookmark.presentation.features.comment.adapter.ClubDiffUtilCallback

abstract class BaseListAdapter<T : Any, B : ViewDataBinding>(
    @LayoutRes private val itemLayoutRes: Int,
    diffUtil: ClubDiffUtilCallback
) : ListAdapter<T, BaseListAdapter<T, B>.BaseViewHolder>(diffUtil) {

    inner class BaseViewHolder(private val binding: B) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T) {
            action(item, binding)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                itemLayoutRes,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    abstract fun action(item: T, binding: B)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(itemLayoutRes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseListAdapter> {
        override fun createFromParcel(parcel: Parcel): BaseListAdapter {
            return BaseListAdapter(parcel)
        }

        override fun newArray(size: Int): Array<BaseListAdapter?> {
            return arrayOfNulls(size)
        }
    }
}