package com.ibnoelampard.ibnu.artinrijks.model

import android.os.Parcel
import android.os.Parcelable

open class RijksMuseumModel (val title: String, val url: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RijksMuseumModel> {
        override fun createFromParcel(parcel: Parcel): RijksMuseumModel {
            return RijksMuseumModel(parcel)
        }

        override fun newArray(size: Int): Array<RijksMuseumModel?> {
            return arrayOfNulls(size)
        }
    }
}