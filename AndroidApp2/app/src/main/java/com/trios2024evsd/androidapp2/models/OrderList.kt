package com.trios2024evsd.androidapp2.models

import android.os.Parcel
import android.os.Parcelable

class OrderList(val name: String, val orders: ArrayList<String> =
    ArrayList()) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.createStringArrayList()!!
    ) {
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeStringList(orders)
    }

    override fun describeContents()=0

    companion object CREATOR : Parcelable.Creator<OrderList> {
        override fun createFromParcel(source: Parcel): OrderList {
            return OrderList(source)
        }

        override fun newArray(size: Int): Array<OrderList?> {
            return arrayOfNulls(size)
        }
    }
}