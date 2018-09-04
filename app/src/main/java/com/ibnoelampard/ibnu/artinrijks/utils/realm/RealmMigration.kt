package com.ibnoelampard.ibnu.artinrijks.realm

import io.realm.DynamicRealm

open class RealmMigration : io.realm.RealmMigration{
    override fun migrate(realm: DynamicRealm?, oldVersion: Long, newVersion: Long) {
    }

}