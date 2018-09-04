package com.ibnoelampard.ibnu.artinrijks.utils.realm

import com.ibnoelampard.ibnu.artinrijks.model.SessionUserRealmData
import com.ibnoelampard.ibnu.artinrijks.model.UsersRealmData
import io.realm.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
open class RealmHelper{
    val realm : Realm = Realm.getDefaultInstance()

    fun add(realmObject: RealmObject) {
        realm.beginTransaction()
        realm.copyToRealm(realmObject)
        realm.commitTransaction()
    }

    fun truncateTable(cls: Class<out RealmObject>) {
        val results = realm.where< RealmObject>(cls.asSubclass(RealmObject::class.java) as Class<RealmObject>?).findAll()
        for (ro in results){
            realm.beginTransaction()
            ro!!.deleteFromRealm()
            realm.commitTransaction()
        }
    }

    fun getUserByUsername(username:String): UsersRealmData? {
        val user =  realm.where(UsersRealmData::class.java)
                .equalTo("username", username)
                .findFirst()
        return user
    }

    fun getUserByUsernameAndPassword(username:String, password:String): UsersRealmData? {
        val user =  realm.where(UsersRealmData::class.java)
                .equalTo("username", username)
                .equalTo("password", password)
                .findFirst()
        return user
    }

    fun getUserSession(): SessionUserRealmData? {
        val userSession =  realm.where(SessionUserRealmData::class.java).findFirst()
        return userSession
    }

    fun logout() {
        truncateTable(SessionUserRealmData::class.java)
    }

}