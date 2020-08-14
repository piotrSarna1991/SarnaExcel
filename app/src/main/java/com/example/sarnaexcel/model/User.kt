package com.example.sarnaexcel.model

class User(
    name: String?,
    email: String?,
    created_at: String?,
    updated_at: String?
) :IUser{

    override var name: String = " "
    override var email: String = " "
    override var created_at: String = " "
    override var updated_at: String = " "

}