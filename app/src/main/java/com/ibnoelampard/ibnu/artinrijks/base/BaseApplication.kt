package com.ibnoelampard.ibnu.artinrijks.base

import android.app.Application
import com.ibnoelampard.ibnu.artinrijks.realm.RealmMigration
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by ibnu.isnaini on 05/03/18.
 */

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .migration(RealmMigration())
                .build()

        Realm.setDefaultConfiguration(realmConfiguration)
        Realm.getInstance(realmConfiguration)
    }
}