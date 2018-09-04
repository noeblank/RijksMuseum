package com.ibnoelampard.ibnu.artinrijks.model

import io.realm.RealmObject

open class SessionUserRealmData(var username: String? = null, var password: String? = null) : RealmObject()