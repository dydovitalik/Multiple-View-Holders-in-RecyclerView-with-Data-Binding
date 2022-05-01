package com.example.multipleviewholders

object Database {

    const val TYPE_HEADER = 0
    const val TYPE_ITEM = 1

    fun getItem(): ArrayList<Any> {

        val itemList = arrayListOf<Any>()

        itemList.add(DataItem.Header("13.00"))
        itemList.add(DataItem.Item(1,"Shopping"))
        itemList.add(DataItem.Item(2,"Crew meeting"))
        itemList.add(DataItem.Item(3,"Work"))
        itemList.add(DataItem.Item(4,"Phone bill"))
        itemList.add(DataItem.Item(5,"Complete the tasks"))

        itemList.add(DataItem.Header("14.00"))
        itemList.add(DataItem.Item(6,"Sport"))
        itemList.add(DataItem.Item(7,"Book"))
        itemList.add(DataItem.Item(8,"Read a story"))
        itemList.add(DataItem.Item(9,"Phone bill"))
        itemList.add(DataItem.Item(10,"Study"))

        itemList.add(DataItem.Header("15.00"))
        itemList.add(DataItem.Item(11,"Do Homework"))
        itemList.add(DataItem.Item(12,"Clean the computer"))
        itemList.add(DataItem.Item(13,"Fix the bug"))
        itemList.add(DataItem.Item(14,"Prepare"))
        itemList.add(DataItem.Item(15,"Call bank"))

        return itemList
    }
}